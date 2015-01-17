package gui;

import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author cauth0n
 */
public class Window {
	private JFrame frame;
	private final int windowWidth = 1100;
	private final int windowHeight = 900;

	public Window() {
		frame = new JFrame("CATAN DOOOD");
		frame.setSize(windowWidth, windowHeight);
		buildPanel();
		frame.setLocation(50, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void buildPanel(){
		Container contentPane = frame.getContentPane();
		contentPane.add(new CatanPanel(windowWidth, windowHeight));
		frame.setContentPane(contentPane);
		
	}
	

}
