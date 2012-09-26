package com.povilas.sid.ktu.tvarkarastis;

//import java.util.ArrayList;
//
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//
//public class XMLHandler extends DefaultHandler{
//	
//	Boolean currentElement = false;
//	String currentValue = null;
//	public static ArrayList<Day> week = new ArrayList<Day>();
//	
//	public static ArrayList<Day> getDay() {
//		return week;
//	}
//
//	public static void setWeek(ArrayList<Day> week) {
//		XMLHandler.week = week;
//	}
//
//	public void startElement(String uri, String localName, String qName,
//			Attributes attributes) throws SAXException {
//
//		currentElement = true;
//
//		if (localName.equals("weekday"))
//		{
//			/** Start */ 
//			week.add(null);
//		} else if (localName.equals("class")) {
//			/** Get attribute value */
//			String code = attributes.getValue("code");
//			String location = attributes.getValue("location");
//			String time = attributes.getValue("time");
//			String type = attributes.getValue("type");
//			week.get(week.size() - 1).Day(code, location, time, type);			
//		}
//
//	}
//	
//	/** Called when tag closing ( ex:- <name>AndroidPeople</name> 
//	 * -- </name> )*/
//	@Override
//	public void endElement(String uri, String localName, String qName)
//			throws SAXException {
//
//		currentElement = false;
//
//	}
//
//	/** Called to get tag characters ( ex:- <name>AndroidPeople</name> 
//	 * -- to get AndroidPeople Character ) */
//	@Override
//	public void characters(char[] ch, int start, int length)
//			throws SAXException {
//
//		if (currentElement) {
//			currentValue = new String(ch, start, length);
//			currentElement = false;
//		}
//
//	}
//}
