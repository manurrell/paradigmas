package queue;

import java.util.ArrayList;

public class NoVacia extends Array {
	private ArrayList<Object> lista = new ArrayList<>();
	
	public NoVacia(Object cargo ) {
		this.lista.add(cargo);
	}
	public NoVacia añadir(Object cargo) {
		this.lista.add(0, cargo);
		return this;
	}
	public boolean esVacio() {
		return false;
	}

	
}
