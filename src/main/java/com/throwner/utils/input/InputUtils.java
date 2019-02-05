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
		String selection = String.valueOf(scanner.next(".").charAt(0));
		
		if (selection.chars().allMatch( Character::isDigit )){
			return Integer.valueOf(selection);
		} else throw new InputGenericException("Not a numeric value");
	}
	
	public String getStringValue() throws InputGenericException{
		scanner.nextLine();
		String selection = scanner.nextLine();
		
		if (selection != null){
			return selection;
		} else throw new InputGenericException("Not a numeric value");
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
