package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.ArrayList;

public class SubGroups {
	ArrayList<String> title;
	ArrayList<String> code;
	
	public SubGroups() {
		this.title = new ArrayList<String>();
		this.code = new ArrayList<String>();
	}
	
	public void add(String title, String code){
		this.title.add(title);
		this.code.add(code);
	}

	public String getTitle(int i) {
		return title.get(i);
	}

	public String getCode(int i) {
		return code.get(i);
	}
	
	public int size(){
		return title.size();
	}
	
	

}
