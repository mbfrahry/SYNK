package warandpeach.synk;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Point;
import android.util.Log;

public class PointManager {

	ArrayList<Point> pointsBuffer;
	ArrayList<Point> points;
	PointCalculator pointCalculator;
	int currentX;
	int maxPoints;
	int speed;
	int passedPoints;
	Random rand;
	//int[] speeds = {500, 1000, 5000, 10000, 20000, 50000};
	int[] speeds = {250, 500, 750, 1000, 1500, 2000, 2500, 3000, 4500, 6000, 7500, 9000, 10000};
	int speedIndex;
	int totalPixels;
	int lineDelta;
	int pointsLeft;
	int halfPlayerWidth;
	int moved;
	int randAmp;
	
	public PointManager(){
		maxPoints = 1401/3;
		pointsBuffer = new ArrayList<Point>();
		points = new ArrayList<Point>();
		pointCalculator = new PointCalculator();
		for(int i = 0; i < maxPoints; i++){
			Point currPoint = new Point();
			currPoint.x = 400;
			currPoint.y = 1280 - i*3;
			points.add(currPoint);
		}
		rand = new Random();
		speed = 10;
		passedPoints = 0;
		speedIndex = 0;
		totalPixels = 0;
		lineDelta = 0;
		pointsLeft = 0;
		halfPlayerWidth = Assets.player.getWidth()/2;
		moved = 0;
		randAmp = 200;
	}
	
	private void movePoints(){
		for(int i = 0; i < points.size(); i++){
			Point currPoint = points.get(i);
			currPoint.y += speed;
			if(currPoint.y > 1280){
				points.remove(i);
				pointsBuffer.add(currPoint);
				passedPoints++;
				totalPixels+=5;
			}
		}
		
	}
	
	private void updatePoints(){
//		int startX = 0;
//		int finishX = 0;
//		int startY = 0;
//		int finishY = 0;
		
		while(pointsBuffer.size()>0){
			
//			Point currPoint = pointsBuffer.remove(0);
//			Point lastPoint = points.get(points.size()-1);
			/*
			//			pointCalculator.getNextPoint(currPoint, lastPoint.x, lastPoint.y);
			int sinX = 0;

			sinX = (int) (randAmp*(Math.sin((moved *.01)))+400);
			if(Math.abs(sinX - randAmp) < 10 || sinX + randAmp < 10 ){
				Log.d("randAmp", randAmp +"");
				randAmp = rand.nextInt(400) + -200;
			}
			currPoint.x =sinX;

			if(sinX == 0){
				moved = 0;
			}
			Log.d("sinX", sinX +"");

			currPoint.y = lastPoint.y -5;
			moved+=5;
			points.add(currPoint);
*/
			
			if(pointsLeft == 0){
				pointsLeft += rand.nextInt(8) + 5;
				lineDelta = rand.nextInt(43);
				lineDelta -= 21;
			}
			
			Point currPoint = pointsBuffer.remove(0);
			Point lastPoint = points.get(points.size()-1);
			

			int nextX = lastPoint.x + lineDelta;
			if(nextX < halfPlayerWidth){
				nextX = halfPlayerWidth;
			}
			else if(nextX > 800 - halfPlayerWidth){
				nextX = 800 - halfPlayerWidth;
			}
			currPoint.x = nextX;
			currPoint.y = lastPoint.y - 20;
			points.add(currPoint);
			pointsLeft--;
			
			
			
			//			Point currPoint = pointsBuffer.remove(0);
//			
//			Point lastPoint = points.get(points.size()-1);
//			
//			int nextMin = Math.max(0, lastPoint.x-65);
//			int nextMax = Math.min(799, lastPoint.x+66);
//			int randomX = rand.nextInt(nextMax - nextMin);
//			int nextX = nextMin + randomX;
//			currPoint.x = nextX;
//			currPoint.y = lastPoint.y - 40;
//			points.add(currPoint);
		}
		
	}
	
	private void updateSpeed(){
		if(speedIndex < speeds.length){
			if(passedPoints >= speeds[speedIndex]){
				passedPoints = 0;
				speed +=4;
				speedIndex++;
			}
		}
	}
	
	public void update(double deltaTime){
		movePoints();
		updatePoints();
		updateSpeed();
	}
}
