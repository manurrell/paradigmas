package queue;

import java.util.ArrayList;

public class Vacio extends Estado {

	public static final String QUEUE_IS_EMPTY = "Queue is empty";

	public ArrayList<Estado> retroceder(ArrayList<Estado> historial) {
		throw new Error(QUEUE_IS_EMPTY);
	}
	
	public Object devolverElement() {
		throw new Error(QUEUE_IS_EMPTY);
	}

	public boolean esVacio() {
		return true;
	}
}
