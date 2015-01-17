package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author cauth0n
 */
public class CatanPanel extends JPanel {

	private BufferedImage forestHex;
	private BufferedImage pastureHex;
	private BufferedImage mountainHex;
	private BufferedImage grainHex;
	private BufferedImage desertHex;
	private BufferedImage hillHex;
	private BufferedImage waterHex;
	
	
	private int windowWidth;
	private int windowHeight;

	public CatanPanel(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		readImages();
		initializePanel();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		buildClassicBoard(g);
	}
	
	public void buildClassicBoard(Graphics g){
		g.drawImage(forestHex, 0, 0, 250, 250, null);
		g.drawImage(pastureHex, 100, 100, null);
	}

	public void initializePanel() {
		repaint();
	}

	public void addTokens() {

	}

	public void readImages() {
		try {
			forestHex = ImageIO.read(new File("graphics/Forest.png"));
			pastureHex = ImageIO.read(new File("graphics/Pasture.png"));
			mountainHex = ImageIO.read(new File("graphics/Mountains.png"));
			grainHex = ImageIO.read(new File("graphics/Wheat.png"));
			desertHex = ImageIO.read(new File("graphics/Desert.png"));
			hillHex = ImageIO.read(new File("graphics/Brick.png"));
			waterHex = ImageIO.read(new File("graphics/WATAH.png"));

		} catch (Exception e) {
			System.out.println("Image files are wrong");
		}
	}

}
