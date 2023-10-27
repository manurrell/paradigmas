package agenda;

import java.time.LocalDate;

public abstract class Feriado {
	public abstract boolean has(LocalDate d);
}
