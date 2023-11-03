package linea;

import java.util.ArrayList;

public class ModeB extends Mode{
	public ModeB() {
		id='B';
	}

	
	public boolean checkIfBlueWon(CuatroEnLinea juego) {
		ArrayList<Boolean> chequeos = new ArrayList<>();
		for (int i =1; i<=juego.getBoard().get(0).size(); i++) {
			chequeos.add(checkDiagonalRight('B',juego, 0,juego.getBoard().get(0).size()-i));
		}
		for (int i =1; i<juego.getBase(); i++) {
			chequeos.add(checkDiagonalRight('B',juego, i,0));
		}

		return (chequeos.stream().anyMatch(b->b));
	}


	public boolean checkIfRedWon(CuatroEnLinea juego) {
		ArrayList<Boolean> chequeos = new ArrayList<>();
		for (int i =1; i<=juego.getBoard().get(0).size(); i++) {
			chequeos.add(checkDiagonalRight('R',juego, 0,juego.getBoard().get(0).size()-i));
		}
		for (int i =1; i<juego.getBase(); i++) {
			chequeos.add(checkDiagonalRight('R',juego, i,0));
		}

		return (chequeos.stream().anyMatch(b->b));
	}
}
