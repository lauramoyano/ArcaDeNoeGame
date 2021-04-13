/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * The Class Titulos.
 */
public class Titulos extends JLabel {
	
	/**
	 * Instantiates a new title with the font and
	 * specifications like size, color and the text
	 *
	 * @param texto the title
	 * @param tamano the size of the font
	 * @param colorFondo the color of the background 
	 */
	//metodos
	public Titulos (String texto, int tamano, Color colorFondo) {
		
		this.setText(texto);
		Font font = new Font(Font.SERIF, Font.BOLD+Font.ITALIC, tamano);
		this.setFont(font);
		this.setBackground(colorFondo);
		this.setForeground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
		
	}
}

