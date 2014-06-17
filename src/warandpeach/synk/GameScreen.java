package warandpeach.synk;

import java.util.List;

import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

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
	
	GameState state = GameState.Running;
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
				if(event.y > 1100 ){
					if(event.x < 180){
						world.player.moveLeft = false;
					}
					
					if(event.x > 620){
						world.player.moveRight = false;
					}
				}
				
			}
			if(event.type == TouchEvent.TOUCH_DOWN){
				if(event.y > 1100 ){
					if(event.x < 180){
						world.player.moveLeft = true;
					}
					
					if(event.x > 620){
						world.player.moveRight = true;
					}
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
		
		int radiusLeft = calcRadius(player.x, -400);
		int radiusRight = calcRadius(-player.x, 400);
		
		g.drawArc(0, 1275, radiusLeft, 270, 90, Color.WHITE);
		g.drawArc(795, 1275, radiusRight, 180, 90, Color.WHITE);
		
		PointManager pointManager = world.pointManager;
		for(int i = 0; i < pointManager.points.size(); i++){
			Point currPoint = pointManager.points.get(i);
			if(currPoint.y > player.y-25 && currPoint.y < player.y+Assets.player.getHeight()-25){
				if(player.health > 700)
					g.drawPixel(currPoint.x, currPoint.y, Color.GREEN);
				else if(player.health > 300)
					g.drawPixel(currPoint.x, currPoint.y, Color.YELLOW);
				else if(player.health > 0)
					g.drawPixel(currPoint.x, currPoint.y, Color.RED);
			}
			else
				g.drawPixel(currPoint.x, currPoint.y, Color.CYAN);
		}
		
		Pixmap playerPixmap = Assets.player;
		int x = player.x;
		int y = player.y;
		g.drawPixmap(playerPixmap, x, y);
		
		g.drawText("Level: " + (pointManager.speedIndex+1), 325, 1200, Color.WHITE);
		g.drawText("Health: " + player.health, 325, 1250, Color.WHITE);
		g.drawText("Score: " + pointManager.totalPixels, 325, 50, Color.WHITE);
		
	}
	
	private int calcRadius(int x, int fourHundred){
		double radius = (1.0/5)*(x + fourHundred) + 180.5;
		int newRadius = (int)Math.floor(radius);
			
		return newRadius;
	}
	
	private void drawReadyUI(){
		Graphics g = game.getGraphics();
		
		
	}
	
	private void drawRunningUI(){
		Graphics g = game.getGraphics();
		
		
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

