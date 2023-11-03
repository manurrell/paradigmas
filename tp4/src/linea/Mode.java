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
	protected boolean verifyVertical(char player, ArrayList<ArrayList<Character>> tablero){
		int counter;
		for (int i=0;i<tablero.size();i++ ) {
			counter = 0;
			ArrayList<Character> column = tablero.get(i);
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
	protected boolean verifyHorizontal(char player, ArrayList<ArrayList<Character>> tablero){
		//NECEITA ACCSESO A ALTURA DE LA LISTA
		return false;
		
	}
	public abstract boolean checkIfFinished(ArrayList<ArrayList<Character>> tablero);


}