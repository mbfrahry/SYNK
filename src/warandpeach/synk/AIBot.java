package warandpeach.synk;

import android.graphics.Point;
import android.os.AsyncTask;

public class AIBot extends AsyncTask<String[], String[], String[]>{

	Player player;
	PointManager pointManager;
	
	public AIBot(PointManager pM, Player pl){
		player = pl;
		pointManager = pM;
	}

	@Override
	protected String[] doInBackground(String[]... params) {

		boolean run = true;
		
		double start = 0;
		
		while(run){
			Point point = pointManager.getPoint(player.y);
			if(player.x >= point.x){
				player.moveLeft = true;
				player.moveRight = false;
			}
			else{
				player.moveLeft = false;
				player.moveRight = true;
			}
					
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

}
