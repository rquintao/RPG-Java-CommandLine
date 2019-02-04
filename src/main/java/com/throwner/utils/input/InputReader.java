package com.throwner.utils.input;

import java.util.Scanner;

import com.throwner.exceptions.InputGenericException;

public class InputReader {
	
	Scanner scanner;
	
	public InputReader(Scanner scanner){
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
}
