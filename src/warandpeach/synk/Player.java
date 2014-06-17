package warandpeach.synk;

public class Player {

	public int x;
	public int y;
	public boolean moveLeft;
	public boolean moveRight;
	public int halfwayPoint;
	public int health;
	
	public Player(){
		halfwayPoint = 400-Assets.player.getWidth()/2;		
		x = halfwayPoint;
		y = 800;
		moveLeft = false;
		moveRight = false;
		health = 1000;
	}
	
	private void move(){
		if(!moveLeft && !moveRight){
			if(x > halfwayPoint){
				x-=3;
			}
			if(x < halfwayPoint){
				x +=3;
			}
		}
		if(moveLeft && x > 0)
			x -= 6;
		if(moveRight && x < 800-Assets.player.getWidth())
			x += 6;
		
	}
	
	public void update(float deltaTime){
		move();
	}
}
