package com.povilas.sid.ktu.tvarkarastis.objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Shedule {
	SimpleDateFormat df = new SimpleDateFormat("HH:mm");
	
	private ArrayList<SheduleColumn> she;
	private byte weekDay;
	
	
	public Shedule() {
		this.she = new ArrayList<SheduleColumn>(); 
		this.weekDay = 0;
	}
	
	public void add(SheduleColumn shec){
		this.she.add(shec);
	}
	
	public void formShedule(Week week, Modules modules, Types types){
		if(!week.equals(null)){
			this.weekDay = week.getWeekDay();
			for (int i = 0; i < week.size(); i++) {
				SheduleColumn shec = new SheduleColumn();
				for (int j = 0; j < week.getDays(i).size(); j++) {// TODO use foreach
					if((week.getDays(i).getGroup(j).equals("-1") || week.getDays(i).getGroup(j).equals("A13")) && // TODO User prefs 
							(week.getDays(i).getAlternation(j) == 0 || week.getDays(i).getAlternation(j).equals(week.getAlternation()) )){ 
						shec.add(modules.getTitle(week.getDays(i).getCode(j)),
								week.getDays(i).getLocation(j),
								week.getDays(i).getTime(j),
								types.getColor(week.getDays(i).getType(j)));
					}
				}
				if(shec.size() > 0){ she.add(shec);}
			}
		}
	}

	public SheduleColumn getShe(int i) {
		return she.get(i);
	}
	
	public int size(){
		return she.size();
	}
	
	public byte getWeekDay(){
		return this.weekDay;
	}
	

}
