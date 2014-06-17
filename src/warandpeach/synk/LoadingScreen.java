package warandpeach.synk;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;
import com.badlogic.androidgames.framework.Screen;

public class LoadingScreen extends Screen{
	public LoadingScreen(Game game){
		super(game);
	}

	public void update(float deltaTime){
		Graphics g = game.getGraphics();
		game.getGraphics();
		
		Assets.mainMenu = g.newPixmap("SYNKMainMenu.png", PixmapFormat.ARGB4444);
		Assets.background = g.newPixmap("SYNKBackground.png", PixmapFormat.ARGB4444);
		
		Assets.player = g.newPixmap("Player.png", PixmapFormat.ARGB4444);
		
		Settings.load(game.getFileIO());
		game.setScreen(new MainMenuScreen(game));;
	}
	
	public void present(float deltaTime){
		
	}
	
	public void pause(){
		
	}
	
	public void resume(){
		
	}
	
	public void dispose(){
		
	}
}
