package agenda;

import java.time.LocalDate;

public class Periodo {
	LocalDate fInicial;
	LocalDate fFinal;
	
	public Periodo (LocalDate f1, LocalDate f2) {
		fInicial =f1;
		fFinal = f2;
	}
	public LocalDate getInitialDate() {
		return fInicial;
	}
	
	public LocalDate getFinalDate() {
		return fFinal;
	}
	
	public boolean isInBetween(LocalDate fecha) {
		return fecha.isAfter(fInicial) && fecha.isBefore(fFinal);
	}
}
