package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CuatroEnLinea {
	private int base;
	private int altura;
	private Mode mode;
	private ArrayList<ArrayList<Character>> tablero;
	
	public CuatroEnLinea(int b, int a, char modo) {
		base=b;
		altura=a;
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
	public int getBoardSize() {
		return tablero.size();
	}

	public boolean finished() {
		return mode.checkIfRedWon(this) || mode.checkIfBlueWon(this);
	}

	public void playRedAt(int prompt) {
		if (tablero.get(prompt-1).size()< altura) {
			tablero.get(prompt-1).add('R');
		}
		else {
			this.playRedAt(Game.intPrompt("Diablos amigo esa columna esta llena, intentalo nuevamente en otra columna"));
			// CAMBIAR ESTO CUANDO NO TENGAMOS FIACA
		}
		
	}

	public void playBlueAt(int prompt) {
		if (tablero.get(prompt-1).size()< altura) {
			tablero.get(prompt-1).add('B');
		}
		else {
			this.playBlueAt(Game.intPrompt("Diablos amigo esa columna esta llena, intentalo nuevamente en otra columna"));
			// CAMBIAR ESTO CUANDO NO TENGAMOS FIACA
		}
		
	}
	public boolean isEmpty() {
		return true;
	}
	public boolean isDraw() {
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
