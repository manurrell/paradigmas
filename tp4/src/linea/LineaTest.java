package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class LineaTest {

	
	
	@Test
	void TamañoInvalido() {
		assertThrowsLike("El tamaño de tablero ingresado es inválido.", () -> new CuatroEnLinea(-1, 3, 'A'));
	}

	@Test
	void ModoInvalido() {
		assertThrowsLike("El modo seleccionado es invalido", () -> new CuatroEnLinea(3, 3, 'Z'));
	}


	@Test
	void crearlistabien() {
		CuatroEnLinea a = new CuatroEnLinea(2, 1, 'A');
		assertEquals(2, a.getBase());
	}

//	@Test
//	void kasndfkasndkvghn() {
//		assertTrue(new ModeB().applies('B'));
//	}

//	@Test
//	void Draw_GameEndsWhenBoardIsFull() {
//		CuatroEnLinea a = new CuatroEnLinea(1, 1, 'A');
//		a.playRedAt(1);
//		assertTrue(a.finished());
//	}

	@Test
	void cantPlayRedTwice() {
		CuatroEnLinea a = new CuatroEnLinea(1, 2, 'A');
		a.playRedAt(1);
		a.playRedAt(1);
		assertFalse(a.finished());

	}

	@Test
	void ErrorIsThrownAfterTryingOutOfBoundsColumn() {
		CuatroEnLinea a = new CuatroEnLinea(1, 1, 'A');
		assertThrowsLike("La columna indicada esta fuera de los parametros establecidos.", () -> a.playRedAt(2));

	}

	@Test
	void ErrorIsThrownWhenTryingColumnThatIsFull() {
		CuatroEnLinea a = new CuatroEnLinea(2, 2, 'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		assertThrowsLike("Esta llena la columna  hermano", () -> a.playRedAt(1));

	}

//	@Test void cantKeepPlayingAfterSomeonesWon() {
//		CuatroEnLinea a = redAchievesVertical('A');
//		a.playBlueAt(4);
//		a.playBlueAt(4);
//		a.playBlueAt(4);
//		a.playBlueAt(4);
//		assertEquals(a.getFinalMsg(),"Gano Rojo :)");
//
//	}







//	@Test
//	void cantPlayAfterSomeoneHasWon() {
//		CuatroEnLinea a = redAchievesVertical('A');
//		assertTrue(a.finished());
//		a.playBlueAt(10);
//
//	}

//	@Test
//	void CanTryAgainAfterTryingColumnThatIsFull() {
//		CuatroEnLinea a = new CuatroEnLinea(4,4,'A');
//		a.playRedAt(1);
//		a.playBlueAt(1);
//		a.playRedAt(2);
//		a.playBlueAt(1);
//		a.playRedAt(3);
//		a.playBlueAt(1);
//		a.playRedAt(1);
//		a.playRedAt(4);
//		assertTrue(a.finished());
//	}


	////////// Modo A //////////
	@Test
	void ModoADemo_Draw() {
		CuatroEnLinea a = new CuatroEnLinea(2, 2, 'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Empate");
	}

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

	////////// Modo B //////////
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

	////////// Modo C //////////
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







	private void assertThrowsLike(String msg, Executable exe) {
		  assertEquals(msg, assertThrows(Error.class, exe).getMessage());
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
