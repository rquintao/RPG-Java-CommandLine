package com.throwner.utils.input;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.throwner.engine.core.Game;
import com.throwner.exceptions.InputGenericException;

public class InputUtils {
	
	Scanner scanner;
	
	public InputUtils(Scanner scanner){
		this.scanner=scanner;
	}
	
	public int getIntValue() throws InputGenericException{
		try{
		String selection = String.valueOf(scanner.next(".").charAt(0));
		scanner.nextLine();
		
		if (selection.chars().allMatch( Character::isDigit )){
			return Integer.valueOf(selection);
		} else throw new InputGenericException("Not a numeric value");
		}
		catch(Exception e){
			scanner.nextLine();
			throw new InputGenericException("Not a numeric value");
		}
	}
	
	public String getStringValue() throws InputGenericException{
		scanner.nextLine();
		String selection = scanner.nextLine();
		
		if (selection != null){
			return selection;
		} else {
			scanner.nextLine();
			throw new InputGenericException("Not a numeric value");
		}
	}
	
	public char getCharValue() throws InputGenericException{
		scanner.nextLine();
		char ch = scanner.findInLine(".").charAt(0);
		
		if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n')
			throw new InputGenericException("Not a numeric value");
		return Character.toUpperCase(ch);
	}
	
	public Game loadState(){
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
			e.printStackTrace();
		    //Log.e("Error when loading from file.",Log.getStackTraceString(e));
		}
		return null;
		
	}
}
