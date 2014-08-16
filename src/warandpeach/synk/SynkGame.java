package warandpeach.synk;

import android.util.Log;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.AndroidGame;

public class SynkGame extends AndroidGame{

	public Screen getStartScreen(){
		Log.d("Here", "Here");
		return new LoadingScreen(this);
	}
}
