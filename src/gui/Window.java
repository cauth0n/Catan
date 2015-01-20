package gui;

import game.Board;

import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author cauth0n
 */
public class Window {
	private JFrame frame;
	private final int windowWidth = 1200;
	private final int windowHeight = 900;

	public Window(Board gameBoard) {
		frame = new JFrame("CATAN DOOOD");
		frame.setSize(windowWidth, windowHeight);
		buildPanel(gameBoard);
		frame.setLocation(50, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void buildPanel(Board gameBoard){
		Container contentPane = frame.getContentPane();
		contentPane.add(new CatanPanel(windowWidth, windowHeight, gameBoard));
		frame.setContentPane(contentPane);
		
	}
	

}
