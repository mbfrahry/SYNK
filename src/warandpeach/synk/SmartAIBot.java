package warandpeach.synk;

import android.graphics.Point;
import android.os.AsyncTask;

public class SmartAIBot extends AsyncTask<String[], String[], String[]>{

	Player player;
	PointManager pointManager;
	ItemManager itemManager;
	
	public SmartAIBot(PointManager pM, Player pl, ItemManager iM){
		player = pl;
		pointManager = pM;
		itemManager = iM;
	}

	@Override
	protected String[] doInBackground(String[]... params) {

		boolean run = true;
	
		while(run){

			int objectX;
			
			Item healthItem = itemManager.findItem(1);
			if(healthItem != null){
				objectX = healthItem.x;
				moveToItem(player, healthItem);
			}
			else{
				Point point = pointManager.getPoint(player.y);
				objectX = point.x;
				movePlayerViaPoint(objectX);
			}
			
		}
		
		return null;
	}
	
	public void movePlayerViaPoint(int x){
		if(player.x >= x){
			if(player.reversed){
				player.moveLeft = false;
				player.moveRight = true;
			}
			else{
				player.moveLeft = true;
				player.moveRight = false;
			}
		}
		else{
			if(player.reversed){
				player.moveLeft = true;
				player.moveRight = false;
			}
			else{

				player.moveLeft = false;
				player.moveRight = true;
			}
		}
	}
	
	public void moveToItem(Player player, Item item){
		player.moveLeft = false;
		player.moveRight = false;
		
		//double distance = Math.sqrt(Math.pow((player.x - item.x),2) + Math.pow((player.y - item.y),2));
		//distance is the tangent of the triangle also!
		int changeY = findMinDistance(player.x, item.y);
		if(player.y-changeY < item.y){
		
			if(player.x >= item.x){
				if(player.reversed){
					player.moveLeft = false;
					player.moveRight = true;
				}
				else{
					player.moveLeft = true;
					player.moveRight = false;
				}
			}
			else{
				if(player.reversed){
					player.moveLeft = true;
					player.moveRight = false;
				}
				else{
	
					player.moveLeft = false;
					player.moveRight = true;
				}
			}
		}
	}
	
	public int findMinDistance(int playerX, int itemX){
		int diffX = playerX - itemX;
		diffX /= 15;
		return Math.abs(diffX * 10);
	}
}
