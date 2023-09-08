package queue;

import java.util.ArrayList;

public abstract class Array {
	static Array vacio() {
		return new Vacia();
	}
	static Array noVacio( ArrayList<Object> argList) {
		return new NoVacia(argList);
	}
	public abstract NoVacia añadir();
	public abstract boolean esVacio(); 
}
