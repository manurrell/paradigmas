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
	public String getFinalMsg() {
		return estado.getMsg();
	}
	public boolean checkVerticallyAndHorizontally(char player) {
		ArrayList<Boolean> verify_list= new ArrayList<>();
		verify_list.add(verifyVertical(player));
		verify_list.add(verifyHorizontal(player));
		return verify_list.stream().anyMatch(bool -> bool);
	}
	private boolean verifyVertical(char player) {	
		return IntStream.range(0, base).anyMatch(col -> {
	        long count = IntStream.range(0, getColSize(col))
	            .mapToObj(fil -> getValueAt(col,fil))
	            .takeWhile(cell -> cell == player)
	            .count();
	        
	        if (count >= 4) {
	            return true;
	        }else {
	        	return false;
	        }
	    });
	}
	
	private boolean verifyHorizontal(char player) {
	    return IntStream.range(0, altura).anyMatch(fil -> {
	    	 long count = IntStream.range(0, base).mapToObj(col -> { 
	    		if (getColSize(col)>fil) {
	    			return getValueAt(col,fil);
	    		} else {
	    			return '-';
	    		}
	    	}).takeWhile(cell -> cell== player).count();
	    	 if (count>=4) {
	    		 return true;
	    	 } else {
	    		 
	    		return false;
	    	 }
	    }); 
	}
	
	public boolean checkDiagonally(char player) {
		ArrayList<Boolean> chequeos = new ArrayList<>();
		IntStream.range(1, altura + 1)
	    .forEach(i -> {
	        chequeos.add(verifyDiagonalRight(player, 0, altura - i));
	        chequeos.add(verifyDiagonalLeft(player, base-1, altura - i));
	    });
		IntStream.range(1, base).forEach(i -> {
		    chequeos.add(verifyDiagonalRight(player,i, 0));
		    chequeos.add(verifyDiagonalLeft(player, base - 1 - i, 0));
		});
		return (chequeos.stream().anyMatch(b->b));
	}
	
	private boolean verifyDiagonalLeft(char player, int startingX, int startingY) {
		long count = IntStream.range(0, startingX+1).mapToObj(i -> {
			int filaActual= i+startingY;
			int colActual= startingX-i;
    		if (getColSize(colActual)>filaActual) {
    			return getValueAt(colActual,filaActual);
    		} else {
    			return '-';
    		}
		}).takeWhile(cell -> cell==player).count();	
		if (count>=4) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean verifyDiagonalRight(char player, int startingX, int startingY) {
		long count = IntStream.range(startingX, base).mapToObj(col -> {
			int filaActual= col-startingX+startingY;
    		if (getColSize(col)>filaActual) {
    			return getValueAt(col,filaActual);
    		} else {
    			return '-';
    		}
		}).takeWhile(cell -> cell==player).count();
		
		if (count>=4) {
			return true;
		} else {
			
			return false;
		}
	}
	private char getValueAt(int x, int y) {
		return tablero.get(x).get(y);
	}
	private int getColSize(int x){
		return tablero.get(x).size();
	}

}
