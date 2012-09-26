package com.povilas.sid.ktu.tvarkarastis.objects;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SheduleColumn {
	SimpleDateFormat df = new SimpleDateFormat("HH:mm");
	
	ArrayList<String> subject;
	ArrayList<String> location;
	ArrayList<String> time;
	ArrayList<String> color;
	
	public SheduleColumn() {
		this.subject = new ArrayList<String>();
		this.location = new ArrayList<String>();
		this.time = new ArrayList<String>();
		this.color = new ArrayList<String>();
	}
	
	public void add(String subject, String location, String string, String color){
		this.subject.add(subject);
		this.location.add(location);
		this.time.add(df.format(string));
		this.color.add(color);
	}
}
