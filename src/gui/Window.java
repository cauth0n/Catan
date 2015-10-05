package gui;

import game.Board;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.plaf.LayerUI;

/**
 * @author cauth0n
 */
public class Window {
	private JFrame frame;
	private final int windowWidth = 1200;
	private final int windowHeight = 900;
	public final static int borderSize = 25;

	public Window(Board gameBoard) {
		frame = new JFrame("CATAN DOOOD");
		frame.setSize(windowWidth, windowHeight);

		buidlClassicLayeredPanel(gameBoard);
		frame.setLocation(50, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void buidlClassicLayeredPanel(Board gameBoard) {

		JPanel hexes = new HexPanel(gameBoard.getHexboard());

		LayerUI<JComponent> layerUI = new TokenLayer(gameBoard.getTokenboard());
		JLayer<JComponent> jLayer = new JLayer<JComponent>(hexes, layerUI);

		frame.add(jLayer);

	}

	public static Image scaleImage(BufferedImage imageToScale, double scaleFactor) {
		return imageToScale.getScaledInstance((int) (imageToScale.getWidth() * scaleFactor), (int) (imageToScale.getHeight() * scaleFactor), 0);
	}
}
