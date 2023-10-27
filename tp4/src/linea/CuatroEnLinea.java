package linea;

public class CuatroEnLinea {
	int b;
	int a;
	char mode;
	
	public CuatroEnLinea(int base, int altura, char modo) {
		b=base;
		a=altura;
		mode=modo;
		
	}

	public char[] show() {
		String strong = "_ _ _ _ _ _";
		char[] caracteres = strong.toCharArray(); 
		System.out.println(caracteres);
		return caracteres;
	}

	public boolean finished() {
		return  true;
	}

	public void playRedAt(int prompt) {
		// TODO Auto-generated method stub
		
	}

	public void playBlueAt(int prompt) {
		// TODO Auto-generated method stub
		
	}

}
