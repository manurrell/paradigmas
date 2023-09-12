package queue;

import java.util.ArrayList;

public class Vacio extends Estado {

	private static final String QUEUE_IS_EMPTY = "Queue is empty";

	public ArrayList<Estado> retroceder(ArrayList<Estado> historial) {
		throw new Error(QUEUE_IS_EMPTY);
	}
	
	public void verifyEmpty() {
		throw new Error(QUEUE_IS_EMPTY);
	}
}
