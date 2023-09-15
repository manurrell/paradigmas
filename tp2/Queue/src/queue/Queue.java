package queue;
import java.util.ArrayList;

public class Queue {

  private ArrayList<Estado> lista = new ArrayList<>();
  
  public Queue() {
	  lista.add(Estado.newVacio());
  }
  
  public boolean isEmpty() {
		return this.lista.get(lista.size()-1).esVacio();
	}
  public Queue add( Object  cargo ) {
	  this.lista.add(1, Estado.newNoVacio(cargo));
	  return this;
	}
  public Object take() {
	Object cabeza= this.head();
	lista.remove(lista.size()-1);
	return cabeza;
	}
  public Object head() {
	  return this.lista.get(lista.size()-1).devolverElement();
	}
  public int size() {
		return this.lista.size()-1;
	}
}
 


