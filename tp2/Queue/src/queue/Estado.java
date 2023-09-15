package queue;

import java.util.ArrayList;

public abstract class Estado {

	static Estado newVacio() {
		return new Vacio();	
	}
	static Estado newNoVacio(Object elemento) {
		return new NoVacio(elemento);
	}
	
	public abstract boolean esVacio();
	public abstract Object devolverElement();
	public abstract ArrayList<Estado> quitar(ArrayList<Estado> historial);
}
