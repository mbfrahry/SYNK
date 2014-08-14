package warandpeach.synk;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Point;
import android.util.Log;

public class PointCalculator {

	int direction;
	boolean onCurve;
	ArrayList<Integer> nextPoints;
	Random rand;
	int lastDelta;
	
	public PointCalculator(){
		
		onCurve = true;
		nextPoints  = new ArrayList<Integer>();
		rand = new Random();
		direction = rand.nextInt(2);
		lastDelta = 5;
		if(direction == 0){
			direction = -1;
		}
		else{
			direction = 1;
		}
	}
	
	public void getNextPoint(Point point, int currentX, int currentY){
//		if(nextPoints.size() >= 2){
//			//return nextPoints.remove(0);
//			
//			
//			point.x = nextPoints.remove(0);
//			point.y = nextPoints.remove(0);
//		}
//		else{
//			if(onCurve){
//				//make new straight line
//
//				int pointsLeft = rand.nextInt(10) + 1;
//				while(pointsLeft > 0){
//					currentX += lastDelta*direction;
//					currentY -= 20;
//					if(currentX < 50){
//						currentX = 50;
//						lastDelta = 0;
//					}
//					else if(currentX > 750){
//						currentX = 750;
//						lastDelta = 0;
//					}
//					else{
//						nextPoints.add(currentX);
//					}
//					nextPoints.add(currentY);
//					pointsLeft--;
//				}
//				
//				
//			}
//			else{
//				//make new curve
//				
//				//keep a start and end delta, gradually make it to the next delta which will be the slope of the next line
//				
//
//				
//				
//				int xDiff;
//				int yDiff;
//				
//				if(lastDelta == 0){
//					//10 will change here, just a place holder until i figure more out
//					xDiff = currentX +50*(-direction);
//					yDiff = currentY;
//				}
//				else{
//					xDiff = currentX +50*(-direction);
//					yDiff = currentY - 50;
//				}
//				
//				
//				double radiusSquared = (currentX - xDiff)*(currentX - xDiff) + (currentY - yDiff)*(currentY - yDiff); 
//				lastDelta = rand.nextInt(22);
//				int newDelta = lastDelta*-direction;
//				Log.d("lastDelta",lastDelta + "");
//				//double yAtslope = newDelta*(question - a) + b;
//				//radiusSquared = (question - a)*(question - a) + (yAtslope - b)*(yAtslope - b);
//				
//				
//				double a = 1+newDelta*newDelta;
//				double b = -2*xDiff - 2*xDiff*newDelta*newDelta;
//				double c = (newDelta*newDelta + 1)*xDiff*xDiff - radiusSquared;
//				
//
//				double xroot1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
//			    double xroot2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
//					
//				double xRoot;
//				if(direction == -1){
//					xRoot = Math.min(xroot1, xroot2);
//				}
//				else{
//					xRoot = Math.max(xroot1, xroot2);
//				}
//				double a2 = 1;
//				double b2 = -2*yDiff;
//				double c2 = yDiff*yDiff - radiusSquared + (xRoot - xDiff)*(xRoot - xDiff);
//				
//				double yRoot1 = (-b2 + Math.sqrt(Math.pow(b2, 2) - 4*a2*c2)) / (2*a2);
//				double yRoot2 = (-b2 - Math.sqrt(Math.pow(b2, 2) - 4*a2*c2)) / (2*a2);
//				
//				double yRoot = Math.min(yRoot1, yRoot2);
//				double yDelta = Math.round(currentY - yRoot)/10;
//				
//				for(int i = 1; i < 10; i++){
//					//Need to find x value at currentY + yDelta
//					double newY = currentY - yDelta*i;
//					double a3 = 1;
//					double b3 = -2*xDiff;
//					double c3 = xDiff*xDiff - radiusSquared + (newY - yDiff)*(newY - yDiff);
//					
//					double newRoot1 = (-b3 + Math.sqrt(Math.pow(b3, 2) - 4*a3*c3)) / (2*a3);
//					double newRoot2 = (-b3 - Math.sqrt(Math.pow(b3, 2) - 4*a3*c3)) / (2*a3);
//					
//					double newRoot;
//					if(direction == -1){
//						newRoot = Math.min(newRoot1, newRoot2);
//					}
//					else{
//						newRoot = Math.max(newRoot1, newRoot2);
//					}
//					
//					int XtoAdd = (int)Math.round(newRoot);
//					int YtoAdd = (int)Math.round(newY);
//					nextPoints.add(XtoAdd);
//					nextPoints.add(YtoAdd);
//				}
//				
//				
//				direction *= -1;
//				
//				
//			}
//			
//			onCurve = !onCurve;
//			point.x = nextPoints.remove(0);
//			point.y = nextPoints.remove(0);
//			
//		}
		
	}
	
}
