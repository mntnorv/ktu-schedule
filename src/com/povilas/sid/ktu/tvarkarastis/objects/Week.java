package com.povilas.sid.ktu.tvarkarastis.objects;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Week {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private ArrayList<Day> days;
	private Boolean evenWeek;
	
	public Week(){
		this.days = new ArrayList<Day>();
		this.evenWeek = true;
	}

	public Day getDays(int i) {
		return days.get(i);
	}

	public void addDay(Day day) {
		this.days.add(day);
	}

	public Boolean getEvenWeek() {
		return evenWeek;
	}

	public void setEvenWeek(String date) throws ParseException {
		Date startDate = (Date) dateFormat.parse(date);
		Date endDate = new Date(0);
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffWeeks = diffTime / (1000 * 60 * 60 * 24 * 7);

		this.evenWeek = ((diffWeeks % 2) == 0);
	}
	
	public int size(){
		return days.size();
	}
}
