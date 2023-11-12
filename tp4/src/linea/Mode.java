package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Mode {
	protected char id;
	private static ArrayList<Mode> gamemodes = new ArrayList<>(Arrays.asList(new ModeA(), new ModeB(), new ModeC()));
	public static Mode selectGamemode(char a) {
		List<Mode> gamemode = gamemodes.stream().filter(modo -> modo.applies(a)).collect(Collectors.toList());
		if (gamemode.size()!=0) {
			return gamemode.get(0);
		} else {
			throw new Error("El modo seleccionado es invalido");	
		}
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
	public abstract boolean checkIfBlueWon(CuatroEnLinea tablero);
	public abstract boolean checkIfRedWon(CuatroEnLinea tablero);

}