/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;

import java.util.ArrayList;
import java.util.Collections;


/**
 * The Class GameState.
 */
public class GameState {

	private int score;
	private ArrayList<Card> cards;
	private int numberOfPairs;
	private Card firstCard;
	private Card secondCard;
	private int currentLevel;
	private int countPairs;

	/**
	 * Instantiates a new game state.
	 */
	public GameState() {
		
		this.numberOfPairs = 2;
		this.score= 0;
		this.firstCard= null;
		this.secondCard= null;
		this.countPairs = 0;
		this.currentLevel = 1;
		initArray(numberOfPairs);
		
	}

	/**
	 * Instantiates a ArrayCards with  a number of pairs
	 *
	 * @param numberOfPairs the number of pairs
	 */
	public void initArray(int numberOfPairs) {  

		this.cards = new ArrayList<Card>(); 

		for (int i = 0; i <numberOfPairs ; i++) { 
			cards.add(new Card(i));
			
			cards.add(new Card(i));
			
			if(cards.size() == 14) {
				break; 
			}
		}
		
		Collections.shuffle(cards);
	}


	/**
	 * Gets the array cards.
	 *
	 * @return the array cards
	 */
	public ArrayList<Card> getArrayCards() {
		return cards;
	}
	
	
	/**
	 * Sets the firstCard if the firstCard is selected set the secondCard
	 *
	 * @param card the new selection
	 */
	public void setSelection(Card card) {
		if(this.firstCard == null) {
			this.firstCard = card;
		}else {
			this.secondCard = card;
		}
		card.setSelected(true);
	}
	
	/**
	 * verify if firstCard and secondCard are equal
	 *
	 * @return true, if successful
	 */
	public boolean areSelectedCardsEqual() {
		
		return firstCard.getID() == secondCard.getID();
	}
	
	/**
	 *  if firstCards and secondCard is different null and are equals 
	 *  sum to score and remove cards of the array and countpairs +1 
	 *  if all the cards in the array was remove passlevel
	 *
	 * @return true, if are equals
	 * @return false, if aren't equals
	 */
	public boolean validateCards() {
		if(firstCard != null && secondCard != null) {
			if(areSelectedCardsEqual()) {
				
				//we need sum points
				score += 10;
				// We need to remove the matched cards
				this.cards.remove(firstCard);
				this.cards.remove(secondCard);
				// Increase the validations counter
				this.countPairs++;
				
				this.passLevel();
				
				this.resetSelections();
				return true;
			}
			
			this.determinedScore();
			this.resetSelections();
		}
		return false;
	}
	
	
	/**
	 * Determined game.
	 *
	 * @return true, if successful
	 */
	public boolean determinedGame() {
		if(countPairs == numberOfPairs) {
			return true;
		}
		
		return false; 
	}
	
	/**
	 * if determinedGame() create a new array with one pair more
	 */
	public void passLevel() {
		if(determinedGame()) {
			numberOfPairs++;
			countPairs = 0;
			currentLevel++;
			initArray(numberOfPairs);
			
		}
	}
	

	/**
	 * Gets the current level.
	 *
	 * @return the current level
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * determines when to subtract from the score or if the score is 0 can't subtract more
	 */
	public void determinedScore() {
		if(score != 0 && wasSelectedTwice()) {
			score = score - 10;
			
		}else if(score < 0) {
			score = 0;
		}
		
	}
	
	/**
	 * Reset selections of the firstCard and the SecondCard
	 */
	public void resetSelections() {
		this.firstCard.setSelected(false);
		this.secondCard.setSelected(false);
		
		this.firstCard = null;
		this.secondCard = null;
	}
	
	/**
	 * verify if secondCard or firstCard are selected twice
	 *
	 * @return true, if successful
	 */
	private boolean wasSelectedTwice() {
		return firstCard.getCount() >= 2 || secondCard.getCount() >= 2;
	}
	
}
