package warandpeach.synk;

import java.util.List;

import android.graphics.Color;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Pixmap;
import com.badlogic.androidgames.framework.Screen;

public class GameScreen extends Screen {
	enum GameState{
		Ready,
		Running,
		Paused,
		GameOver
	}
	
	GameState state = GameState.Ready;
	World world;
	
	public GameScreen(Game game){
		super(game);
		world = new World();
	}
	
	public void update(float deltaTime){
		List <TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		if(state == GameState.Ready)
			updateReady(touchEvents);
		if(state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if(state == GameState.Paused)
			updatePaused(touchEvents);
		if(state == GameState.GameOver)
			updateGameOver(touchEvents);
	}
	
	private void updateReady(List<TouchEvent>touchEvents){
		if(touchEvents.size() > 0)
			state = GameState.Running;
	}
	
	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime){
		int len = touchEvents.size();
		for(int i = 0; i < len; i++){
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP){
				if(event.y < 200 ){
					state = GameState.Paused;
					return; 
				}
			}
			
		}
		world.update(deltaTime);
		if(world.gameOver){
			state = GameState.GameOver;
		}
	}
	
	private void updatePaused(List <TouchEvent> touchEvents){
		int len = touchEvents.size();
		for(int i = 0; i < len; i++){
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP){
				if(event.y > 800){
					state = GameState.Running;
				}
				if(event.y < 200){
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}
	}
	
	private void updateGameOver(List<TouchEvent> touchEvents){
		int len = touchEvents.size();
		for(int i = 0; i < len; i++){
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP){
				if(event.y > 0){
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
			
		}
	}
	
	public void present(float deltaTime){
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		
		drawWorld(world);
		if(state == GameState.Ready)
			drawReadyUI();
		if(state == GameState.Running)
			drawRunningUI();
		if(state == GameState.Paused)
			drawPausedUI();
		if(state == GameState.GameOver)
			drawGameOverUI();
			
		
	}
	
	private void drawWorld(World world){
		Graphics g = game.getGraphics();
		Player player = world.player;
		
		Pixmap playerPixmap = Assets.player;
		int x = player.x;
		int y = player.y;
		g.drawPixmap(playerPixmap, x, y);
		
	}
	
	private void drawReadyUI(){
		Graphics g = game.getGraphics();
		
		
	}
	
	private void drawRunningUI(){
		Graphics g = game.getGraphics();
		
		g.drawRect(0, 1100, 150, 150, Color.WHITE);
		g.drawRect(650, 1100, 150, 150, Color.WHITE);
	}
	
	private void drawPausedUI(){
		Graphics g = game.getGraphics();
	}
	
	private void drawGameOverUI(){
		Graphics g = game.getGraphics();
	}
	
	public void pause(){
		if(state == GameState.Running)
			state = GameState.Paused;
		if(world.gameOver){
			Settings.save(game.getFileIO());
		}
	}
	
	public void resume(){
		
	}
	
	public void dispose(){
		
	}
}

