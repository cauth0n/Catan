package game;

import java.util.ArrayList;

public class Cards {

	ArrayList<DevType> devcard = new ArrayList<>();

	public void initializedevcards() {
		for (int i = 0; i < 14; i++) {
			devcard.add(DevType.knights);
		}
		for (int i = 0; i < 5; i++) {
			devcard.add(DevType.victorypoint);
		}
		for (int i = 0; i < 14; i++) {
			devcard.add(DevType.knights);
		}
		for (int i = 0; i < 14; i++) {
			devcard.add(DevType.knights);
		}
		for (int i = 0; i < 14; i++) {
			devcard.add(DevType.knights);
		}
	}

}
