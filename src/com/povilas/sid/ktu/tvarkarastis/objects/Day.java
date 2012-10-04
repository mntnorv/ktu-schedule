package com.povilas.sid.ktu.tvarkarastis.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Day {
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	
	private ArrayList<String> code;
	private ArrayList<String> location;
	private ArrayList<Date> time;
	private ArrayList<Character> type;
	private ArrayList<Byte> alternation;
	private ArrayList<String> group;
	
    public Day(){
    	this.code = new ArrayList<String>();
    	this.location = new ArrayList<String>();
    	this.time =  new ArrayList<Date>();
    	this.type = new ArrayList<Character>();
    	this.alternation = new ArrayList<Byte>();
    	this.group = new ArrayList<String>();
    	
    }
    public void add(String code, String location, String time, Character type, Byte alternation, String group) throws ParseException{
    	this.code.add(code);
    	this.location.add(location);
    	this.time.add((Date) timeFormat.parseObject(time));
    	this.type.add(type);
    	this.alternation.add(alternation);
    	this.group.add(group);
    }

	public String getCode(int i) {
		return code.get(i);
	}
	public String getLocation(int i) {
		return location.get(i);
	}
	public Date getTime(int i) {
		return time.get(i);
	}
	public Character getType(int i) {
		return type.get(i);
	}
	
    public Byte getAlternation(int i) {
		return alternation.get(i);
	}
    
    public String getGroup(int i) {
		return group.get(i);
	}
	
	public int size() {
		return code.size();
	}

}
