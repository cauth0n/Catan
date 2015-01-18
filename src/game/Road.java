package game;

public class Road {
	private Hex hex1;
	private Hex hex2;

	public Road(Hex hex1_in, Hex hex2_in) {
		this.hex1 = hex1_in;
		this.hex2 = hex2_in;
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
}