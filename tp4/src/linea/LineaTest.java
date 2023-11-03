package linea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class LineaTest {

	@Test void NewCuatroEnLineaIsEmpty() {
		assertTrue( new CuatroEnLinea(1,1,'A').isEmpty());
	}
	
	@Test void ModeisMode() {
		assertTrue(new CuatroEnLinea(1,2,'A').getMode().equals(new ModeA()));
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
		assertTrue(a.isDraw());
	}
	
	@Test void modalidadAChequeoVerifcal() {
		CuatroEnLinea a = new CuatroEnLinea(5,4,'A');
		a.playRedAt(1);
		a.playRedAt(1);
		a.playRedAt(1);
		a.playRedAt(1);
		assertTrue(a.finished());
	}
	@Test void modalidadAChequeoHorizontal() {
		CuatroEnLinea a = new CuatroEnLinea(5,5,'A');
		a.playRedAt(1);
		a.playRedAt(2);
		a.playRedAt(3);
		a.playRedAt(4);
		a.playRedAt(1);
		assertTrue(a.finished());
	}
	
	@Test void modalidadBChequeoDiagonal() {
		CuatroEnLinea a = new CuatroEnLinea(5,5,'B');
		a.playRedAt(1);
		a.playRedAt(2);
		a.playRedAt(2);
		a.playRedAt(3);
		a.playRedAt(3);
		a.playRedAt(3);
		a.playRedAt(4);
		a.playRedAt(4);
		a.playRedAt(4);
		a.playRedAt(4);
		a.playBlueAt(1);
		a.playBlueAt(2);
		a.playBlueAt(3);
		a.playBlueAt(4);
		
		
		assertTrue(a.finished());
	}
	@Test void modalidadBChequeoDiagrrrronal() {
		CuatroEnLinea a = new CuatroEnLinea(4,4,'B');
		a.playRedAt(2);
		a.playRedAt(3);
		a.playRedAt(3);
		a.playRedAt(4);
		a.playRedAt(4);
		a.playRedAt(4);
		a.playBlueAt(1);
		a.playBlueAt(2);
		a.playBlueAt(3);
		a.playBlueAt(4);
		
		
		assertTrue(a.finished());
	}
	
	@Test void modalidadCChequeoTodo() {
		
		
	}
	
	
	
	
}
