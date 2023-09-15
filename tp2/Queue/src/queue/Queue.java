package queue;
import java.util.ArrayList;

public class Queue {

  private ArrayList<Estado> history = new ArrayList<>();
  
  public Queue() {
	  history.add(Estado.newVacio());
  }
  
  public boolean isEmpty() {
		return this.history.get(history.size()-1).esVacio();
	}

  public Queue add( Object  cargo ) {

	  this.history.add(1, Estado.newNoVacio(cargo));
	  return this;
	}

  public Object take() {
	Object cabeza= this.head();
	history.remove(history.size()-1);
	return cabeza;
	 
	}

  public Object head() {
	  return this.history.get(history.size()-1).devolverElement();
	
	}

  public int size() {

		return this.history.size()-1;
	}

}
 


