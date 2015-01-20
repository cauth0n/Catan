package gui;

import game.Hex;
import game.HexType;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author cauth0n
 */
public class HexPanel extends JPanel {

	private List<Hex> hexes;
	private Image forestHex;
	private Image pastureHex;
	private Image mountainHex;
	private Image grainHex;
	private Image desertHex;
	private Image hillHex;

	// water is not being used now, but we will have it eventually.
	private Image waterHex;

	private final double imageXYScaleFactor = 0.50;

	public HexPanel(List<Hex> hexes) {

		this.hexes = hexes;
		readAndScaleImages();
		initializePanel();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		buildClassicLayout(g);
	}

	public void buildClassicLayout(Graphics g) {

		// only using the width and height of the forest hex; therefore, the image stitching might get a little rough
		int imageWidth = forestHex.getWidth(null);
		int imageHeight = forestHex.getHeight(null);
		int initialX = Window.borderSize + imageWidth;
		int initialY = Window.borderSize;

		// First level 3 hexes (row)
		g.drawImage(getImageFromHexType(hexes.get(0).getHexType()), initialX, initialY, null);
		g.drawImage(getImageFromHexType(hexes.get(1).getHexType()), initialX + imageWidth, initialY, null);
		g.drawImage(getImageFromHexType(hexes.get(2).getHexType()), initialX + 2 * imageWidth, initialY, null);

		// Second level 4 hexes (row)
		int level2Y = initialY + 3 * (imageHeight / 4);
		g.drawImage(getImageFromHexType(hexes.get(3).getHexType()), initialX - (imageWidth / 2), level2Y, null);
		g.drawImage(getImageFromHexType(hexes.get(4).getHexType()), initialX + (imageWidth / 2), level2Y, null);
		g.drawImage(getImageFromHexType(hexes.get(5).getHexType()), initialX + 3 * (imageWidth / 2), level2Y, null);
		g.drawImage(getImageFromHexType(hexes.get(6).getHexType()), initialX + 5 * (imageWidth / 2), level2Y, null);

		// Third level; 5 hexes (row)
		int level3Y = initialY + 3 * (imageHeight / 2);
		g.drawImage(getImageFromHexType(hexes.get(7).getHexType()), initialX - imageWidth, level3Y, null);
		g.drawImage(getImageFromHexType(hexes.get(8).getHexType()), initialX, level3Y, null);
		g.drawImage(getImageFromHexType(hexes.get(9).getHexType()), initialX + imageWidth, level3Y, null);
		g.drawImage(getImageFromHexType(hexes.get(10).getHexType()), initialX + 2 * imageWidth, level3Y, null);
		g.drawImage(getImageFromHexType(hexes.get(11).getHexType()), initialX + 3 * imageWidth, level3Y, null);

		// Fourth level; 4 hexes (row)
		int level4Y = initialY + 9 * (imageHeight / 4);
		g.drawImage(getImageFromHexType(hexes.get(12).getHexType()), initialX - (imageWidth / 2), level4Y, null);
		g.drawImage(getImageFromHexType(hexes.get(13).getHexType()), initialX + (imageWidth / 2), level4Y, null);
		g.drawImage(getImageFromHexType(hexes.get(14).getHexType()), initialX + 3 * (imageWidth / 2), level4Y, null);
		g.drawImage(getImageFromHexType(hexes.get(15).getHexType()), initialX + 5 * (imageWidth / 2), level4Y, null);

		// Fifth level 3 hexes (row)
		int level5Y = initialY + 3 * imageHeight;
		g.drawImage(getImageFromHexType(hexes.get(16).getHexType()), initialX, level5Y, null);
		g.drawImage(getImageFromHexType(hexes.get(17).getHexType()), initialX + imageWidth, level5Y, null);
		g.drawImage(getImageFromHexType(hexes.get(18).getHexType()), initialX + 2 * imageWidth, level5Y, null);
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

	public void readAndScaleImages() {
		try {
			forestHex = Window.scaleImage(ImageIO.read(new File("graphics/Forest.png")), imageXYScaleFactor);
			pastureHex = Window.scaleImage(ImageIO.read(new File("graphics/Pasture.png")), imageXYScaleFactor);
			mountainHex = Window.scaleImage(ImageIO.read(new File("graphics/Mountains.png")), imageXYScaleFactor);
			grainHex = Window.scaleImage(ImageIO.read(new File("graphics/Wheat.png")), imageXYScaleFactor);
			desertHex = Window.scaleImage(ImageIO.read(new File("graphics/Desert.png")), imageXYScaleFactor);
			hillHex = Window.scaleImage(ImageIO.read(new File("graphics/Brick.png")), imageXYScaleFactor);
			waterHex = Window.scaleImage(ImageIO.read(new File("graphics/WATAH.png")), imageXYScaleFactor);

		} catch (Exception e) {
			System.out.println("Image files are wrong");
		}
	}

}
