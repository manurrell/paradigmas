package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class LineaTest {

	
	@Test
	void LineaTest01newGame() {
		CuatroEnLinea a = new CuatroEnLinea(2, 2, 'A');
		assertEquals(
				 	 "| _ _ |\n"
				+ 	 "| _ _ |", a.show());
		assertFalse(a.finished());

	}
	@Test
	void LineaTest02tamañoInvalido() {
		assertThrowsLike("El tamaño de tablero ingresado es inválido.", () -> new CuatroEnLinea(-1, 3, 'A'));
	}

	@Test
	void LineaTest03modoInvalido() {
		assertThrowsLike("El modo seleccionado es invalido", () -> new CuatroEnLinea(3, 3, 'Z'));
	}




	@Test
	void LineaTest04cantPlayRedTwice() {
		CuatroEnLinea a = new CuatroEnLinea(1, 2, 'A');
		a.playRedAt(1);
		a.playRedAt(1);
		assertEquals(
				 	 "| _ |\n"
				+ 	 "| R |", a.show());
		assertFalse(a.finished());

	}

	@Test
	void LineaTest05errorIsThrownAfterTryingOutOfBoundsColumn() {
		CuatroEnLinea a = new CuatroEnLinea(1, 1, 'A');
		assertThrowsLike("La columna indicada esta fuera de los parametros establecidos.", () -> a.playRedAt(2));

	}

	@Test
	void LineaTest06errorIsThrownWhenTryingColumnThatIsFull() {
		CuatroEnLinea a = new CuatroEnLinea(2, 2, 'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		assertThrowsLike("La columna está llena", () -> a.playRedAt(1));

	}
	
	@Test
	void LineaTest07GameEndsAsDrawWhenBoardIsFull() {
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

	@Test void LineaTest08gameOutcomeIsLockedAfterSomeoneHasWon() {
		CuatroEnLinea a = newGame_4x4_redAttainsVertical_inMode('A');
		assertEquals("| R _ _ _ |\n"
				+ 	 "| R B _ _ |\n"
				+ 	 "| R B _ _ |\n"
				+ 	 "| R B _ _ |", a.show());
		assertEquals(a.getFinalMsg(),"Gano Rojo :)");
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
	private CuatroEnLinea newGame_4x4_redAttainsVertical_inMode(char m) {
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
