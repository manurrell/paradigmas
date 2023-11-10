package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class LineaTest {
	
	@Test void TamañoInvalido() {
		assertThrowsLike("El tamaño de tablero ingresado es inválido.", ()-> new CuatroEnLinea(-1,3,'A'));
	}
	
	@Test void ModoInvalido() {
		assertThrowsLike("El modo seleccionado es invalido", ()-> new CuatroEnLinea(3,3,'Z'));
	}
	
	
	@Test void crearlistabien() {
		CuatroEnLinea a = new CuatroEnLinea(2,1,'A');
		assertEquals(2,a.getBase());
	}
	@Test void kasndfkasndkvghn() {
		assertTrue(new ModeB().applies('B'));
	}
	@Test void jugar() {
		CuatroEnLinea a = new CuatroEnLinea(1,1,'A');
		a.playRedAt(1);
		assertTrue(a.finished());
	}
	
	@Test void cantPlayRedTwice() {
		CuatroEnLinea a = new CuatroEnLinea(1,2,'A');
		a.playRedAt(1);
		a.playRedAt(1);
		assertFalse(a.finished());
		
	}
	@Test void canPlayAfterTryingOutOfBOundsColumn() {
		CuatroEnLinea a = new CuatroEnLinea(1,1,'A');
		assertThrowsLike("La columna indicada esta fuera de los parametros establecidos.", ()-> a.playRedAt(2));
		
	}
	
	
	@Test void ModoADemo() {
		CuatroEnLinea a = new CuatroEnLinea(4,4,'A');
		redAchievesDiagonalR(a);
		assertFalse(a.finished());
		
	}

	private void redAchievesDiagonalR(CuatroEnLinea a) {
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
	}
	@Test void gameEndsWhenBoardFull() {
		CuatroEnLinea a = new CuatroEnLinea(2,2,'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		assertTrue(a.finished());
		}
	@Test void ModoADemo_VerticalWin() {
		CuatroEnLinea a = new CuatroEnLinea(4,4,'A');
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		assertTrue(a.finished());
	}
	@Test void ModoADemo_HorizontalWin() {
		CuatroEnLinea a = new CuatroEnLinea(4,4,'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(2);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(4);
		assertTrue(a.finished());
	}
	@Test void ModoADemo_HorizontalInterrumpidaNoGana() {
		CuatroEnLinea a = new CuatroEnLinea(4,4,'A');
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(2);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(3);
		a.playRedAt(4);
		assertFalse(a.finished());
	}

	@Test void diagonalR() {
		CuatroEnLinea a = new CuatroEnLinea(6,6,'B');
		redAchievesDiagonalR(a);
		assertTrue(a.finished());
		
	}
	@Test void diagonalRInterrumpido() {
		CuatroEnLinea a = new CuatroEnLinea(6,6,'B');
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
	
	@Test void diagonalL() {
		CuatroEnLinea a = new CuatroEnLinea(6,6,'B');
		a.playRedAt(6);
		a.playBlueAt(5);
		a.playRedAt(5);
		a.playBlueAt(4);
		a.playRedAt(4);
		a.playBlueAt(3);
		a.playRedAt(4);
		a.playBlueAt(3);
		a.playRedAt(3);
		a.playBlueAt(2);
		a.playRedAt(3);
		assertTrue(a.finished());
		
	}
	@Test void verticalNoContinuo() {
		CuatroEnLinea a = new CuatroEnLinea(6,6,'A');
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		a.playBlueAt(1);
		a.playRedAt(1);
		a.playBlueAt(2);
		a.playRedAt(1);
		assertFalse(a.finished());
		
	}
	
	
	
	
	
	
	
	
//	@Test void modalidadAChequeoVerifcal() {
//		CuatroEnLinea a = new CuatroEnLinea(5,4,'A');
//		a.playRedAt(1);
//		a.playRedAt(1);
//		a.playRedAt(1);
//		a.playRedAt(1);
//		assertTrue(a.finished());
//	}
//
//	@Test void modalidadAChequeoHorizontal() {
//		CuatroEnLinea a = new CuatroEnLinea(5,5,'A');
//		a.playRedAt(1);
//		a.playRedAt(2);
//		a.playRedAt(3);
//		a.playRedAt(4);
//		a.playRedAt(1);
//		assertTrue(a.finished());
//	}
//	
//	@Test void modalidadBChequeoDiagonal() {
//		CuatroEnLinea a = new CuatroEnLinea(5,5,'B');
//		a.playRedAt(1);
//		a.playRedAt(2);
//		a.playRedAt(2);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playBlueAt(1);
//		a.playBlueAt(2);
//		a.playBlueAt(3);
//		a.playBlueAt(4);
//		
//		
//		assertTrue(a.finished());
//	}
//	@Test void modalidadBChequeoDiagrrrronal() {
//		CuatroEnLinea a = new CuatroEnLinea(4,4,'B');
//		a.playRedAt(2);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playBlueAt(1);
//		a.playBlueAt(2);
//		a.playBlueAt(3);
//		a.playBlueAt(4);
//		
//		
//		assertTrue(a.finished());
//	}
//	@Test void modalidadBChequeoDiagrrrronalLeft() {
//		CuatroEnLinea a = new CuatroEnLinea(4,4,'B');
//		a.playRedAt(3);
//		a.playRedAt(2);
//		a.playRedAt(2);
//		a.playRedAt(1);
//		a.playRedAt(1);
//		a.playRedAt(1);
//		a.playBlueAt(1);
//		a.playBlueAt(2);
//		a.playBlueAt(3);
//		a.playBlueAt(4);
//		
//		
//		assertTrue(a.finished());
//	}
//	@Test void modalidadBChequeoDiagonalLeft() {
//		CuatroEnLinea a = new CuatroEnLinea(5,5,'B');
//		a.playRedAt(5);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(2);
//		a.playRedAt(2);
//		a.playRedAt(2);
//		a.playRedAt(2);
//		a.playBlueAt(5);
//		a.playBlueAt(4);
//		a.playBlueAt(3);
//		a.playBlueAt(2);
//		
//		
//		assertTrue(a.finished());
//	}
//	@Test void modalidadBChequeoDiagonalLeftInC() {
//		CuatroEnLinea a = new CuatroEnLinea(5,5,'C');
//		a.playRedAt(5);
//		a.playRedAt(4);
//		a.playRedAt(4);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(3);
//		a.playRedAt(2);
//		a.playBlueAt(2);
//		a.playRedAt(2);
//		a.playRedAt(2);
//		a.playBlueAt(5);
//		a.playBlueAt(4);
//		a.playBlueAt(3);
//		a.playBlueAt(2);
//		
//		
//		assertTrue(a.finished());
//	}
//	@Test void ChequeoVerifcalinC() {
//		CuatroEnLinea a = new CuatroEnLinea(5,4,'C');
//		a.playRedAt(1);
//		a.playRedAt(1);
//		a.playRedAt(1);
//		a.playRedAt(1);
//		assertTrue(a.finished());
//	}
//	@Test void ChequeoHorizontalInC() {
//		CuatroEnLinea a = new CuatroEnLinea(5,5,'C');
//		a.playRedAt(1);
//		a.playRedAt(2);
//		a.playRedAt(3);
//		a.playRedAt(4);
//		a.playRedAt(1);
//		assertTrue(a.finished());
//	}
//	
//	@Test void modalidadCChequeoTodo() {
//		
//		
//	}
//	
//	
//	
	private void assertThrowsLike(String msg, Executable exe) {
		  assertEquals(msg, assertThrows(Error.class, exe).getMessage());
	  }
}
