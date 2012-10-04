package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Week {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private ArrayList<Day> days;
	private int alternation;
	
	public Week(){
		this.days = new ArrayList<Day>();
		this.alternation = 0;
	}

	public Day getDays(int i) {
		return days.get(i);
	}

	public void addDay(Day day) {
		this.days.add(day);
	}

	public int getAlternation() {
		return alternation;
	}

	public void setEvenWeek(String date) throws ParseException {
		Date startDate = dateFormat.parse(date);
		Date endDate = new Date();
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffWeeks = diffTime / (1000 * 60 * 60 * 24 * 7);

		this.alternation = (int) (diffWeeks % 2);
	}
	
	public int size(){
		return days.size();
	}
}
