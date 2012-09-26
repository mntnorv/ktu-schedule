package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.HashMap;
import java.util.Map;

public class Modules {
	private Map<String, String> map;
	
	public Modules(){
		this.map = new HashMap<String, String>();		
	}

	public void add(String value, String key){
		this.map.put(key, value);
	}
	
	public String getTitle(String code){
		return map.get(code).toString();		
	}
}
