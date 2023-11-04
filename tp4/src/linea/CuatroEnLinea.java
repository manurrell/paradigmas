package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CuatroEnLinea {
	private int base;
	private int altura;
	private Mode mode;
	private ArrayList<ArrayList<Character>> tablero;
	private State estado;
	
	public CuatroEnLinea(int b, int a, char modo) {
		base=b;
		altura=a;
		estado=new TurnRed();
//		for (int i=0;i<base;i++ ) {
//			tablero.add(new ArrayList<Character>());
//		}
		tablero = IntStream.range(0, base)
		        .collect(ArrayList::new, (list, i) -> list.add(new ArrayList<Character>()), ArrayList::addAll);

		mode=Mode.selectGamemode(modo);
		
	}

	public char[] show() {
		String strong = "|_________|";
		char[] caracteres = strong.toCharArray(); 
		System.out.println(caracteres);
		return caracteres;
	}
	public int getBase() {
		return tablero.size();
	}

	public void checkIfFinished() {
		if (mode.checkIfRedWon(this) || mode.checkIfBlueWon(this) || isDraw()) {
			estado=new Finished();
		}
	}
	
	public boolean finished() {
		return estado.isGameFinished();
	}
	

	public void playRedAt(int prompt) {
		if (estado.canRedPlay()) {
		if (tablero.get(prompt-1).size()< altura) {
			tablero.get(prompt-1).add('R');
			estado= new TurnBlue();
			checkIfFinished();
			
		}
		else {
			this.playRedAt(Game.intPrompt("Diablos amigo esa columna esta llena, intentalo nuevamente en otra columna"));
			// CAMBIAR ESTO CUANDO NO TENGAMOS FIACA
		}
		}
		
	}

	public void playBlueAt(int prompt) {
		if (estado.canBluePlay()) {
		if (tablero.get(prompt-1).size()< altura) {
			tablero.get(prompt-1).add('B');
			estado= new TurnRed();
			checkIfFinished();
		}
		else {
			this.playBlueAt(Game.intPrompt("Diablos amigo esa columna esta llena, intentalo nuevamente en otra columna"));
			// CAMBIAR ESTO CUANDO NO TENGAMOS FIACA
		}
		}
	}
	public boolean isEmpty() {
		return true;
	}
	private boolean isDraw() {
		return tablero.stream().allMatch(col -> col.size()==altura);
	}
	public Mode getMode() {
		return mode;
	}

	public ArrayList<ArrayList<Character>> getBoard() {
		return tablero;
	}

	public int getHeight() {
		return altura;
	}

}
