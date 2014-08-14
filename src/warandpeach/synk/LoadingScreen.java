package warandpeach.synk;

import android.util.Log;

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
		
		Assets.mainMenu = g.newPixmap("SYNKTitle.png", PixmapFormat.ARGB4444);
		Assets.background = g.newPixmap("SYNKBackground.png", PixmapFormat.ARGB4444);
		Assets.highScore = g.newPixmap("HighScore.png", PixmapFormat.ARGB4444);
		
		Assets.player = g.newPixmap("Player1.png", PixmapFormat.ARGB4444);
		Assets.player2 = g.newPixmap("Player2.png", PixmapFormat.ARGB4444);
		Assets.player3 = g.newPixmap("Player3.png", PixmapFormat.ARGB4444);
		Assets.player4 = g.newPixmap("Player4.png", PixmapFormat.ARGB4444);
		Assets.player5 = g.newPixmap("Player5.png", PixmapFormat.ARGB4444);
		
		Assets.shadeDoge = g.newPixmap("smallDogeShades.jpg", PixmapFormat.ARGB4444);
		Assets.zackFace = g.newPixmap("zackFace.jpg", PixmapFormat.ARGB4444);
		
		Settings.load(game.getFileIO());
		for(int i = 0; i < Settings.highScores.length; i++){
			Log.d("LoadHighScore", Settings.highScores[i]+"");
		}
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
