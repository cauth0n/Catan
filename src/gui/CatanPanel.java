package gui;

import game.Board;
import game.HexType;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author cauth0n
 */
public class CatanPanel extends JPanel {

	private Board gameBoard;
	private Image forestHex;
	private Image pastureHex;
	private Image mountainHex;
	private Image grainHex;
	private Image desertHex;
	private Image hillHex;
	private Image waterHex;

	private int windowWidth;
	private int windowHeight;
	private final int borderSize = 25;
	private final double imageXYScaleFactor = 0.50;

	public CatanPanel(int windowWidth, int windowHeight, Board gameBoard) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.gameBoard = gameBoard;
		readAndScaleImages();
		initializePanel();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		buildClassicBoard(g);
	}

	public void buildClassicBoard(Graphics g) {
		int imageWidth = forestHex.getWidth(null);
		int imageHeight = forestHex.getHeight(null);
		int initialX = borderSize + imageWidth;
		int initialY = borderSize;

		// First level 3 hexes (row)
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(0).getHexType()), initialX, initialY, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(1).getHexType()), initialX + imageWidth, initialY, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(2).getHexType()), initialX + 2 * imageWidth, initialY, null);

		// Second level 4 hexes (row)
		int level2Y = initialY + 3 * (imageHeight / 4) ;
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(3).getHexType()), initialX - (imageWidth / 2), level2Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(4).getHexType()), initialX + (imageWidth / 2), level2Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(5).getHexType()), initialX + 3 * (imageWidth / 2), level2Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(6).getHexType()), initialX + 5 * (imageWidth / 2), level2Y, null);

		// Third level; 5 hexes (row)
		int level3Y = initialY + 3 * (imageHeight / 2);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(7).getHexType()), initialX - imageWidth, level3Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(8).getHexType()), initialX, level3Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(9).getHexType()), initialX + imageWidth, level3Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(10).getHexType()), initialX + 2 * imageWidth, level3Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(11).getHexType()), initialX + 3 * imageWidth, level3Y, null);
		
		//Fourth level; 4 hexes (row)
		int level4Y = initialY + 9 * (imageHeight / 4) ;
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(12).getHexType()), initialX - (imageWidth / 2), level4Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(13).getHexType()), initialX + (imageWidth / 2), level4Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(14).getHexType()), initialX + 3 * (imageWidth / 2), level4Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(15).getHexType()), initialX + 5 * (imageWidth / 2), level4Y, null);
	
		// Fifth level 3 hexes (row)
		int level5Y = initialY + 3 * imageHeight ;
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(0).getHexType()), initialX, level5Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(1).getHexType()), initialX + imageWidth, level5Y, null);
		g.drawImage(getImageFromHexType(gameBoard.getHexboard().get(2).getHexType()), initialX + 2 * imageWidth, level5Y, null);
	}

	
	public Image getImageFromHexType(HexType hexType) {
		Image toRet = null;
		switch (hexType) {
		case desert:
			toRet = desertHex;
			break;
		case fields:
			toRet = grainHex;
			break;
		case forest:
			toRet = forestHex;
			break;
		case hills:
			toRet = hillHex;
			break;
		case mountains:
			toRet = mountainHex;
			break;
		case pasture:
			toRet = pastureHex;
			break;
		default:
			System.out.println("Could not find an image from the given hex type");
		}

		return toRet;
	}

	public void initializePanel() {
		repaint();
	}

	public void addTokens() {

	}

	public void readAndScaleImages() {
		try {
			forestHex = scaleImage(ImageIO.read(new File("graphics/Forest.png")));
			pastureHex = scaleImage(ImageIO.read(new File("graphics/Pasture.png")));
			mountainHex = scaleImage(ImageIO.read(new File("graphics/Mountains.png")));
			grainHex = scaleImage(ImageIO.read(new File("graphics/Wheat.png")));
			desertHex = scaleImage(ImageIO.read(new File("graphics/Desert.png")));
			hillHex = scaleImage(ImageIO.read(new File("graphics/Brick.png")));
			waterHex = scaleImage(ImageIO.read(new File("graphics/WATAH.png")));

		} catch (Exception e) {
			System.out.println("Image files are wrong");
		}
	}

	public Image scaleImage(BufferedImage image) {
		return image.getScaledInstance((int) (image.getWidth() * imageXYScaleFactor), (int) (image.getHeight() * imageXYScaleFactor), 0);
	}

}
