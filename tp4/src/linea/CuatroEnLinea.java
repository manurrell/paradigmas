package linea;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CuatroEnLinea {
	private int base;
	private int altura;
	private Mode mode;
	private ArrayList<ArrayList<Character>> tablero = new ArrayList<>();
	private State estado;
	
	public CuatroEnLinea(int b, int a, char modo) {
		if (b<=0 || a<=0) {
			throw new Error ("El tamaño de tablero ingresado es inválido.");
		}
		base=b;
		altura=a;
		estado=new TurnRed();
		IntStream.range(0, base).forEach(i -> tablero.add(new ArrayList<Character>()));
		mode=Mode.selectGamemode(modo);
		
	}
	public String show() {
	    ArrayList<String> output = new ArrayList<>();

	    IntStream.range(0, altura)
	            .mapToObj(fil -> createRow(fil))
	            .forEach(s -> output.add(0, s));

	    return String.join("\n", output);
	}

	private String createRow(int fil) {
	    return "|" +IntStream.range(0, base)
	            .mapToObj(col -> {
	                if (tablero.get(col).size() > fil) {
	                    return " " + tablero.get(col).get(fil);
	                } else {
	                    return " _";
	                }
	            })
	            .collect(Collectors.joining()) + " |";
	}

	
	public int getBase() {
		return tablero.size();
	}

	public void checkIfFinished() {
		if (mode.checkIfRedWon(this) || mode.checkIfBlueWon(this) ) {
			estado= new Finished(estado.getMsg());
		} else if ( isDraw()) {
			estado = new Finished("Empate");
		}
	}
	
	public boolean finished() {
		return estado.isGameFinished();
	}
	
	public void addFicha(int pos, char player) {
		if (pos> base || pos <=0) {
			throw new Error ("La columna indicada esta fuera de los parametros establecidos.");
		}
		if (tablero.get(pos-1).size()< altura) {
			tablero.get(pos-1).add(player);
		}
		else {
			throw new Error("La columna está llena");
		}
	}
	public void playRedAt(int prompt) {		
		estado= estado.canRedPlay(this,prompt);
		checkIfFinished();
	}

	public void playBlueAt(int prompt) {
		estado= estado.canBluePlay(this, prompt);
		checkIfFinished();

	}
	private boolean isDraw() {
		return tablero.stream().allMatch(col -> col.size()==altura);
	}

	public ArrayList<ArrayList<Character>> getBoard() {
		return tablero;
	}

	public int getHeight() {
		return altura;
	}

	public String getFinalMsg() {
		return estado.getMsg();
	}

}
