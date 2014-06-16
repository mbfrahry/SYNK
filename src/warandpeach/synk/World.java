package warandpeach.synk;

public class World {

	public Player player;
	public boolean gameOver = false;
	
	
	public World(){
		player = new Player();
	}
	
	public void update(float deltaTime){
		if(gameOver)
			return;
		
		player.update(deltaTime);
	}
}
