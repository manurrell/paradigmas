package nemo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTest {
	private South SOUTH;
	private East EAST;
	private West WEST;
	private North NORTH;

@BeforeEach public void setUp() {
	SOUTH = new South();
	EAST = new East();
	WEST = new West();
	NORTH = new North();	
}
@Test public void test01NewNemo() {
	Nemo sub = nemoAt_0_0_0_North();	
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test02NewNemoDiffSettings() {
	Nemo sub = new Nemo(1,5,WEST);	
	assertPosition(1,5,0,sub);
	assertType(West.class,sub.getAim());
}
@Test public void test03DoNothingEmptyInsruction() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("");
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test04North_RotateLeft() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("l");
	assertPosition(0,0,0,sub);
	assertType(West.class,sub.getAim());
}
@Test public void test05North_RotateRight() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("r");
	assertPosition(0,0,0,sub);
	assertType(East.class,sub.getAim());
}
@Test public void test06East_RotateLeft() {
	Nemo sub = new Nemo(0,0,EAST);
	sub.executeInstruction("l");
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test07East_RotateRight() {
	Nemo sub = new Nemo(0,0,EAST);
	sub.executeInstruction("r");
	assertPosition(0,0,0,sub);
	assertType(South.class,sub.getAim());
}
@Test public void test08South_RotateLeft() {
	Nemo sub = new Nemo(0,0,SOUTH);
	sub.executeInstruction("l");
	assertPosition(0,0,0,sub);
	assertType(East.class,sub.getAim());
}
@Test public void test09South_RotateRight() {
	Nemo sub = new Nemo(0,0,SOUTH);
	sub.executeInstruction("r");
	assertPosition(0,0,0,sub);
	assertType(West.class,sub.getAim());
}
@Test public void test10West_RotateLeft() {
	Nemo sub = new Nemo(0,0,WEST);
	sub.executeInstruction("l");
	assertPosition(0,0,0,sub);
	assertType(South.class,sub.getAim());
}
@Test public void test11West_RotateRight() {
	Nemo sub = new Nemo(0,0,WEST);
	sub.executeInstruction("r");
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test12NemoCanDoFullRotationR() {
	Nemo sub = nemoAt_0_0_0_North();
	assertType(North.class,sub.getAim());
	sub.executeInstruction("rrrr");
	assertType(North.class,sub.getAim());
}
@Test public void test13NemoCanDoFullRotationL() {
	Nemo sub = nemoAt_0_0_0_North();
	assertType(North.class,sub.getAim());
	sub.executeInstruction("llll");
	assertType(North.class,sub.getAim());
}
@Test public void test14MoveNorthAddsX() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("f");
	assertPosition(1,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test15MoveSouthSubstractsX() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("rrf");
	assertPosition(-1,0,0,sub);
	assertType(South.class,sub.getAim());
}
@Test public void test16MoveEastSubstractsY() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("rf");
	assertPosition(0,-1,0,sub);
	assertType(East.class,sub.getAim());
}
@Test public void test17MoveWestAddsY() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("lf");
	assertPosition(0,1,0,sub);
	assertType(West.class,sub.getAim());
}
@Test public void test18SimpleMovementChain() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("ffffffffffff");
	assertPosition(12,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test19Descend() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("d");
	assertPosition(0,0,-1,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test20NotAscendWhenOnSurface() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("u");	
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test21NotAscendWhenOnSurfaceAfterMovementChain() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("fflfddrfuduuuuuuuuuuuuu");	
	assertPosition(3,1,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test22MovementChain() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("fffdduduf");
	assertPosition(4,0,-1,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test23MovementChainWithDirections() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("rfffrffddurl");	
	assertPosition(-2,-3,-1,sub);
	assertType(South.class,sub.getAim());
}
@Test public void test24NothingHappensWhenReleasingCapsuleAtSurfaceLevel() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("m");
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test25CanExecuteReleaseCommandMoreThanOnce() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("mm");
	assertPosition(0,0,0,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test26NothingHappensWhenReleasingCapsuleAfterSingleDescent() {
	Nemo sub = nemoAt_0_0_0_North();
	sub.executeInstruction("dm");
	assertPosition(0,0,-1,sub);
	assertType(North.class,sub.getAim());
}
@Test public void test27BrownieImplosion_ErrorWhenReleasingCapsuleAfterTwoDescents() {
	Nemo sub = nemoAt_0_0_0_North();
	assertThrowsLike(Danger.BROWNIE_MOMENT, ()-> sub.executeInstruction("ddm"));
}
@Test public void test28BrownieImplosion_ReleasingCapsulesDoesNotPreventErrorFromReleasingCapsuleAtDangerState() {
	Nemo sub = nemoAt_0_0_0_North();
	assertThrowsLike(Danger.BROWNIE_MOMENT, ()-> sub.executeInstruction("mmmmmdddm"));
}
@Test public void test29BrownieImplosion_NemoStopsExecutingCommandsAfterExploding() {
	Nemo sub = nemoAt_0_0_0_North();
	assertThrowsLike(Danger.BROWNIE_MOMENT, ()-> sub.executeInstruction("dddmffff"));
	assertPosition(0,0,-3,sub);
}
@Test public void test30BrownieImplosion_MovementChainDoesNotPreventErrorFromReleasingCapsuleAtDangerState() {
	Nemo sub = nemoAt_0_0_0_North();
	assertThrowsLike(Danger.BROWNIE_MOMENT, ()-> sub.executeInstruction("fdrrrlfflffudfdm"));
}
@Test public void test31BrownieImplosion_NemoRemainsInDangerStateAfterNumerousDescents() {
	Nemo sub = nemoAt_0_0_0_North();
	assertThrowsLike(Danger.BROWNIE_MOMENT, ()-> sub.executeInstruction("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddm"));
}

private void assertType(Class<?> tipo, Object obj) {
	assertEquals(tipo,obj.getClass());
}
private void assertThrowsLike(String msg, Executable exe) {
	  assertEquals(msg, assertThrows(Error.class, exe).getMessage());
}
private void assertPosition(int x, int y, int z, Nemo sub) {
	assertEquals(x,sub.getX());
	assertEquals(y,sub.getY());
	assertEquals(z,sub.getZ());
}
private Nemo nemoAt_0_0_0_North() {
	return new Nemo(0,0,NORTH);
}
}
