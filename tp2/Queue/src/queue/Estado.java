package queue;

import java.util.ArrayList;

public abstract class Estado {

	
	static Estado newVacio() {
		return new Vacio();	
	}
	
	static Estado newNoVacio() {
		return new NoVacio();
	}
	
	
	public abstract ArrayList<Estado> retroceder(ArrayList<Estado> historial);
	public abstract void verifyEmpty();
}
