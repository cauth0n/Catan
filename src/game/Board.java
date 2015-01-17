package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author cauthon
 */

public class Board {
	
	ArrayList<Token> tokenboard = new ArrayList<>();
	ArrayList<Hex> hexboard = new ArrayList<>();

	public Board() {
		initializehexes();
		initializetokens();
	
	}

	public void initializehexes() {

		int totalhex = 0;
		int totalbrick = 0;
		int totallumber = 0;
		int totalsheep = 0;
		int totalwheat = 0;
		int totalore = 0;
		int totaldesert = 0;

		while (totalhex < 19) {
			
			Random hexagon = new Random();
			int hex = hexagon.nextInt(6);
			if (hex == 0 && totalbrick != 3) {
				hexboard.add(new Hex(HexType.hills));
				totalbrick++;
				totalhex++;
			} else if (hex == 1 && totallumber != 4) {
				hexboard.add(new Hex(HexType.forest));
				totallumber++;
				totalhex++;
			} else if (hex == 2 && totalsheep != 4) {
				hexboard.add(new Hex(HexType.pasture));
				totalsheep++;
				totalhex++;
			} else if (hex == 3 && totalwheat != 4) {
				hexboard.add(new Hex(HexType.fields));
				totalwheat++;
				totalhex++;
			} else if (hex == 4 && totalore != 3) {
				hexboard.add(new Hex(HexType.mountains));
				totalore++;
				totalhex++;
			} else if (hex == 5 && totaldesert != 1) {
				hexboard.add(new Hex(HexType.desert));
				totaldesert++;
				totalhex++;
			}
		}

	}
	
	public void initializetokens() {
		
		tokenboard.add(new Token(5, 'A'));
		tokenboard.add(new Token(2, 'B'));
		tokenboard.add(new Token(6, 'C'));
		tokenboard.add(new Token(3, 'D'));
		tokenboard.add(new Token(8, 'E'));
		tokenboard.add(new Token(10, 'F'));
		tokenboard.add(new Token(9, 'G'));
		tokenboard.add(new Token(12, 'H'));
		tokenboard.add(new Token(11, 'I'));
		tokenboard.add(new Token(4, 'J'));
		tokenboard.add(new Token(8, 'K'));
		tokenboard.add(new Token(10, 'L'));
		tokenboard.add(new Token(9, 'M'));
		tokenboard.add(new Token(4, 'N'));
		tokenboard.add(new Token(5, 'O'));
		tokenboard.add(new Token(6, 'P'));
		tokenboard.add(new Token(3, 'Q'));
		tokenboard.add(new Token(11, 'R'));
		Collections.shuffle(tokenboard);
		
		}
	
	public void tokenassignment() {
		for(int i = 0; i < hexboard.size(); i++) {
			if (hexboard.get(i).gethextype() == HexType.desert) {
				tokenboard.set(i, null);
			}
			
		}
	}
}
