package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.ArrayList;

public class Groups {
	ArrayList<String> code;
	ArrayList<String> title;
	ArrayList<SubGroups> sub;
	
	public Groups() {
		this.code = new ArrayList<String>();
		this.title = new ArrayList<String>();
		this.sub = new ArrayList<SubGroups>();
	}
	
	public void addGroupCredentials(String title, String code){
		this.title.add(title);
		this.code.add(code);
	}
	
	public void addSubGroups(SubGroups sub){
		this.sub.add(sub);
	}

	public String getCode(int i) {
		return code.get(i);
	}

	public String getTitle(int i) {
		return title.get(i);
	}

	public SubGroups getSub(int i) {
		return sub.get(i);
	}
	
	

}