package game;

/**
 * @author cauthon
 */
public class Settlement {

	private Hex hex1;
	private Hex hex2;
	private Hex hex3;

	public Settlement(Hex hex1_in, Hex hex2_in, Hex hex3_in) {

		this.hex1 = hex1_in;
		this.hex2 = hex2_in;
		this.hex3 = hex3_in;

	}

	public Hex getHex1() {
		return hex1;
	}

	public void setHex1(Hex hex1) {
		this.hex1 = hex1;
	}

	public Hex getHex2() {
		return hex2;
	}

	public void setHex2(Hex hex2) {
		this.hex2 = hex2;
	}

	public Hex getHex3() {
		return hex3;
	}

	public void setHex3(Hex hex3) {
		this.hex3 = hex3;
	}

}
