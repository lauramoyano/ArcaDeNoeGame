/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The Class CardButton.
 */
public class CardButton extends JButton {

	private static final ImageIcon UNSELECTED_ICON = new ImageIcon("src/imagenes/null.jpg");
	private final Card card;
	private Icon image;

	/**
	 * Instantiates a new card button.
	 *
	 * @param listener the listener
	 * @param card the card
	 */
	public CardButton(MouseListener listener, Card card) {
		super(UNSELECTED_ICON);
		
		this.card = card;
		this.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 205), 4));
		this.addMouseListener(listener);
	}

	/**
	 * change the image acording to id of the card.
	 */
	public void setSelected() {
		image = new ImageIcon("src/imagenes/" + String.valueOf(this.card.getID()) + ".jpg");
		this.setIcon(image);
	} 
	
	/**
	 * change the state of the card to setSelected and in the GameState make a selection  with this.card
	 *
	 * @param state the new selected
	 */
	public void setSelected(GameState state) {
		this.setSelected();
		state.setSelection(this.card);
	}

	
	/**
	 * Checks if is card selected.
	 *
	 * @return true, if is card selected
	 */
	public boolean isCardSelected() {
		return this.card.getSelected() == true;
	}
}
