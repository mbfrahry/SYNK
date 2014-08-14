package warandpeach.synk;

import java.util.List;

import android.graphics.Color;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class HighScoreScreen extends Screen{

	public HighScoreScreen(Game game){
		super(game);
	}
	
	public void update(float deltaTime){
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i = 0; i <len; i++){
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_DOWN){
				game.setScreen(new MainMenuScreen(game));				
			}
		}
	}
	
	
	public void present(float deltaTime){
		Graphics g = game.getGraphics();
		
		g.drawPixmap(Assets.highScore, 0 ,0);
		for(int i = 0; i < Settings.highScores.length; i++){
			g.drawText(i+1 +": " + Settings.highScores[i], 325, 600+i*100, Color.WHITE);
		}
	}

	public void pause() {
		Settings.save(game.getFileIO());
	}

	public void resume() {
		
	}

	public void dispose() {
	}
}
