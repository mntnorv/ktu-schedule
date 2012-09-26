package com.povilas.sid.ktu.tvarkarastis.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.povilas.sid.ktu.tvarkarastis.objects.Shedule;

public class XmlParser {
	private static SAXParser parser = null;
	private static XmlHandler handler = null;
	private static XmlHandlerDate dateHandler = null;
	private static XmlHandlerShedule sheduleHandler = null;

	/**
	 * Returns the parsed XmlElement object
	 * 
	 * @param uri
	 *            Uri of XML document
	 * @return XmlElement parsed XmlElement object
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static XmlElement parse(String uri) throws ParserConfigurationException,
			SAXException, IOException {
		if (parser == null) {
			parser = SAXParserFactory.newInstance().newSAXParser();
		}
		if (handler == null) {
			handler = new XmlHandler();
		}
		
		InputSource source = new InputSource(uri);
		//source.setEncoding("ISO-8859-1");
		source.setEncoding("UTF-8");
		
		parser.parse(source, handler);
		return handler.getOutput();
	}
	
	public static String parseDate(String uri) throws ParserConfigurationException,
			SAXException, IOException {
		if (parser == null) {
			parser = SAXParserFactory.newInstance().newSAXParser();
		}
		if (dateHandler == null) {
			dateHandler = new XmlHandlerDate();
		}
		
		InputSource source = new InputSource(uri);
		//source.setEncoding("ISO-8859-1");
		source.setEncoding("UTF-8");
		
		parser.parse(source, dateHandler);
		return dateHandler.getDate();
	}
	
	public static XmlElement parse(InputStream uri) throws ParserConfigurationException,
	SAXException, IOException {
		
		if (parser == null) {
			parser = SAXParserFactory.newInstance().newSAXParser();
		}
		if (handler == null) {
			handler = new XmlHandler();
		}

		InputSource source = new InputSource(uri);
		//source.setEncoding("ISO-8859-1");
		source.setEncoding("UTF-8");

		parser.parse(source, handler);
		return handler.getOutput();
	}
	
	public static String parseDate(InputStream uri) throws ParserConfigurationException,
			SAXException, IOException {
			if (parser == null) {
				parser = SAXParserFactory.newInstance().newSAXParser();
			}
			if (dateHandler == null) {
				dateHandler = new XmlHandlerDate();
			}
			
			InputSource source = new InputSource(uri);
			//source.setEncoding("ISO-8859-1");
			source.setEncoding("UTF-8");
			
			parser.parse(source, dateHandler);
			return dateHandler.getDate();
		}
	
	public static Shedule parseShedule(InputStream uri) throws ParserConfigurationException,
		SAXException, IOException {
		if (parser == null) {
			parser = SAXParserFactory.newInstance().newSAXParser();
		}
		if (sheduleHandler == null) {
			sheduleHandler = new XmlHandlerShedule();
		}
		
		InputSource source = new InputSource(uri);
		//source.setEncoding("ISO-8859-1");
		source.setEncoding("UTF-8");
		
		parser.parse(source, sheduleHandler);
		return sheduleHandler.getShedule();
	}
}
