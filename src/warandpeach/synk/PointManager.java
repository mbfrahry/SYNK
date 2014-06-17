package warandpeach.synk;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Point;
import android.util.Log;

public class PointManager {

	ArrayList<Point> pointsBuffer;
	ArrayList<Point> points;
	int currentX;
	int maxPoints;
	int speed;
	int passedPoints;
	Random rand;
	//int[] speeds = {500, 1000, 5000, 10000, 20000, 50000};
	int[] speeds = {500, 750, 1500, 3000, 6000, 9000};
	int speedIndex;
	int totalPixels;
	
	public PointManager(){
		maxPoints = 1401/3;
		pointsBuffer = new ArrayList<Point>();
		points = new ArrayList<Point>();
		for(int i = 0; i < maxPoints; i++){
			Point currPoint = new Point();
			currPoint.x = 400;
			currPoint.y = 1280 - i*3;
			points.add(currPoint);
		}
		rand = new Random();
		speed = 3;
		passedPoints = 0;
		speedIndex = 0;
		totalPixels = 0;
	}
	
	private void movePoints(){
		for(int i = 0; i < points.size(); i++){
			Point currPoint = points.get(i);
			currPoint.y += speed;
			if(currPoint.y > 1280){
				points.remove(i);
				pointsBuffer.add(currPoint);
				passedPoints++;
				totalPixels++;
			}			
		}
		
	}
	
	private void updatePoints(){
		while(pointsBuffer.size()>0){
			Point currPoint = pointsBuffer.remove(0);
			
			Point lastPoint = points.get(points.size()-1);
			
			int nextMin = Math.max(0, lastPoint.x-22);
			int nextMax = Math.min(799, lastPoint.x+23);
			int randomX = rand.nextInt(nextMax - nextMin);
			int nextX = nextMin + randomX;
			currPoint.x = nextX;
			currPoint.y = lastPoint.y - 3;
			points.add(currPoint);
		}
		
	}
	
	private void updateSpeed(){
		if(speedIndex < speeds.length){
			if(passedPoints >= speeds[speedIndex]){
				passedPoints = 0;
				speed +=3;
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
