package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class ModeTest {

	@Test
	void ModoADemo_VerticalWin() {
		CuatroEnLinea a = redAchievesVertical('A');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModoADemo_HorizontalWin() {
		CuatroEnLinea a = new CuatroEnLinea(4, 4, 'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(4);
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModoADemo_HorizontalInterrumpidaNoGana() {
		CuatroEnLinea a = new CuatroEnLinea(4, 4, 'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(4);
		assertFalse(a.finished());
	}
	

	@Test
	void ModoADemo_verticalInterrumpidoNoGana() {
		CuatroEnLinea a = new CuatroEnLinea(6, 6, 'A');
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		assertFalse(a.finished());


	}

	@Test
	void ModoADemo_DiagonalRNoGana() {
		CuatroEnLinea a = redAchievesDiagonalR('A');
		assertFalse(a.finished());

	}

	@Test
	void ModoADemo_DiagonalLNoGana() {
		CuatroEnLinea a = redAchievesDiagonalL('A');
		assertFalse(a.finished());

	}

	
	@Test
	void ModoBDemo_diagonalRGana() {
		CuatroEnLinea a = redAchievesDiagonalR('B');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");

	}

	@Test
	void ModoBDemo_diagonalLGana() {
		CuatroEnLinea a = redAchievesDiagonalL('B');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");

	}

	@Test
	void ModoBDemo_diagonalRInterrumpidoNoGana() {
		CuatroEnLinea a = new CuatroEnLinea(6, 6, 'B');
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(2);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(4);
		a.playRedAt(3);
		a.playBlueAt(4);
		a.playRedAt(4);
		a.playBlueAt(5);
		a.playRedAt(4);
		assertFalse(a.finished());
	}
	@Test
	void ModoBDemo_diagonalLInterrumpidoNoGana() {
		CuatroEnLinea a = new CuatroEnLinea(6, 6, 'B');
		a.playRedAt(6);
		a.playBlueAt(5);
		a.playRedAt(5);
		a.playBlueAt(4);
		a.playRedAt(4);
		a.playBlueAt(4);
		a.playRedAt(4);
		a.playBlueAt(3);
		a.playRedAt(4);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(2);
		a.playRedAt(3);
		assertFalse(a.finished());
	}

	
	@Test
	void ModoCDemo_VerticalGana() {
		CuatroEnLinea a = redAchievesVertical('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModoCDemo_HorizontalGana() {
		CuatroEnLinea a = redAchievesHorizontal('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModoCDemo_DiagonalRGana() {
		CuatroEnLinea a = redAchievesDiagonalR('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModoCDemo_DiagonalLGana() {
		CuatroEnLinea a = redAchievesDiagonalL('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}
	private CuatroEnLinea redAchievesDiagonalR(char m) {
		CuatroEnLinea a = new CuatroEnLinea(4,4,m);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(2);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(4);
		a.playRedAt(3);
		a.playBlueAt(4);
		a.playRedAt(1);
		a.playBlueAt(4);
		a.playRedAt(4);
		return a;
	}


	private CuatroEnLinea redAchievesDiagonalL(char m) {
		CuatroEnLinea a = new CuatroEnLinea(4,4,m);
		a.playRedAt(4);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(2);
		a.playRedAt(2);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(1);
		a.playRedAt(4);
		a.playBlueAt(1);
		a.playRedAt(1);
		return a;
	}

	private CuatroEnLinea redAchievesVertical(char m) {
		CuatroEnLinea a = new CuatroEnLinea(4,4,m);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		return a;
	}

	private CuatroEnLinea redAchievesHorizontal(char m) {
		CuatroEnLinea a = new CuatroEnLinea(4,4,m);
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(4);
		return a;
	}

}
