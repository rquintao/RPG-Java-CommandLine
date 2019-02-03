package com.throwner.utils.input;

import java.util.Scanner;

public class InputReader {
	
	Scanner scanner;
	
	public InputReader(Scanner scanner){
		this.scanner=scanner;
	}
	
	public int getIntValue(){
		int selection = scanner.nextInt();
		scanner.nextLine();
		return selection;	
	}
}
