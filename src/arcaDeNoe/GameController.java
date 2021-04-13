/*
 * Programación interactiva
 * Autor: Laura Moayno - 202023906
 * miniProyecto 2 : juego Arca De Noe
 */
package arcaDeNoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * The Class GameController.
 */
public class GameController implements ActionListener, MouseListener {
	
	
	private  GameState model;
    private final MainView view;

    /**
     * Instantiates a new game controller.
     */
    public GameController() {
        this.model = new GameState();
        this.view = new MainView(this);
        this.getView().setHitsValue(getPoints());
    }


    /**
     * Gets the points.
     *
     * @return the points
     */
    public int getPoints() {
		return this.model.getScore();
	}


	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public MainView getView() {
		return view;
	}


	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public GameState getModel() {
        return model;
    }
	
	/**
	 * Re start game
	 */
	public void reStartGame() {
		model = new GameState();
		view.getPanel().paintButtons();
		this.getView().setHitsValue(getPoints());
	}
	
    /**
     * Action performed, determined what action is pressed
     *
     * @param e the envent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource().equals(getView().getLeave())) { 
    		System.exit(0); 
    	}
    	if(e.getSource().equals(getView().getRestart())) { 
    		this.reStartGame();
    	}
    }
    
    /**
     * Repaint view, re paint the panel buttons
     *
     * @param e the envent object
     */
    public void repaintView(ActionEvent e) {
    	view.getPanel().paintButtons();
    	this.getView().setHitsValue(getPoints());
    }

 
    /**
     * Mouse clicked.
     *
     * @param e the envent object
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    	CardButton button = (CardButton) e.getSource(); 
    	if(button.isCardSelected()) {
    		return;
    	}
    	button.setSelected(model);
    		
        //determined game
    	model.validateCards();
    	
    	//determined if game over
    	if(this.getPoints()== 0 && model.getCurrentLevel()>1) {

    		Icon icon = new ImageIcon("src/imagenes/perdiste.png");
    		int confirmado = JOptionPane.showConfirmDialog(null,"¿Deseas volver a jugar?", "¡Has  Perdido! \n",
    													JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    		if (JOptionPane.OK_OPTION == confirmado) {
    			this.reStartGame();
    		}else {
    			System.exit(0);
    		}
		}
    	
    	Timer timer = new Timer(600, this::repaintView);
    	timer.setRepeats(false);
    	timer.start();
        
	 }

	/**
	 * Mouse pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void mousePressed(MouseEvent e) {}


	/**
	 * Mouse released.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}


	/**
	 * Mouse entered.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}


	/**
	 * Mouse exited.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseExited(MouseEvent e) {}

}