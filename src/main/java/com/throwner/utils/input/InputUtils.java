package com.throwner.utils.input;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.engine.core.Game;
import com.throwner.exceptions.InputGenericException;

public class InputUtils {
	
	Scanner scanner;
	private static final Logger LOG = LogManager.getLogger(InputUtils.class);
	
	public InputUtils(Scanner scanner){
		this.scanner=scanner;
	}
	
	public int getIntValue() throws InputGenericException{
		LOG.traceEntry();
		try{
		String selection = String.valueOf(scanner.next(".").charAt(0));
		scanner.nextLine();
		
		if (selection.chars().allMatch( Character::isDigit )){
			return Integer.valueOf(selection);
		} else throw new InputGenericException("Not a numeric value");
		}
		catch(Exception e){
			LOG.error("Threw a Exception in InputUtils::getIntValue, full stack trace follows:", e);
			scanner.nextLine();
			throw new InputGenericException("Not a numeric value");
		}
	}
	
	public String getStringValue() throws InputGenericException{
		//scanner.nextLine();
		LOG.traceEntry();
		String selection = scanner.nextLine();
		
		if (selection != null){
			return selection;
		} else {
			//scanner.nextLine();
			throw new InputGenericException("Not a numeric value");
		}
	}
	
	public char getCharValue() throws InputGenericException{
		LOG.traceEntry();
		scanner.nextLine();
		char ch = scanner.findInLine(".").charAt(0);
		
		if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n')
			throw new InputGenericException("Not a numeric value");
		return Character.toUpperCase(ch);
	}
	
	public Game loadState(){
		LOG.traceEntry();
		try
		{
		    FileInputStream myFileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\game.ser");
		    ObjectInputStream myObjectInputStream = new ObjectInputStream(myFileInputStream);
		    Game loadGame = (Game) myObjectInputStream.readObject(); 
		    myObjectInputStream.close();
		    return loadGame;
		}
		catch (Exception e)
		{
			LOG.error("Threw a Exception in InputUtils::loadState, full stack trace follows:", e);
		}
		return null;
		
	}
}
