package warandpeach.synk;

import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class MainMenuScreen extends Screen{

	public MainMenuScreen(Game game){
		super(game);
	}
	
	public void update(float deltaTime){
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i = 0; i <len; i++){
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP){
				if(inBounds(event, 150, 950, 420, 170)){
					game.setScreen(new GameScreen(game));;
				}
			}
		}
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height){
		if(event.x > x && event.x < x + width-1 && event.y > y && event.y < y +height -1)
			return true;
		else
			return false;
	}
	
	public void present(float deltaTime){
		Graphics g = game.getGraphics();
		
		g.drawPixmap(Assets.mainMenu, 0 ,0);
		g.drawRect(152, 933, 430, 150, Color.WHITE);
		
	}

	public void pause() {
		Settings.save(game.getFileIO());
	}

	public void resume() {
		
	}

	public void dispose() {
	}
}
