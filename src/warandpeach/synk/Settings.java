package warandpeach.synk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.badlogic.androidgames.framework.FileIO;

public class Settings {
	public static void load(FileIO files){
		BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(files.readFile(".synk")));
			
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
			out = new BufferedWriter(new OutputStreamWriter(files.writeFile(".synk")));
		}catch(IOException e){
			
		}finally{
			try{
				if(out != null)
					out.close();
			}catch(IOException e){
				
			}
		}
	}
}
