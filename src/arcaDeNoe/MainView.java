/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 * The Class MainView.
 */
public class MainView extends JFrame {
	
	
	private CardsPanel principalPanel;
	private final GameController controller;
	private Titulos titulo;
	private JButton leave;
	private JButton restart;
	private JLabel points;
	private JTextField inputScore;
	

	/**
	 * Instantiates a new main view.
	 *
	 * @param ctrl the ctrl
	 */
	public MainView(GameController ctrl) {
		this.controller = ctrl;
		
		initGUI();
       
		// set default window configuration
		this.setUndecorated(true);
		this.setBackground(new Color(255,255,255));
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Inits the GUI, instantiates the components of the view
	 */
	private void initGUI() {
		// TODO Auto-generated method stub
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		//config principalPanel
		principalPanel = new CardsPanel(getController());
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 4;
		constraints.gridheight = 3;
		constraints.fill = GridBagConstraints.NONE;

		add(principalPanel, constraints);
		
		//config title
		titulo = new Titulos("Arca De Noe", 35, new Color(0, 204, 203));
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;

		add(titulo, constraints);
		
		
		// config button leave
		leave = new JButton("Salir Juego");
		leave.addActionListener(getController());
		leave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leave.setBorder(BorderFactory.createLineBorder(Color.GRAY,4));
		constraints.gridx = 3;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LAST_LINE_END;

		add(leave, constraints);
		
		// config button restart
		restart = new JButton("Reiniciar Partida");
		restart.addActionListener(getController());
		restart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		restart.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LAST_LINE_START;
		add(restart, constraints);
		
		//config puntos
		points = new JLabel("Puntos");
		Border border = BorderFactory.createLineBorder(new Color(153,128,128), 4);
		points.setBorder(border);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
	
		
		add(points, constraints);
		
		//config JTextField
		inputScore = new JTextField(5);
		inputScore.setEditable(false);
		inputScore.setBackground(new Color(255,255,255));
		inputScore.setBorder(border);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
	
		add(inputScore, constraints);

		
	}

	
	/**
	 * Gets the restart.
	 *
	 * @return the restart
	 */
	public JButton getRestart() {
		return restart;
	}

	/**
	 * Gets the panel.
	 *
	 * @return the panel
	 */
	public CardsPanel getPanel() {
		return principalPanel;
	}
	
	/**
	 * Gets the leave.
	 *
	 * @return the leave
	 */
	public JButton getLeave() {
		return leave;
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public GameController getController() {
		return controller;
	}
	
	/**
	 * Sets the inputScore value.
	 *
	 * @param value the new inutScore value
	 */
	public void setHitsValue(int value) {
		this.inputScore.setText(String.valueOf(value));
	}

}
