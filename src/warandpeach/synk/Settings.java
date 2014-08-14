package warandpeach.synk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.badlogic.androidgames.framework.FileIO;

public class Settings {
	public static int[] highScores = new int[] { 10000, 8000, 5000, 3000 ,1000 };
	
	public static void load(FileIO files){
		BufferedReader in = null;
		try{
			//checkScores();
			in = new BufferedReader(new InputStreamReader(files.readFile(".synk")));
			highScores[0]= Integer.parseInt(in.readLine());
			highScores[1]= Integer.parseInt(in.readLine());
			highScores[2]= Integer.parseInt(in.readLine());
			highScores[3]= Integer.parseInt(in.readLine());
			highScores[4]= Integer.parseInt(in.readLine());
		}catch(Exception e){
			
		}finally{
			try{
				if (in !=null)
					in.close();
			}catch(IOException e){
				
			}
		}
	}
	
	public static void save(FileIO files){
		BufferedWriter out = null;
		try {
			//checkScores();
			out = new BufferedWriter(new OutputStreamWriter(files.writeFile(".synk")));
			out.write(Integer.toString(highScores[0]));
			out.write(Integer.toString(highScores[1]));
			out.write(Integer.toString(highScores[2]));
			out.write(Integer.toString(highScores[3]));
			out.write(Integer.toString(highScores[4]));
		}catch(IOException e){
			
		}finally{
			try{
				if(out != null)
					out.close();
			}catch(IOException e){
				
			}
		}
	}
	public static void checkScores(){
		for(int i = 0; i < Settings.highScores.length; i++){
			if(highScores[i] > 1000000){
				highScores[i] = 0;
			}
		}
	}
}
