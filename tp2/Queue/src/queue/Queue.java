package queue;
import java.util.ArrayList;
import java.util.List;

public class Queue {

  private ArrayList<Object> lista = new ArrayList<>();
  private ArrayList<Estado> history = new ArrayList<>();
  
  public Queue() {
	  history.add(Estado.newVacio());
  }
  
  public boolean isEmpty() {
		return this.lista.isEmpty();
	}

  public Queue add( Object  cargo ) {

	  this.lista.add(0, cargo);
	  this.history.add(Estado.newNoVacio());
	  return this;
	}

  public Object take() {
	System.out.println(this.history);
	this.history = this.history.get(history.size()-1).retroceder(history);
	System.out.println(this.history);
	Object cabeza= this.head();
	this.lista.remove((lista.size())-1);
	return cabeza;
	 
	}

  public Object head() {

	this.history.get(history.size()-1).verifyEmpty();
    return this.lista.get((lista.size())-1);
	}

  public int size() {

		return this.lista.size();
	}

}
 


