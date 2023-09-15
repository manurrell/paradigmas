package queue;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class QueueTest {

@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( queueWithSomething().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", queueWithSomething().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueWithSomething();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }


  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    String addedObject = "Something";
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();
    String firstAddedObject = FIRST;
    String secondAddedObject = SECOND;

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();
    String firstAddedObject = FIRST;

    queue.add( firstAddedObject );
    queue.add( SECOND );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueWithSomething();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( FIRST ).add( SECOND ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
	assertThrowsLike(Vacio.QUEUE_IS_EMPTY, ()-> new Queue().take());
   
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = queueWithSomething();
    queue.take();
    assertThrowsLike(Vacio.QUEUE_IS_EMPTY, ()-> queue.take());
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
	assertThrowsLike(Vacio.QUEUE_IS_EMPTY, ()-> new Queue().head());

  }
  
  private static final String SECOND = "Second";
  private static final String FIRST = "First";
  
  private Queue queueWithSomething() {
	  return new Queue().add( "Something" );
  }
  
  private void assertThrowsLike(String msg, Executable exe) {		//executable vs runnable
	  assertEquals(msg, assertThrows(Error.class, exe).getMessage());
	  
  }

}