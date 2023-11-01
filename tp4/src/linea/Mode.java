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



}