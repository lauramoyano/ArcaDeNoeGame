/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;


/**
 * The Class Card.
 */
public class Card {

	private boolean selected;
	private int idCard;
	private int countPress;

	/**
	 * Instantiates a new card.
	 *
	 * @param ID the number of the card
	 */
	public Card(int ID) {
		this.idCard = ID;
		this.selected = false;
		this.countPress= 0;
	}
	
	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		
		return countPress;
	}

	/**
	 * Gets the selected.
	 *
	 * @return the selected
	 */
	public boolean getSelected() {
		return selected;
	}

	/**
	 * Sets the selected and sum to countPress if the card is selected
	 *
	 * @param selected the new selected
	 */
	public void setSelected(boolean selected) {
		if(selected) {
			countPress++;
		}
		this.selected = selected;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return idCard;
	}

}
