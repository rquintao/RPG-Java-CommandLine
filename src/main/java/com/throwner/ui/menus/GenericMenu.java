package com.throwner.ui.menus;

import java.util.ArrayList;
import java.util.List;

import com.throwner.exceptions.InputGenericException;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.framework.ContextsMap;
import com.throwner.utils.input.InputUtils;
import com.throwner.utils.output.OutputUtils;

public class GenericMenu<T> {
	
	OutputUtils sw;
	InputUtils in;
	
	public GenericMenu(){
		sw = ContextsMap.getBean(OutputUtils.class);
		in = ContextsMap.getBean(InputUtils.class);
	}

	
	
	public void printAllOptions (List<String> arr) {
		for (String option : arr) {
			  sw.write(option);
			}
	}
	
	public List<String> convertToArrayList(T[] arr){
	    List<String> enumValues = new ArrayList<String>() ;
	    
	    for(T e: arr){
	    	enumValues.add(e.toString());
	    }
	    
	    return enumValues;
	}
	
	public String getResponseFromInput(T[] arr) throws InputNotInOptionsException, InputGenericException{

	    int choice = in.getIntValue();
	    
	    if(choice <= arr.length && choice > 0){
	    	return arr[choice - 1].toString();
	    } else {
	    	throw new InputNotInOptionsException("Input not in options");
	    }
	}
	
	public char getCharResponseFromInput(T[] arr) throws InputNotInOptionsException, InputGenericException{

	    char choice = in.getCharValue();
	    
	    List<String> options = new ArrayList<String>();
	    
	    for(T var: arr){
	    	String aux = String.valueOf(var.toString().charAt(0));
	    	options.add(aux);
	    }
	    
	    String charac= String.valueOf(choice);
	    
	    if(options.contains(charac)){
	    	int i = options.indexOf(charac);
	    	return options.get(i).charAt(0);
	    } else {
	    	throw new InputNotInOptionsException("Not in options");
	    }
	    
	    
	}
	
	
	public String getStringResponseFromInput() throws InputGenericException{

	    String stuff = in.getStringValue();
	    
	    return stuff;
	}
	
	public void showMessage(String msg){
		sw.write(msg);
		sw.write(" ");
	}

}
