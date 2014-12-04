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
		
		double start = 0;
		
		while(run){

			int objectX;
			
			Item healthItem = itemManager.findItem(4);
			if(healthItem != null){
				objectX = healthItem.x;
			}
			else{
				Point point = pointManager.getPoint(player.y);
				objectX = point.x;
			}
			
			movePlayerViaPoint(objectX);
					
					
			/*
			if(start/50 <= 1 ){
				player.moveRight = false;
				player.moveLeft = true;
				start++;
			}
			else{
				player.moveRight = true;
				player.moveLeft = false;
				start++;
				if(start > 100){
					start = 0;
				}
			}*/
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
}
