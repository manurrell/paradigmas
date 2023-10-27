package agenda;

import java.time.LocalDate;

public interface Feriado {
	public abstract boolean has(LocalDate d);
}
