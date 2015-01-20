package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.plaf.LayerUI;

/**
 * @author cauth0n
 */

public class TokenLayer extends LayerUI<JComponent> {

	private final double scaleFactor = 0.20;

	public TokenLayer() {
		readTokenImages();
	}

	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		Graphics2D g2d = (Graphics2D) g.create();
		buildClassicTokens(g2d);
		g2d.dispose();
	}

	public void buildClassicTokens(Graphics2D g2d) {

		List<Image> tokens = readTokenImages();
		int imageWidth = 150;
		int imageHeight = imageWidth + 25;
		int initialX = Window.borderSize + 200;
		int initialY = Window.borderSize + 50;

		// First level 3 hexes (row)
		g2d.drawImage(tokens.get(0), initialX, initialY, null);
		g2d.drawImage(tokens.get(1), initialX + imageWidth, initialY, null);
		g2d.drawImage(tokens.get(2), initialX + 2 * imageWidth, initialY, null);

		// Second level 4 hexes (row)
		int level2Y = initialY + 3 * (imageHeight / 4);
		g2d.drawImage(tokens.get(3), initialX - (imageWidth / 2), level2Y, null);
		g2d.drawImage(tokens.get(4), initialX + (imageWidth / 2), level2Y, null);
		g2d.drawImage(tokens.get(5), initialX + 3 * (imageWidth / 2), level2Y, null);
		g2d.drawImage(tokens.get(6), initialX + 5 * (imageWidth / 2), level2Y, null);

		// Third level; 5 hexes (row)
		int level3Y = initialY + 3 * (imageHeight / 2);
		g2d.drawImage(tokens.get(7), initialX - imageWidth, level3Y, null);
		g2d.drawImage(tokens.get(8), initialX, level3Y, null);
		g2d.drawImage(tokens.get(9), initialX + imageWidth, level3Y, null);
		g2d.drawImage(tokens.get(10), initialX + 2 * imageWidth, level3Y, null);
		g2d.drawImage(tokens.get(11), initialX + 3 * imageWidth, level3Y, null);

		// Fourth level; 4 hexes (row)
		int level4Y = initialY + 9 * (imageHeight / 4);
		g2d.drawImage(tokens.get(12), initialX - (imageWidth / 2), level4Y, null);
		g2d.drawImage(tokens.get(13), initialX + (imageWidth / 2), level4Y, null);
		g2d.drawImage(tokens.get(14), initialX + 3 * (imageWidth / 2), level4Y, null);
		g2d.drawImage(tokens.get(15), initialX + 5 * (imageWidth / 2), level4Y, null);

		// Fifth level 3 hexes (row)
		int level5Y = initialY + 3 * imageHeight;
		g2d.drawImage(tokens.get(16), initialX, level5Y, null);
		g2d.drawImage(tokens.get(17), initialX + imageWidth, level5Y, null);
		//g2d.drawImage(tokens.get(18), initialX + 2 * imageWidth, level5Y, null);
	}

	public List<Image> readTokenImages() {
		List<Image> tokenImages = new ArrayList<>();
		try {
			for (char c = 'A'; c <= 'R'; c++) {
				tokenImages.add(Window.scaleImage(ImageIO.read(new File("graphics/tokens/" + c + ".png")), scaleFactor));
			}

		} catch (Exception e) {
			System.out.println("Could not find token images");
		}

		return tokenImages;
	}
}
