package queue;

import java.util.ArrayList;

public class NoVacio extends Estado {
	private Object element;
	public NoVacio(Object cargo) {
		element=cargo;
		
	}
	public ArrayList<Estado> retroceder(ArrayList<Estado> historial) {
		
		historial.remove(historial.size()-1);		//remove(indice) vs remove(obj)
		return historial;
	}
	public Object devolverElement() {
		return this.element;
	}
	public boolean esVacio() {
		return false;
	}
}
