package com.povilas.sid.ktu.tvarkarastis.objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Shedule {
	SimpleDateFormat df = new SimpleDateFormat("HH:mm");
	
	ArrayList<SheduleColumn> she;
	
	public Shedule() {
		this.she = new ArrayList<SheduleColumn>(); 
	}
	
	public void add(SheduleColumn shec){
		this.she.add(shec);
	}
	
	public void formShedule(Week week, Modules modules, Types types){
		for (int i = 0; i < week.size(); i++) {
			SheduleColumn shec = new SheduleColumn();
			for (int j = 0; j < week.getDays(i).size(); j++) {
				if(!week.getDays(i).getGroup(j).isEmpty() && week.getDays(i).getGroup(j).equals("A13")){ //User prefs 
					shec.add(modules.getTitle(week.getDays(i).getCode(j)),
							week.getDays(i).getLocation(j),
							df.format(week.getDays(i).getTime(j)),
							types.getColor(week.getDays(i).getType(j)));
				}
			}
		}
	}

	public SheduleColumn getShe(int i) {
		return she.get(i);
	}
	
	public int size(){
		return she.size();
	}
	

}
