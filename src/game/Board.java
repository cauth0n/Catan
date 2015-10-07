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

		Collections.shuffle(hexboard);

	}

	public void initializetokens() {
		ArrayList<Token> listOfTokens = new ArrayList<>();
		
		listOfTokens.add(new Token(5, 'A'));
		listOfTokens.add(new Token(2, 'B'));
		listOfTokens.add(new Token(6, 'C'));
		listOfTokens.add(new Token(3, 'D'));
		listOfTokens.add(new Token(8, 'E'));
		listOfTokens.add(new Token(10, 'F'));
		listOfTokens.add(new Token(9, 'G'));
		listOfTokens.add(new Token(12, 'H'));
		listOfTokens.add(new Token(11, 'I'));
		listOfTokens.add(new Token(4, 'J'));
		listOfTokens.add(new Token(8, 'K'));
		listOfTokens.add(new Token(10, 'L'));
		listOfTokens.add(new Token(9, 'M'));
		listOfTokens.add(new Token(4, 'N'));
		listOfTokens.add(new Token(5, 'O'));
		listOfTokens.add(new Token(6, 'P'));
		listOfTokens.add(new Token(3, 'Q'));
		listOfTokens.add(new Token(11, 'R'));
		Token desertToken = new Token(0, 'Z');
		
		Collections.shuffle(listOfTokens);

		for (int i = 0; i < hexboard.size(); i++) {
			if (hexboard.get(i).getHexType() != HexType.desert) {
				tokenboard.add(i, listOfTokens.get(i));
			} else {
				tokenboard.add(i, desertToken);
				// We need to add this to the listOfTokens as well,
				// so the lists stay the same size
				listOfTokens.add(i, desertToken);
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
