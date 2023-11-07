package linea;



public class Game {

  public static void main( String[] args) throws Exception {

    System.out.println( "Dimensiones?");
    CuatroEnLinea game = new CuatroEnLinea( intPrompt( "Base? " ), intPrompt( "Altura? " ), charPrompt("Modo? EN MAYUSCULA") );
    System.out.println( game.show() );
    while ( !game.finished() ) {
      game.playRedAt( intPrompt( "Rojas? " ) );
      System.out.println( game.show() );
      if (game.finished()) {
    	  System.out.print("gano rojo :)\n");
      }
      if ( !game.finished() ) {
        game.playBlueAt( intPrompt( "Azules? " ) );
        System.out.println( game.show() );
        if (game.finished()) {
      	  System.out.print("gano azul :)\n");
        }
      }
      
    }
  }
  
  public static int intPrompt( String message ) {

    System.out.print( message );

    return Integer.parseInt( System.console().readLine() );
  }
  private static char charPrompt( String message) {
	  System.out.print(message);
	  
	  return System.console().readLine().charAt(0);
  }
}
// SE PUEDE USAR IF PARA SABR SI LA COLUMNA ESTA LLENA