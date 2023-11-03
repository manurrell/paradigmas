package linea;

import java.util.ArrayList;

public class ModeA extends Mode {
	public ModeA() {
		id='A';
	}

	
	public boolean checkIfFinished(ArrayList<ArrayList<Character>> tablero) {
		ArrayList<Boolean> verify_list= new ArrayList<>();
		verify_list.add(verifyVertical('R', tablero));
		verify_list.add(verifyVertical('B', tablero));
		return true;
		
	}
}
