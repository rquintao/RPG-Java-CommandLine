package com.throwner.ui.menus;

import java.util.ArrayList;
import java.util.List;

import com.throwner.exceptions.InputGenericException;
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
	
	public String getResponseFromInput(T[] arr) throws InputGenericException{

	    int choice = in.getIntValue();
	    
	    if(choice <= arr.length && choice > 0){
	    	return arr[choice - 1].toString();
	    } else {
	    	throw new InputGenericException("Error in input");
	    }
	}
	
	public String getStringResponseFromInput() throws InputGenericException{

	    String stuff = in.getStringValue();
	    
	    return stuff;
	}
	
	protected void showMessage(String msg){
		sw.write(msg);
		sw.write(" ");
	}

}
