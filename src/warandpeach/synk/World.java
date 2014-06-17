package warandpeach.synk;

import android.graphics.Point;
import android.util.Log;

public class World {

	public Player player;
	public PointManager pointManager;
	public boolean gameOver = false;
	
	
	public World(){
		player = new Player();
		pointManager = new PointManager();
	}
	
	private void updatePlayerHealth(){
		int level = pointManager.speedIndex;
		int startingPoint = 150+ level*3;
		for(int i = 0; i < 30; i++){
			Point currPoint = pointManager.points.get(i+startingPoint);
			if(currPoint.x >= player.x-Assets.player.getWidth() && currPoint.x <= player.x+Assets.player.getWidth())
				return;
		}
		player.health--;
		if(player.health <= 0){
			gameOver = true;
		}
	}
	
	public void update(float deltaTime){
		if(gameOver)
			return;
	
		player.update(deltaTime);
		pointManager.update(deltaTime);
		updatePlayerHealth();
	}
}
