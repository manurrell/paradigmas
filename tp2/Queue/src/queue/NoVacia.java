package queue;

import java.util.ArrayList;

public class NoVacia extends Array {
	private ArrayList<Object> lista = new ArrayList<>();
	
	public NoVacia(Object cargo ) {
		this.lista.add(cargo);
	}
	public NoVacia agregar(Object cargo) {
		this.lista.add(0, cargo);
		return this;
	}
	public ArrayList<NoVacia> añadir(Object cargo) {
		ArrayList<NoVacia> a = new ArrayList<>();
		a.add(Array.noVacio(cargo));
		a.add(Array.noVacio(cargo).agregar(this.lista.get(0)));
		return a;
	
	}
	public Object cabeza() {
		return lista.get(lista.size()-1);
	}
	public boolean esVacio() {
		return false;
	}
	public int tamaño() {
		return lista.size();
	}
	
}
