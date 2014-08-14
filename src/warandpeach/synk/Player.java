package warandpeach.synk;

import java.util.Calendar;

import android.util.Log;

public class Player {

	public int x;
	public int y;
	public boolean moveLeft;
	public boolean moveRight;
	public int halfwayPoint;
	public int health;
	public int spriteIndex;
	public float timePassed;
	
	public Player(){
		halfwayPoint = 400-Assets.player.getWidth()/2;		
		x = halfwayPoint;
		y = 800;
		moveLeft = false;
		moveRight = false;
		health = 1000;
		spriteIndex = 0;
		timePassed=0;
	}
	
	private void move(){
		if(!moveLeft && !moveRight){
			if(x > halfwayPoint){
				x-=10;
			}
			if(x < halfwayPoint){
				x +=10;
			}
		}
		if(moveLeft && moveRight){
			
		}
		else if(moveLeft && x > 2)
			x -= 20;
		else if(moveRight && x < 800-Assets.player.getWidth()-2)
			x += 20;
		
	}
	
	public void update(float deltaTime){
		move();
		deltaTime *= 1000;
		timePassed += deltaTime;
		spriteIndex = (int) ((timePassed%499)/100);
	}
}
