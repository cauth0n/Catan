package game;

/**
 * @author cauthon
 */
public class Token {

	private int id;
	private char letter;

	public Token(int id, char letter) {
		this.id = id;
		this.letter = letter;
	}

	public int getId() {
		return id;
	}
	
	public char getLetter() {
		return letter;
	}

}
