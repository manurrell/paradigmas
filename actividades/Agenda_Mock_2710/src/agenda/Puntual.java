package agenda;

import java.time.LocalDate;

public class Puntual implements Feriado{

	public boolean has(LocalDate d) {
		return false;
	}

}
