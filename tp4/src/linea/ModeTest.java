package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class ModeTest {

	@Test
	void ModeTest01ModoADemo_VerticalWin() {
		CuatroEnLinea a = newGame_4x4_redAttainsVertical_inMode('A');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
		assertEquals(a.show(), "| R _ _ _ |\n"
							 + "| R B _ _ |\n"
							 + "| R B _ _ |\n"
							 + "| R B _ _ |");
	}

	@Test
	void ModeTest02ModoADemo_HorizontalWin() {
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
	void ModeTest03ModoADemo_HorizontalInterrumpidaNoGana() {
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
	void ModeTest04ModoADemo_verticalInterrumpidoNoGana() {
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
	void ModeTest05ModoADemo_DiagonalRNoGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsRightOrientedDiagonal_inMode('A');
		assertFalse(a.finished());

	}

	@Test
	void ModeTest06ModoADemo_DiagonalLNoGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsLeftOrientedDiagonal_inMode('A');
		assertFalse(a.finished());

	}

	
	@Test
	void ModeTest07ModoBDemo_diagonalRGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsRightOrientedDiagonal_inMode('B');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");

	}

	@Test
	void ModeTest08ModoBDemo_diagonalLGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsLeftOrientedDiagonal_inMode('B');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");

	}

	@Test
	void ModeTest09ModoBDemo_diagonalRInterrumpidoNoGana() {
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
	void ModeTest10ModoBDemo_diagonalLInterrumpidoNoGana() {
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
	void ModeTest11ModoCDemo_VerticalGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsVertical_inMode('C');
		assertTrue(a.finished());
		assertEquals(a.show(), "| R _ _ _ |\n"
							 + "| R B _ _ |\n"
							 + "| R B _ _ |\n"
							 + "| R B _ _ |");
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModeTest12ModoCDemo_HorizontalGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsHorizontal_inMode('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModeTest13ModoCDemo_DiagonalRGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsRightOrientedDiagonal_inMode('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}

	@Test
	void ModeTest14ModoCDemo_DiagonalLGana() {
		CuatroEnLinea a = newGame_4x4_redAttainsLeftOrientedDiagonal_inMode('C');
		assertTrue(a.finished());
		assertEquals(a.getFinalMsg(), "Gano Rojo :)");
	}
	
	
	
	
	private CuatroEnLinea newGame_4x4_redAttainsRightOrientedDiagonal_inMode(char m) {
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
		assertEquals(a.show(), "| _ _ _ R |\n"
							 + "| _ _ R B |\n"
							 + "| R R R B |\n"
							 + "| R B B B |");
		return a;
	}


	private CuatroEnLinea newGame_4x4_redAttainsLeftOrientedDiagonal_inMode(char m) {
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
		assertEquals(a.show(), "| R _ _ _ |\n"
							 + "| B R _ _ |\n"
							 + "| B R R R |\n"
							 + "| B B B R |");
		return a;
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
		assertEquals(a.show(), "| R _ _ _ |\n"
							 + "| R B _ _ |\n"
							 + "| R B _ _ |\n"
							 + "| R B _ _ |");
		return a;
	}

	private CuatroEnLinea newGame_4x4_redAttainsHorizontal_inMode(char m) {
		CuatroEnLinea a = new CuatroEnLinea(4,4,m);
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(4);
		assertEquals(a.show(), "| _ _ _ _ |\n"
							 + "| _ _ _ _ |\n"
							 + "| B B B _ |\n"
							 + "| R R R R |");
		return a;
	}

}
