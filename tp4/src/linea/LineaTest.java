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
		assertEquals(2,a.getBoardSize());
	}
	@Test void kasndfkasndkvghn() {
		assertTrue(new ModeB().applies('B'));
	}
	@Test void jugar() {
		CuatroEnLinea a = new CuatroEnLinea(1,1,'A');
		a.playRedAt(1);
		assertTrue(a.isDraw());
	}
	
	
	
}
