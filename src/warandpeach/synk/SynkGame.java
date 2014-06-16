package warandpeach.synk;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.AndroidGame;

public class SynkGame extends AndroidGame{

	public Screen getStartScreen(){
		return new LoadingScreen(this);
	}
}
