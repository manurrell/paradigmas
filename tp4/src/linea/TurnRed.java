package linea;

public class TurnRed extends State {


	public boolean canRedPlay() {
		return true;
	}

	public boolean canBluePlay() {
		return false;
	}

	@Override
	public boolean isGameFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
