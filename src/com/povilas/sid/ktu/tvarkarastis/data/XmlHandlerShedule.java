package com.povilas.sid.ktu.tvarkarastis.data;


import java.text.ParseException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.povilas.sid.ktu.tvarkarastis.objects.*;

public class XmlHandlerShedule extends DefaultHandler{
	private Week week;
	private Groups groups;
	private Modules modules;
	private Types types;
	
	//The main object
	private Shedule shedule;
	
	//Helper varibales
	private Boolean inGroup;
	private Boolean inDay;
	
	private SubGroups tempSub; 
	private Day tempDay;


	public Shedule getShedule() {
		return shedule;
	}


	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		// initializing all the fields
		week = new Week();
		groups = new Groups();
		modules = new Modules();
		types = new Types();
		
		shedule = new Shedule();
		
		inGroup = false;
		inDay = false;
	}

	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		if(localName.equals("type")){
			//date = attributes.getValue("semesterStart");
			types.add(attributes.getValue("code").charAt(0), attributes.getValue("name"), attributes.getValue("color"));
		}else if (localName.equals("module")) {
			modules.add(attributes.getValue("name"), attributes.getValue("code"));
		}else if (localName.equals("groupContainer") && !inGroup) {
			tempSub = new SubGroups();
			inGroup = true;
			groups.addGroupCredentials(attributes.getValue("name"), attributes.getValue("appliesTo"));
		}else if(localName.equals("group")){
			tempSub.add(attributes.getValue("name"), attributes.getValue("code"));
		}else if (localName.equals("schedule")) {
			try {
				week.setEvenWeek(attributes.getValue("semesterStart"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}else if(localName.equals("weekday") && !inDay){
			tempDay =  new Day();
			inDay = true;
		}else if(localName.equals("class")){
			try {
				String group = (attributes.getIndex("group") == -1)? "-1": attributes.getValue("group");
				
				Byte alternation = 0;
				String time = attributes.getValue("time");
				if(time == null) {
					alternation = 0;
				} else if (time.equals("1")) {
					alternation = 1;
				} else if (time.equals("2")) {
					alternation = 2;
				}
				
				tempDay.add(attributes.getValue("code"), attributes.getValue("location"), attributes.getValue("time"), attributes.getValue("type").charAt(0), alternation, group);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if (localName.equals("groupContainer") && inGroup) {
			inGroup = false;
			groups.addSubGroups(tempSub);
		}if(localName.equals("weekday") && inDay){
			inDay = false;
			week.addDay(tempDay);
			
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		shedule.formShedule(week, modules, types);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		super.error(e);
	}
	
	@SuppressWarnings("unused")
	private void print(String text) {
		//System.out.println(text);
		//Log.d("test", text);
	}

}
