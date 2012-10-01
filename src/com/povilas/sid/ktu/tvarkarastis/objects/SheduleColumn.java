package com.povilas.sid.ktu.tvarkarastis.objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	public void add(String subject, String location, Date date, String color){
		this.subject.add(subject);
		this.location.add(location);
		this.time.add(df.format(date));
		this.color.add(color);
	}
	
	public String getSubject(int i){
		return subject.get(i);
	}
	
	public String getLocation(int i){
		return location.get(i);
	}
	
	public String getTime(int i){
		return time.get(i);
	}
	
	public String getColor(int i){
		return color.get(i);
	}
}
