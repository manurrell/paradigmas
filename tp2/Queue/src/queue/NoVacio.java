package queue;

import java.util.ArrayList;

public class NoVacio extends Estado {

	public ArrayList<Estado> retroceder(ArrayList<Estado> historial) {
		
		historial.remove(historial.size()-1);		//remove(indice) vs remove(obj)
		return historial;
	}
	public void verifyEmpty() {
	}
}
