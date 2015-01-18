package game;

import gui.Window;

/**
 * @author cauthon
 */
public class Driver {

	public static void main(String[] args) {

		Game game = new Game();
		game.initializeGameBoard();
		new Window(game.getGameBoard());

	}

}
