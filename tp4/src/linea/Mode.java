package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Mode {
	protected char id;
	private static ArrayList<Mode> gamemodes = new ArrayList<>(Arrays.asList(new ModeA(), new ModeB(), new ModeC()));
	public static Mode selectGamemode(char a) {
		List<Mode> gamemode = gamemodes.stream().filter(modo -> modo.applies(a)).collect(Collectors.toList());
		if (gamemode.size()!=0) {
			
			return gamemode.get(0);
		} 
		throw new Error("El modo seleccionado es invalido");
	}
	public boolean applies(char a) {
		return id==a;
	}
	
	public boolean equals(Mode m) {
		return id==m.getId();
	}
	public char getId() {
		return id;

	}
	protected boolean checkVerticallyAndHorizontally(char player, CuatroEnLinea tablero) {
		ArrayList<Boolean> verify_list= new ArrayList<>();
		verify_list.add(verifyVertical(player, tablero));
		verify_list.add(verifyHorizontal(player, tablero));
		return verify_list.stream().anyMatch(b -> b);
	}
	
	
	protected boolean checkDiagonally(char player, CuatroEnLinea juego) {
		ArrayList<Boolean> chequeos = new ArrayList<>();
		IntStream.range(1, juego.getHeight() + 1)
	    .forEach(i -> {
	        chequeos.add(verifyDiagonalRight(player, juego, 0, juego.getHeight() - i));
	        chequeos.add(verifyDiagonalLeft(player, juego, juego.getBase() - 1, juego.getHeight() - i));
	    });
		IntStream.range(1, juego.getBase()).forEach(i -> {
		    chequeos.add(verifyDiagonalRight(player, juego, i, 0));
		    chequeos.add(verifyDiagonalLeft(player, juego, juego.getBase() - 1 - i, 0));
		});

		return (chequeos.stream().anyMatch(b->b));
	}
	protected boolean verifyVertical(char player, CuatroEnLinea juego) {	
		return IntStream.range(0, juego.getBase()).anyMatch(i -> {
	        long count = IntStream.range(0, juego.getBoard().get(i).size())
	            .mapToObj(a -> juego.getBoard().get(i).get(a))
	            .takeWhile(cell -> cell == player)
	            .count();
	        
	        if (count >= 4) {
	            return true;
	        }else {
	        	return false;
	        }
	    });
	}
	    	protected boolean verifyHorizontal(char player, CuatroEnLinea juego) {
	    	    return IntStream.range(0, juego.getHeight()).anyMatch(fil -> {
	    	    	 long count = IntStream.range(0, juego.getBase()).mapToObj(col -> { 
	    	    		if (juego.getBoard().get(col).size()>fil) {
	    	    			return juego.getBoard().get(col).get(fil);
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
	protected boolean verifyDiagonalRight(char player, CuatroEnLinea juego, int startingX, int startingY) {
		long count = IntStream.range(startingX, juego.getBase()).mapToObj(col -> {
			int filaActual= col-startingX+startingY;
    		if (juego.getBoard().get(col).size()>filaActual) {
    			return juego.getBoard().get(col).get(filaActual);
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

	protected boolean verifyDiagonalLeft(char player, CuatroEnLinea juego, int startingX, int startingY) {
		long count = IntStream.range(0, startingX+1).mapToObj(i -> {
			int filaActual= i+startingY;
			int colActual= startingX-i;
    		if (juego.getBoard().get(colActual).size()>filaActual) {
    			return juego.getBoard().get(colActual).get(filaActual);
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
	
	
	
	public abstract boolean checkIfBlueWon(CuatroEnLinea tablero);
	public abstract boolean checkIfRedWon(CuatroEnLinea tablero);

}