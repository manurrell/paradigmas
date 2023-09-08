package queue;
import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	
  private Array lista = Array.vacio();
  
  
  //public Queue() {} 				metodo constructor por default
  
  //public Queue(List<Object> l) {   lista= l }			constructor especializado
  
  
  public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.lista.esVacio();
	}

  public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
	  
	  this.lista.añadir(cargo );
		return this;
	}

  public Object take() {
    // TODO Auto-generated method stub
	  if (this.size()==0) {
		  throw new Error("Queue is empty");
	  } else {
		  
		  Object cabeza= this.head();
		  this.lista.remove((lista.size())-1);
		  return cabeza;
	  }
	}

  public Object head() {
		// TODO Auto-generated method stub
	if (this.size()==0) {
		throw new Error("Queue is empty");
	}
    return this.lista.get((lista.size())-1);
	}

  public int size() {
		// TODO Auto-generated method stub
		return this.lista.size();
	}

}
 


