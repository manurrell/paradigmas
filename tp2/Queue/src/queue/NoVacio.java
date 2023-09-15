package queue;

import java.util.ArrayList;

public class NoVacio extends Estado {
	
	private Object element;
	
	public NoVacio(Object cargo) {
		element=cargo;
	}
	public ArrayList<Estado> quitar(ArrayList<Estado> list) {
		list.remove(list.size()-1);
		return list;
	}
	public Object devolverElement() {
		return this.element;
	}
	public boolean esVacio() {
		return false;
	}
}
