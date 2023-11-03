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
	protected boolean verifyVertical(char player, CuatroEnLinea juego){
		int counter=0;
		for (int i=0;i<juego.getBoardSize();i++ ) {
			counter = 0;
			ArrayList<Character> column = juego.getBoard().get(i);
			for (int a=0; a<column.size(); a++) {
				if (counter==4) {
					return true;
					
				}else if(column.get(a)==player) {
					counter++;
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
			for (int col=0; col<juego.getBoardSize();col++) {
				if (counter==4) {
					return true;
				}else if(juego.getBoard().get(col).size()-1>=i) {
					if(juego.getBoard().get(col).get(i)==player) {
						counter++;
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
	public abstract boolean checkIfBlueWon(CuatroEnLinea tablero);
	public abstract boolean checkIfRedWon(CuatroEnLinea tablero);

}