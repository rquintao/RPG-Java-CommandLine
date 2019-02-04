package com.throwner.utils.output;

import java.io.PrintStream;

public class StringWriter {
	
	 private final PrintStream out;
	 
	 public StringWriter (PrintStream out){
		 this.out = out;
	 }
	
	public void write(String msg){
		if (msg!=null){
			out.println(msg);
		}
	}
}
