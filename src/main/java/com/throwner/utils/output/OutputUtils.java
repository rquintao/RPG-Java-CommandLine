package com.throwner.utils.output;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import com.throwner.engine.core.Game;

public class OutputUtils {
	
	 private final PrintStream out;
	 
	 public OutputUtils (PrintStream out){
		 this.out = out;
	 }
	
	public void write(String msg){
		if (msg!=null){
			out.println(msg);
		}
	}
		
	public void saveState(Game game){
		try
		{
		   FileOutputStream myFileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/game.ser");
		   ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myFileOutputStream);
		   myObjectOutputStream.writeObject(game);
		   myObjectOutputStream.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		   // Log.e("Error when saving to file.",Log.getStackTraceString(e)); 
		}
	}
	
}
