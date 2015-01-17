package game;

import java.util.Random;

public class Roll {
	Random dice = new Random();
		int rand1 = dice.nextInt(6) + 1;
		int rand2 = dice.nextInt(6) + 1;
		int roll = rand1 + rand2;

}
