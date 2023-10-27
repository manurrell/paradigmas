package agenda;

import java.time.LocalDate;

public class Semanal extends Feriado{
	int value;
	public Semanal(int dia) {
		value=dia;
	}
	
	public boolean has(LocalDate d) {
		return value==d.getDayOfWeek().getValue();
	}
	
}
