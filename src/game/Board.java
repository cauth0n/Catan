package game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author cauthon
 */

public class Board {

	private ArrayList<Token> tokenboard = new ArrayList<>();
	private ArrayList<Hex> hexboard = new ArrayList<>();
	private ArrayList<ResourceCard> bank = new ArrayList<>();
	private ArrayList<DevCard> devbank = new ArrayList<>();
	private ArrayList<Ports> ports = new ArrayList<>();

	public Board() {

	}
	
	public void initializeports() {
		ports.add(new Ports(PortType.brick));
		ports.add(new Ports(PortType.lumber));
		ports.add(new Ports(PortType.sheep));
		ports.add(new Ports(PortType.wheat));
		ports.add(new Ports(PortType.ore));
		
		for (int i = 0; i < 4; i++) {
			ports.add(new Ports(PortType.random));
		}
		
		Collections.shuffle(ports);
	}

	public void initializebank() {

		for (int i = 0; i < 19; i++) {
			bank.add(new ResourceCard(ResourceType.brick));
			bank.add(new ResourceCard(ResourceType.lumber));
			bank.add(new ResourceCard(ResourceType.sheep));
			bank.add(new ResourceCard(ResourceType.wheat));
			bank.add(new ResourceCard(ResourceType.ore));
		}

	}

	public void initializedevbank() {

		for (int i = 0; i < 14; i++) {
			devbank.add(new DevCard(DevType.knights));
		}

		for (int i = 0; i < 5; i++) {
			devbank.add(new DevCard(DevType.victorypoint));
		}

		for (int i = 0; i < 2; i++) {
			devbank.add(new DevCard(DevType.roadbuilding));
			devbank.add(new DevCard(DevType.monopoly));
			devbank.add(new DevCard(DevType.yearofplenty));
		}

		Collections.shuffle(devbank);
	}

	public void initializehexes() {

		for (int i = 0; i < 3; i++) {
			hexboard.add(new Hex(HexType.hills));
		}

		for (int i = 0; i < 4; i++) {
			hexboard.add(new Hex(HexType.pasture));
		}

		for (int i = 0; i < 3; i++) {
			hexboard.add(new Hex(HexType.mountains));
		}

		for (int i = 0; i < 4; i++) {
			hexboard.add(new Hex(HexType.fields));
		}

		for (int i = 0; i < 4; i++) {
			hexboard.add(new Hex(HexType.forest));
		}

		hexboard.add(new Hex(HexType.desert));

		System.out.println(hexboard.size());

		Collections.shuffle(hexboard);

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

	}

	public void tokenassignment() {
		for (int i = 0; i < hexboard.size(); i++) {
			if (hexboard.get(i).getHexType() == HexType.desert) {
				tokenboard.set(i, null);
			}

		}
	}

	public ArrayList<Token> getTokenboard() {
		return tokenboard;
	}

	public void setTokenboard(ArrayList<Token> tokenboard) {
		this.tokenboard = tokenboard;
	}

	public ArrayList<Hex> getHexboard() {
		return hexboard;
	}

	public void setHexboard(ArrayList<Hex> hexboard) {
		this.hexboard = hexboard;
	}

}
