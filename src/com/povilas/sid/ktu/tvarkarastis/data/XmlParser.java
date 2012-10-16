package com.povilas.sid.ktu.tvarkarastis.data;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.povilas.sid.ktu.tvarkarastis.objects.Shedule;

public class XmlParser {
	private static SAXParser parser = null;
	private static XmlHandlerShedule sheduleHandler = null;

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
