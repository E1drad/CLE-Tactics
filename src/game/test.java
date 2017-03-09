package game;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGame game= new BaseGame(10,10);
		
		game.startGame();
		game.setExitingGame(true);
	}

}
