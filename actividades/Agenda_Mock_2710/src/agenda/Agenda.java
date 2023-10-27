package agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.DayOfWeek;

public class Agenda {
	public ArrayList<LocalDate> feriadosPuntuales=new ArrayList();
	private ArrayList<DayOfWeek> feriadosSemanales=new ArrayList();
	private ArrayList<Periodo> feriadosPeriodicos=new ArrayList();
	
	public static boolean isEmpty() {
		return true;
	}
	
	public void add(String fecha) {
		feriadosPuntuales.add(LocalDate.parse(fecha));
	}
	
	public void add(int dia) {
		feriadosSemanales.add(DayOfWeek.of(dia));
	}
	
	public void add(String fecha1,String fecha2) {
		feriadosPeriodicos.add(new Periodo(LocalDate.parse(fecha1),LocalDate.parse(fecha2)));
	}

	public boolean IsHoliday(String string) {
		LocalDate f = LocalDate.parse(string);
		ArrayList<Boolean> chequeando = new ArrayList();
		chequeando.add(feriadosSemanales.contains(f.getDayOfWeek()));
		chequeando.add(!feriadosPuntuales.stream().filter(feriado -> feriado.equals(f)).collect(Collectors.toList()).isEmpty());
		chequeando.add(	!feriadosPeriodicos.stream().filter(period -> period.isInBetween(f)).collect(Collectors.toList()).isEmpty());
		return chequeando.contains(true);
		

	}

}
