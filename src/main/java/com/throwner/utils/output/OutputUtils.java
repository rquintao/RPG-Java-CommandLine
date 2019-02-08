package com.throwner.utils.output;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.engine.core.Game;

public class OutputUtils {
	
	 private final PrintStream out;
	 private static final Logger LOG = LogManager.getLogger(OutputUtils.class);
	 
	 public OutputUtils (PrintStream out){
		 this.out = out;
	 }
	
	public void write(String msg){
		if (msg!=null){
			out.println(msg);
		}
	}
		
	public void saveState(Game game){
		LOG.traceEntry();
		try
		{
		   FileOutputStream myFileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/game.ser");
		   ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myFileOutputStream);
		   myObjectOutputStream.writeObject(game);
		   myObjectOutputStream.close();
		}
		catch (Exception e)
		{
			LOG.error("Threw a Exception in OutputUtils::saveState, full stack trace follows:", e);
		}
	}
	
}
