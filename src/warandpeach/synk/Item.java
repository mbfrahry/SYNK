package warandpeach.synk;

public class Item {

	int itemID;
	int x;
	int y;
	
	public Item(){
		itemID = 0;
		x = 0; 
		y = 0;
	}
	
	public void move(){
		y += 10;
	}
	
	public void update(float deltaTime){
		move();
	}
}
