package queue;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Array {
	static Vacia vacio() {
		return new Vacia();
	}
	static NoVacia noVacio( Object cargo) {
		return new NoVacia(cargo);
	}
	public abstract Object cabeza();
	public abstract ArrayList<NoVacia> añadir(Object cargo);
	public abstract boolean esVacio(); 
	public abstract int tamaño();
}
