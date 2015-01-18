package game;

/**
 * @author cauth0n
 */
public class Game {
	private Board gameBoard;

	public Game() {

	}

	public void initializeGameBoard() {
		gameBoard = new Board();
		gameBoard.initializehexes();
		gameBoard.initializetokens();
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

}
