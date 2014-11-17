package warandpeach.synk;

import android.graphics.Point;
import android.util.Log;

public class World {

	public Player player;
	public PointManager pointManager;
	public ItemManager itemManager;
	public boolean gameOver = false;
	public int coins;
	
	public World(){
		player = new Player();
		pointManager = new PointManager();
		itemManager = new ItemManager();
		coins = 0;
	}
	
	private void updatePlayerHealth(){
		int level = pointManager.speedIndex;
//		int startingPoint = 150+ level*3;
//		for(int i = 0; i < 30; i++){
//			Point currPoint = pointManager.points.get(i+startingPoint);
//			if(currPoint.x >= player.x-Assets.player.getWidth() && currPoint.x <= player.x+Assets.player.getWidth())
//				return;
//		}
		int ind = 0;
		while(pointManager.points.get(ind).y > player.y + Assets.player.getHeight()){
			ind++;
		}
		//Log.d("pos","" + player.x + "  " + (player.x+Assets.player.getWidth()));
		while(pointManager.points.get(ind).y > player.y){
			Point currPoint = pointManager.points.get(ind);
			if(currPoint.x >= player.x-Assets.player.getWidth()*.5 && currPoint.x <= player.x+Assets.player.getWidth()*1.5)
				return;
			ind++;
		}
		player.health--;
		if(player.health <= 0){
			gameOver = true;
		}
	}
	
	public void checkItemCollision(){
		for(int i = 0 ; i < itemManager.items.size(); i++){
			Item item = itemManager.items.get(i);
			if(item.y+Assets.coin.getHeight() > player.y && item.y < player.y+Assets.player.getHeight()){
				if(item.x < player.x+Assets.player.getWidth() && item.x+Assets.coin.getWidth() > player.x){
					item.y = 1281;
					if(item.itemID == 0){
						coins++;
					}
					if(item.itemID == 1){
						player.health += 100;
					}
					if(item.itemID == 2){
						player.reversed = !player.reversed;
					}
					if(item.itemID == 3){
						pointManager.speed*=2;
					}
					if(item.itemID == 4){
						pointManager.speed/=2;
					}
				}
			}
		}
	}
	
	public void update(float deltaTime){
		if(gameOver)
			return;
	
		player.update(deltaTime);
		pointManager.update(deltaTime);
		itemManager.update(deltaTime);
		updatePlayerHealth();
		checkItemCollision();
	}
}
