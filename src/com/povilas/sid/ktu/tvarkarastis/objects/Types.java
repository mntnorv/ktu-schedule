package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.HashMap;
import java.util.Map;


public class Types {
	private Map<Character, String[]> map;
	
	public Types(){
		this.map = new HashMap<Character, String[]>();
	}
	
	public void add(Character key, String name, String colorCode){
		this.map.put(key, new String[]{name, colorCode});
	}
	
	public String getTitle(Character key){
		return map.get(key)[0];
	}
	public String getColor(Character key){
		return map.get(key)[1];
	}

}
