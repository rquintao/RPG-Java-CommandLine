package com.throwner.ui.menus;

import java.util.ArrayList;
import java.util.List;

import com.throwner.framework.ContextsMap;
import com.throwner.utils.output.StringWriter;

public class GenericMenu<T> {
	
	StringWriter sw = null;
	
	public GenericMenu(){
		sw = ContextsMap.getBean(StringWriter.class);
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

}
