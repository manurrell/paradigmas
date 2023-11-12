package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class LineaTest {

	
	@Test
	void newGame00() {
		CuatroEnLinea a = new CuatroEnLinea(2, 2, 'A');
		assertEquals(
				 	 "| _ _ |\n"
				+ 	 "| _ _ |", a.show());
		assertFalse(a.finished());

	}
	@Test
	void TamañoInvalido() {
		assertThrowsLike("El tamaño de tablero ingresado es inválido.", () -> new CuatroEnLinea(-1, 3, 'A'));
	}

	@Test
	void ModoInvalido() {
		assertThrowsLike("El modo seleccionado es invalido", () -> new CuatroEnLinea(3, 3, 'Z'));
	}




	@Test
	void cantPlayRedTwice() {
		CuatroEnLinea a = new CuatroEnLinea(1, 2, 'A');
		a.playRedAt(1);
		a.playRedAt(1);
		assertEquals(
				 	 "| _ |\n"
				+ 	 "| R |", a.show());
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
		assertThrowsLike("La columna está llena", () -> a.playRedAt(1));

	}
	
	@Test
	void Draw_GameFinishesWhenBoardIsFull() {
		CuatroEnLinea a = new CuatroEnLinea(2, 2, 'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		assertEquals("| B B |\n"
				+ 	 "| R R |", a.show());
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Empate");
	}

	@Test void cantKeepPlayingAfterSomeonesWon() {
		CuatroEnLinea a = redAchievesVertical('A');
		a.playBlueAt(4);
		assertEquals("| R _ _ _ |\n"
				+ 	 "| R B _ _ |\n"
				+ 	 "| R B _ _ |\n"
				+ 	 "| R B _ _ |", a.show());
		assertEquals(a.getFinalMsg(),"Gano Rojo :)");

	}

	private void assertThrowsLike(String msg, Executable exe) {
		  assertEquals(msg, assertThrows(Error.class, exe).getMessage());
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

}
