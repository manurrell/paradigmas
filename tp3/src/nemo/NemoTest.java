package nemo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTest {
private static final North NORTE = new North();
private static final South SUR = new South();
private static final East ESTE = new East();
private static final West OESTE = new West();
@Test public void test01NewNemo() {
	Nemo sub = new Nemo(0,0,0,NORTE);	
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals(NORTE,sub.getAim());
}
@Test public void test02DoNothingEmptyInsruction() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals(NORTE,sub.getAim());
}
@Test public void test03MoveFoward() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("f");
	assertEquals(1,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals(NORTE,sub.getAim());
}
@Test public void test04Descend() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("d");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(-1,sub.getZ());
	assertEquals(NORTE,sub.getAim());
}
@Test public void test05NotAscendWhenOnSurface() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("u");	
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals(NORTE,sub.getAim());
}
@Test public void test06RotateLeft() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("l");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("O",sub.getAim());
}
@Test public void test07RotateR() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("r");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("E",sub.getAim());
}
@Test public void test08InstructionChain() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("fffddadaf");
	assertEquals(4,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals((-1),sub.getZ());
	assertEquals(NORTE,sub.getAim());
}
@Test public void test09InstructionChainWithDirections() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	sub.executeInstruction("rfffrffddarl");	
	assertEquals(-3,sub.getX());
	assertEquals(-2,sub.getY());
	assertEquals(-1,sub.getZ());
	assertEquals("E",sub.getAim());
}


@Test public void test12brownieimplosion() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	assertThrowsLike("Brownie Moment", ()-> sub.executeInstruction("ddm"));
}
@Test public void test13brownieimplosionPT2() {
	Nemo sub = new Nemo(0,0,0,NORTE);
	assertThrowsLike("Brownie Moment", ()-> sub.executeInstruction("mmmmmddm"));
}

private void assertThrowsLike(String msg, Executable exe) {
	  assertEquals(msg, assertThrows(Exception.class, exe).getMessage());
}
}
