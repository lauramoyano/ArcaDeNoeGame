/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;


import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;



/**
 * The Class CardsPanel.
 */
public class CardsPanel extends JPanel {

	
	private final GameController controller;
	private final ArrayList<CardButton> buttons;

	/**
	 * Instantiates a new cards panel.
	 *
	 * @param ctrl the ctrl
	 */
	public CardsPanel(GameController ctrl) {
		super();
		
		this.controller = ctrl;
		this.setPreferredSize(new Dimension(610, 575));
		buttons = new ArrayList<CardButton>();
		
		paintButtons();
	}

	/**
	 * Paint buttons.
	 */
	public void paintButtons() {
		this.removeAll();

		for(int i=0; i < this.controller.getModel().getArrayCards().size(); i++) {
			CardButton button = buildButtonFromCard(this.controller.getModel().getArrayCards().get(i));
			
			buttons.add(button);
			this.add(button);
		}
		
		this.revalidate();
		this.repaint();
	}
	

	/**
	 * Builds the button from card.
	 *
	 * @param card the card
	 * @return the card button
	 */
	private CardButton buildButtonFromCard(Card card) {
		CardButton btn = new CardButton(controller, card);
		if(card.getSelected()) {
			btn.setSelected();	
		}
		
		return btn;
	}
	
	
}
