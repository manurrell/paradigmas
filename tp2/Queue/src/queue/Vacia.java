package queue;

import java.util.ArrayList;

public class Vacia extends Array {
	public boolean esVacio() {
		return true;
	}
	
public Object cabeza() {
	throw new Error("Queue is empty");
}
public ArrayList<NoVacia> añadir(Object cargo) {
	ArrayList<NoVacia> a = new ArrayList<>();
	a.add(Array.noVacio(cargo));
	return a;
}
public int tamaño() {
	return 0;
}


}
