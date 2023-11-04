package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Mode {
	protected char id;
	private static ArrayList<Mode> gamemodes = new ArrayList<>(Arrays.asList(new ModeA(), new ModeB(), new ModeC()));

	public static Mode selectGamemode(char a) {
		return gamemodes.stream().filter(modo -> modo.applies(a)).collect(Collectors.toList()).get(0);
	}
	public boolean applies(char a) {
		return id==a;
	}
	
	public boolean equals(Mode m) {
		return id==m.getId();
	}
	public char getId() {
		return id;

	}
	protected boolean checkVerticallyAndHorizontally(char player, CuatroEnLinea tablero) {
		ArrayList<Boolean> verify_list= new ArrayList<>();
		verify_list.add(verifyVertical(player, tablero));
		verify_list.add(verifyHorizontal(player, tablero));
		return verify_list.stream().anyMatch(b -> b);		//EMILIO
	}
	
	
	protected boolean checkDiagonally(char player, CuatroEnLinea juego) {
		ArrayList<Boolean> chequeos = new ArrayList<>();
		for (int i =1; i<=juego.getHeight(); i++) {
			chequeos.add(checkDiagonalRight(player,juego, 0,juego.getHeight()-i));
			chequeos.add(checkDiagonalLeft(player,juego, juego.getBase()-1,juego.getHeight()-i));
		}
		for (int i =1; i<juego.getBase(); i++) {
			chequeos.add(checkDiagonalRight(player,juego, i,0));
			chequeos.add(checkDiagonalLeft(player,juego, juego.getBase()-1-i,0));
		}

		return (chequeos.stream().anyMatch(b->b));
	}
	
	
	protected boolean verifyVertical(char player, CuatroEnLinea juego){
		int counter=0;
		for (int i=0;i<juego.getBase();i++ ) {
			counter = 0;
			ArrayList<Character> column = juego.getBoard().get(i);
			for (int a=0; a<column.size(); a++) {
				if(column.get(a)==player) {
					counter++;
					if (counter==4) {
						return true;}
				}else {
					counter=0;
				}
			}
		}
		return false;
	}
	protected boolean verifyHorizontal(char player, CuatroEnLinea juego){
		int counter;
		for(int i=0 ; i<juego.getHeight(); i++) {
			counter=0;
			for (int col=0; col<juego.getBase();col++) {
				 if(juego.getBoard().get(col).size()-1>=i) {
					if(juego.getBoard().get(col).get(i)==player) {
						counter++;
						if (counter==4) {
							return true;}
					}else {
						counter=0;
					}
				}else {
					counter=0;
				}
			}
		}
		return false;
	
		
	}
	
	protected boolean checkDiagonalRight(char player, CuatroEnLinea juego, int startingX, int startingY) {
		int counter=0;
		int j = startingY;
		for (int i=startingX; i<=juego.getBase()-1; i++ ) {
			if ((juego.getBoard().get(i).size()-1>=j)) {
				if (juego.getBoard().get(i).get(j)==player) {
					counter++;
					if (counter==4) {
						return true;    }
				}
				else {counter=0;}
			}
			else {counter=0;}
			j++;
		}
		return false;
		
	}
	
	protected boolean checkDiagonalLeft(char player, CuatroEnLinea juego, int startingX, int startingY) {
		int counter=0;
		int j = startingY;
		for (int x=startingX; x>=0; x-- ) {
			if ((juego.getBoard().get(x).size()-1>=j)) {
				if (juego.getBoard().get(x).get(j)==player) {
					counter++;
					if (counter==4) {
						return true;    }
				}
				else {counter=0;}
			}
			else {counter=0;}
			j++;
		}
		return false;
	}
	
	
	
	
	public abstract boolean checkIfBlueWon(CuatroEnLinea tablero);
	public abstract boolean checkIfRedWon(CuatroEnLinea tablero);

}