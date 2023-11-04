package linea;

public class Finished extends State{

	@Override
	public boolean canRedPlay() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBluePlay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isGameFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
