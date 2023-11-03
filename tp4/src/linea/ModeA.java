package linea;

import java.util.ArrayList;

public class ModeA extends Mode {
	public ModeA() {
		id='A';
	}

	
	public boolean checkIfRedWon(CuatroEnLinea tablero) {
		ArrayList<Boolean> verify_list= new ArrayList<>();
		verify_list.add(verifyVertical('R', tablero));
		verify_list.add(verifyHorizontal('R', tablero));
		return verify_list.stream().anyMatch(b -> b);					//julio
		
	}
	public boolean checkIfBlueWon(CuatroEnLinea tablero) {
		ArrayList<Boolean> verify_list= new ArrayList<>();
		verify_list.add(verifyVertical('B', tablero));
		verify_list.add(verifyHorizontal('B', tablero));
		return verify_list.stream().anyMatch(b -> b);					//julio
		
	}
}
