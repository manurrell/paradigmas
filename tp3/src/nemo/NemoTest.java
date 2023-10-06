package nemo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTest {
@Test public void test01NewNemo() {
	Nemo sub = new Nemo();	
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("N",sub.getAim());
	assertEquals(5,sub.getCapsuleAmount());
}
@Test public void test02DoNothingEmptyInsruction() {
	Nemo sub = new Nemo();
	sub.executeInstruction("");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("N",sub.getAim());
	assertEquals(5,sub.getCapsuleAmount());
}
@Test public void test03MoveFoward() {
	Nemo sub = new Nemo();
	sub.executeIntruction("f");
	assertEquals(1,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("N",sub.getAim());
	assertEquals(5,sub.getCapsuleAmount());	
}
@Test public void test04Descend() {
	Nemo sub = new Nemo();
	sub.executeIntruction("d");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(-1,sub.getZ());
	assertEquals("N",sub.getAim());
	assertEquals(5,sub.getCapsuleAmount());
}
@Test public void test05NotAscendWhenOnSurface() {
	Nemo sub = new Nemo();
	sub.executeIntruction("u");	
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("N",sub.getAim());
}
@Test public void test06RotateLeft() {
	Nemo sub = new Nemo();
	sub.executeIntruction("l");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("O",sub.getAim());
}
@Test public void test07RotateR() {
	Nemo sub = new Nemo();
	sub.executeIntruction("r");
	assertEquals(0,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals(0,sub.getZ());
	assertEquals("E",sub.getAim());
}
@Test public void test08InstructionChain() {
	Nemo sub = new Nemo();
	sub.executeIntruction("fffddadaf");
	assertEquals(4,sub.getX());
	assertEquals(0,sub.getY());
	assertEquals((-1),sub.getZ());
	assertEquals("N",sub.getAim());
}
@Test public void test09InstructionChainWithDirections() {
	Nemo sub = new Nemo();
	sub.executeIntruction("rfffrffddarl");	
	assertEquals(-3,sub.getX());
	assertEquals(-2,sub.getY());
	assertEquals(-1,sub.getZ());
	assertEquals("E",sub.getAim());
}
@Test public void test10NewNemoRelease() {
	Nemo sub = new Nemo();
	assertEquals(5,sub.getCapsuleAmount());
	sub.executeIntruction("m");
	assertEquals(4,sub.getCapsuleAmount());
}
@Test public void test11NewNemoAttemptsSafeReleaseOf6Capsules() {
	Nemo sub = new Nemo();
	assertEquals(5,sub.getCapsuleAmount());
	sub.executeIntruction("mmmmmm");
	assertEquals(0,sub.getCapsuleAmount());
}
@Test public void test12brownieimplosion() {
	Nemo sub = new Nemo();
	assertEquals(5,sub.getCapsuleAmount());
	assertThrowsLike("Brownie Moment", ()-> sub.executeIntruction("ddm"));
}
@Test public void test13brownieimplosionPT2() {
	Nemo sub = new Nemo();
	assertEquals(5,sub.getCapsuleAmount());
	assertThrowsLike("Brownie Moment", ()-> sub.executeIntruction("mmmmmddm"));
}

private void assertThrowsLike(String msg, Executable exe) {
	  assertEquals(msg, assertThrows(Exception.class, exe).getMessage());
}
}
