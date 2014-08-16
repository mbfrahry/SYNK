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
	public boolean reversed;
	
	public Player(){
		halfwayPoint = 400-Assets.player.getWidth()/2;		
		x = halfwayPoint;
		y = 800;
		moveLeft = false;
		moveRight = false;
		health = 1000;
		spriteIndex = 0;
		timePassed=0;
		reversed = false;
	}
	
	private void move(){
		if(reversed){
			if(!moveLeft && !moveRight){
				if(x > halfwayPoint){
					if(x < 800-Assets.player.getWidth()-2)
						x+=7;
				}
				if(x < halfwayPoint){
					if(x > 2)
						x -=7;
				}
			}
			if(moveLeft && moveRight){

			}
			else if(moveLeft && x < 800-Assets.player.getWidth()-2){
				if(x < 800-Assets.player.getWidth()-2)
					x += 15;
			}
			else if(moveRight && x > 2 ){
				if(x > 2)
					x -= 15;
			}
		}
		else{
			if(!moveLeft && !moveRight){
				if(x > halfwayPoint){
					x-=7;
				}
				if(x < halfwayPoint){
					x +=7;
				}
			}
			if(moveLeft && moveRight){

			}
			else if(moveLeft && x > 2)
				x -= 15;
			else if(moveRight && x < 800-Assets.player.getWidth()-2)
				x += 15;
		}

	}
	
	public void update(float deltaTime){
		move();
		deltaTime *= 1000;
		timePassed += deltaTime;
		spriteIndex = (int) ((timePassed%499)/100);
	}
}
