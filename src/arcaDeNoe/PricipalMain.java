/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;

import java.awt.EventQueue;

/**
 * The Main class
 */
public class PricipalMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override 
			public void run() { // TODO Auto-generated method stub new VistaGUI
				GameController controller = new GameController();
				 
			}

		});



	}
}
