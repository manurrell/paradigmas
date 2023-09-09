package queue;

public class Vacia extends Array {
	public boolean esVacio() {
		return true;
	}
	
public Object cabeza() {
	throw new Error("Queue is empty");
}
public NoVacia añadir(Object cargo) {
	
	return Array.noVacio(cargo);
}
public int tamaño() {
	return 0;
}


}
