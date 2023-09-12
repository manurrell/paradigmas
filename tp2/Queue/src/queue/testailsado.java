package queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class testailsado {

	  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
		    Queue queue = new Queue();
		    queue.add( "Something" );
		    queue.take();
		    System.out.println("1");			//por que no se printea
		    try {
		      System.out.println("aaaaaaaaaaaaaaaa");
		      queue.take();
		      System.out.println("2");
		      fail( "Expected Error was not thrown." );
		    } catch (Error e) {												//por que no atrapa error
		      assertTrue( e.getMessage().equals( "Queue is empty" ) );
		    }
		  }
}
