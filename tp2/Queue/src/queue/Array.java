package queue;

import java.util.ArrayList;

public abstract class Array {
	static Vacia vacio() {
		return new Vacia();
	}
	static NoVacia noVacio( Object cargo) {
		return new NoVacia(cargo);
	}
	public abstract Object cabeza();
	public abstract NoVacia añadir(Object cargo);
	public abstract boolean esVacio(); 
}
