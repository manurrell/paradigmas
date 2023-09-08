package queue;

import java.util.ArrayList;

public class NoVacia extends Array {
	private ArrayList<Object> lista;
	public NoVacia(ArrayList<Object> arglist ) {
		super();
		lista = arglist;
	}
	public NoVacia añadir(Object cargo) {
		
	}
	
	
	public boolean esVacio() {
		return false;
	}
}
