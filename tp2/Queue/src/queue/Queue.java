package queue;
import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	
  private List<Object>  toDoList = new ArrayList<>();
  
  
  public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.toDoList.isEmpty();
	}

  public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
	  this.toDoList.add(0, cargo);
		return this;
	}

  public Object take() {
    // TODO Auto-generated method stub
	  if (this.size()==0) {
		  throw new Error("Queue is empty");
	  } else {
		  
		  Object cabeza= this.head();
		  this.toDoList.remove((toDoList.size())-1);
		  return cabeza;
	  }
	}

  public Object head() {
		// TODO Auto-generated method stub
	if (this.size()==0) {
		throw new Error("Queue is empty");
	}
    return this.toDoList.get((toDoList.size())-1);
	}

  public int size() {
		// TODO Auto-generated method stub
		return this.toDoList.size();
	}

}
