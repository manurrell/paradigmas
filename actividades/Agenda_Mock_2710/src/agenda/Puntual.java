package agenda;

import java.time.LocalDate;

public class Puntual extends Feriado{

	public boolean has(LocalDate d) {
		return false;
	}

}
