import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class SaxParser extends DefaultHandler {
	List<Libro> books;

	private String tmp;
	private Libro currentBook;
	private int nErrors, nWarnings, nFatals;
	private boolean inDocenti, printChars;

	public SaxParser() {
		books = new ArrayList<Libro>();
		reset();
	}

	// Gestione degli errori

	public void reset() {
		nErrors = 0;
		nWarnings = 0;
		nFatals = 0;
		inDocenti = false;
		printChars = false;
	}

	public void warning(SAXParseException e) throws SAXException {
		nWarnings++;
		printException("WARNING", e);
	}

	public void fatalError(SAXParseException e) throws SAXException {
		nFatals++;
		printException("FATAL ERROR", e);
		throw e;
	}

	public void error(SAXParseException e) throws SAXException {
		nErrors++;
		printException("ERROR", e);
	}

	private void printException(String type, SAXParseException e) throws SAXException {
		System.out.println(type + " (" + e.getSystemId() + ":" + e.getLineNumber() + "," + e.getColumnNumber() + ") "
				+ e.getMessage());
	}

	public boolean hadProblems() {
		return (nFatals + nErrors) > 0;
	}

	public void parseDocument(String path) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setValidating(true);

		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(path, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printBooks() {
		System.out.println("Number of Books '" + books.size() + "'.");
		for (Libro i : books) {
			System.out.println(i.toString());
		}
	}

	// Callbacks

	// Evento di apertura del tag nel file XML
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// Reset delle variabili temporanee usate per la lettura
		tmp = "";
		if (qName.equalsIgnoreCase("libro")) {
			currentBook = new Libro();
			currentBook.setTitolo(attributes.getValue("titolo"));
			currentBook.setAutore(attributes.getValue("autore"));
			currentBook.setEditore(attributes.getValue("editore"));
			currentBook.setCapitolo(new ArrayList<String>());
		} else if (qName.equalsIgnoreCase("prefazione")) {
			currentBook.setAutorePrefazione(attributes.getValue("autore"));
		} else if (qName.equalsIgnoreCase("indice")) {
			currentBook.setIndice(new ArrayList<String>());
		} else if (qName.equalsIgnoreCase("titolo")) {

		} else if (qName.equalsIgnoreCase("capitolo")) {

		}
	}

	// Evento PCDATA nel file XML
	public void characters(char[] ch, int start, int length) throws SAXException {
		tmp = new String(ch, start, length);
	}

	// Evento chiusura tag nel file XML
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("libro")) {
			books.add(currentBook);
		} else if (qName.equalsIgnoreCase("prefazione")) {
			currentBook.setPrefazione(tmp);
		} else if (qName.equalsIgnoreCase("titolo")) {
			currentBook.getIndice().add(tmp);
		} else if (qName.equalsIgnoreCase("indice")) {

		} else if (qName.equalsIgnoreCase("capitolo")) {
			currentBook.addCapitolo(tmp);
		}
	}

}