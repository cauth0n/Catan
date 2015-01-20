package game;

public class Game {

/**
 * @author cauth0n
 */

	private Board gameBoard;

	public Game() {

	}

	public void initializeGameBoard() {
		gameBoard = new Board();
		gameBoard.initializehexes();
		gameBoard.initializetokens();
		gameBoard.initializebank();
		gameBoard.initializedevbank();
		gameBoard.initializeports();
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}


}
