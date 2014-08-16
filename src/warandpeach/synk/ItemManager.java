package warandpeach.synk;

import java.util.ArrayList;
import java.util.Random;

public class ItemManager {

	ArrayList<Item> items;
	Random rand;
	public ItemManager(){
		items = new ArrayList<Item>();
		for(int i = 0; i < 5; i++){
			Item item = new Item();
			item.y = 1281;
			items.add(item);
		}
		rand = new Random();
	}
	
	public void resetItem(Item item){
		int newId = rand.nextInt()%3;
		int newX = rand.nextInt(720);
		int newY = -rand.nextInt(3000);
		item.itemID = newId;
		item.x = newX;
		item.y = newY;
	}
	
	public void update(float deltaTime){
		
		for(int i = 0; i < items.size(); i++){
			Item item = items.get(i);
			if(item.y > 1280){
				resetItem(item);
			}
			item.update(deltaTime);
		}
	}
}
