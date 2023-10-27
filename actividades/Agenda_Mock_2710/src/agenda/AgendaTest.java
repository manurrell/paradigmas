package agenda;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;


public class AgendaTest {

@Test void test01NewAgendaIsEmpty() {
	Agenda a = new Agenda ();
	assertTrue(Agenda.isEmpty());
	}

@Test void test02NewAgendaWithAHoliday() {
	Agenda a = new Agenda();
	a.add("2007-12-03");
	assertTrue(a.IsHoliday("2007-12-03"));
	}

@Test void test03NewAgenda() {
	Agenda a = new Agenda();
	a.add("2007-12-03");
	assertFalse(a.IsHoliday("2008-12-03"));	
	}
@Test void test04NewAgendaWithWeeklyHoliday() {
	Agenda a = new Agenda();
	a.add(LocalDate.parse("2007-12-03").getDayOfWeek().getValue());
	assertTrue(a.IsHoliday("2007-12-03"));
	}

@Test void test05NewAgendaWithWeeklyHoliday() {
	Agenda a = new Agenda();
	a.add(LocalDate.parse("2007-12-03").getDayOfWeek().getValue());
	assertTrue(a.IsHoliday("2023-10-23"));
	}

@Test void test05NewAgendaWithPeriodicHoliday() {
	Agenda a = new Agenda();
	a.add("2024-01-02","2024-01-29");
	assertTrue(a.IsHoliday("2024-01-05"));
	}

@Test void test06NewAgendaWithPeriodicHoliday() {
	Agenda a = new Agenda();
	a.add("2024-01-02","2024-01-29");
	assertFalse(a.IsHoliday("2024-01-30"));
	}

}
