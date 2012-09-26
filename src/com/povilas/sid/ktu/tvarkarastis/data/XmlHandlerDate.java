package com.povilas.sid.ktu.tvarkarastis.data;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


class XmlHandlerDate extends DefaultHandler {
	private String date;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Returns the output of the parsing
	 * 
	 * @return
	 */
	public String getDate() {
		return date;
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		// initialize all the fields
		date = null;
	}

	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		if(localName.equals("schedule")){
			date = attributes.getValue("semesterStart");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
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
