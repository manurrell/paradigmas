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
		if (b<=0 || a<=0) {
			throw new Error ("El tamaño de tablero ingresado es inválido.");
		}
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

	public String show() {
		String row;
		ArrayList<String> output = new ArrayList<>();
		for (int fil=altura-1; fil>=0; fil--) {
			row="|"; 
			for (int col=0; col<=base-1; col++) {
				if (tablero.get(col).size()>fil) {
					row= row +" " + tablero.get(col).get(fil);
				} else {
					row = row + " _";
				}
			}
			row= row+ " |";
			output.add(row);
			
			
		}
		
		return String.join("\n", output);
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
		if (tablero.get(pos-1).size()< altura) {
			tablero.get(pos-1).add(player);
		}
		else {
			throw new Error("Esta llena la columna  hermano");
		}
	}
	public void playRedAt(int prompt) {
		if (prompt> base || prompt <=0) {
			throw new Error ("La columna indicada esta fuera de los parametros establecidos.");
		}
		estado.canRedPlay(this,prompt);
		estado= new TurnBlue();
		checkIfFinished();
	}

	public void playBlueAt(int prompt) {
		if (prompt> base || prompt <=0) {
			throw new Error ("La columna indicada esta fuera de los parametros establecidos.");}
		estado.canBluePlay(this, prompt);
		estado= new TurnRed();
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
