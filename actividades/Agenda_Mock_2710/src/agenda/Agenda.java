package agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.DayOfWeek;

public class Agenda {
	private ArrayList<Feriado> holidays=new ArrayList<Feriado>();
	public static boolean isEmpty() {
		return true;
	}
	public void add(String fecha) {
		holidays.add(new Puntual(LocalDate.parse(fecha)));
	}
	public void add(int dia) {
		holidays.add(new Semanal(dia));
	}
	public void add(String fecha1,String fecha2) {
		holidays.add(new Periodico(LocalDate.parse(fecha1),LocalDate.parse(fecha2)));
	}
	public boolean IsHoliday(String string) {
		LocalDate f = LocalDate.parse(string);
		return holidays.stream().anyMatch(feriado -> feriado.has(f));
	}
}
