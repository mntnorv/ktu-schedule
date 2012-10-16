package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Week {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private ArrayList<Day> days;
	private byte alternation;
	private byte weekDay;
	
	public Week(){
		this.days = new ArrayList<Day>();
		this.alternation = 0;
		this.weekDay = 0;
	}

	public Day getDays(int i) {
		return days.get(i);
	}

	public void addDay(Day day) {
		this.days.add(day);
	}

	public byte getAlternation() {
		return alternation;
	}
	
	public byte getWeekDay() {
		return weekDay;
	}

	public void setAditionalWeekInformation(String date) throws ParseException {
		Date startDate = dateFormat.parse(date);
		Date endDate = new Date();
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diff = diffTime / (1000 * 60 * 60 * 24 * 7);
		
		byte tempAtlernation = (byte) (diff % 2);
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(endDate);  
        this.weekDay = (byte) calendar.get(Calendar.DAY_OF_WEEK);
        
		if(this.weekDay  > size()){
			this.alternation = (byte) ((tempAtlernation == 2)? 1:2);
		}else{
			this.alternation = tempAtlernation;
		}
	}
	
	public int size(){
		return days.size();
	}
}
