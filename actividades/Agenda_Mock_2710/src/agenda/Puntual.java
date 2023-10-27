package agenda;

import java.time.LocalDate;

public class Puntual extends Feriado{
	LocalDate date;
	public Puntual(LocalDate d){
		date=d;
	}
	
	public boolean has(LocalDate d) {
		return date.equals(d);
	}

}
