package agenda;

import java.time.LocalDate;

public class Periodico extends Feriado{
	LocalDate fInicial;
	LocalDate fFinal;
	
	public Periodico (LocalDate f1, LocalDate f2) {
		fInicial =f1;
		fFinal = f2;
	}
	public LocalDate getInitialDate() {
		return fInicial;
	}
	
	public LocalDate getFinalDate() {
		return fFinal;
	}
	
	public boolean has(LocalDate fecha) {
		return  ((fecha.isAfter(fInicial) && fecha.isBefore(fFinal))|| (fecha.equals(fInicial) || fecha.equals(fFinal)));
	}

}
