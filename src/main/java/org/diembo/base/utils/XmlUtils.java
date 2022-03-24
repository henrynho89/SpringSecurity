package org.diembo.base.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Facilitates writing of XML documents. 'startDocument' allows starting a
 * document while 'endDocument' allows ending it. With the same token,
 * 'startElement' and 'endElement' allows starting and ending an element.
 * Documents and elements may have attributes and data; hence the function of
 * 'addData', 'addAttr' and 'addAttrs'.
 * 
 * The class has four constructors allowing to specify:
 * <ul>
 * <li>whether the output will be a {@link File} or {@link Writer}
 * <li>whether the output will be a formatted (default) or not
 * </ul>
 * 
 * @since 1.0
 * 
 */

@SuppressWarnings("restriction")
public class XmlUtils {
	
	/**
	 * Instantiates an XmlUtils based on a file name.
	 * 
	 * @param filename The name of the output file.
	 */
	public XmlUtils ( String filename ) {
		logger.debug("Enter XmlUtils(" + filename + ")");

		// open the output file
		try {
			writer = new BufferedWriter ( new OutputStreamWriter(new FileOutputStream(filename), "UTF-8") ) ;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage()) ;
		}

		logger.debug("Leave XmlUtils()");
	}

	/**
	 * Instantiates an XmlUtils based on a Writer.
	 * 
	 * @param writer that will be used to write the XML documents.
	 */
	public XmlUtils ( Writer writer ) {
		logger.debug("Enter XmlUtils(" + writer + ")");

		this.writer = writer ;

		logger.debug("Leave XmlUtils()");
	}

	/**
	 * Instantiates an XmlUtils based on a file name and setting the formatting flag.
	 * 
	 * @param filename The name of the output file.
	 */
	public XmlUtils ( String filename , boolean formatting ) {
		logger.debug("Enter XmlUtils(" + filename + "," + formatting + ")");

		// set formatting flag
		this.formatting = formatting ;

		// open the output file
		try {
			writer = new BufferedWriter ( new OutputStreamWriter (new FileOutputStream ( filename ) , "UTF-8") ) ;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage()) ;
		}

		logger.debug("Leave XmlUtils()");
	}

	/**
	 * Instantiates an XmlUtils based on a Writer and setting the formatting flag.
	 * 
	 * @param writer that will be used to write the XML documents.
	 */
	public XmlUtils ( Writer writer , boolean formatting ) {
		logger.debug("Enter XmlUtils(" + writer + "," + formatting + ")");

		// set formatting flag
		this.formatting = formatting ;

		this.writer = writer ;

		logger.debug("Leave XmlUtils()");
	}

	/**
	 * Starts an XML document. Data and attributes may be added to the document
	 * using 'addData()', 'addAttr()' and 'addAttrs()'.
	 * 
	 * @param name of the XML document.
	 */
	public void startDocument ( String name ) {
		logger.debug("Enter startDocument(" + name + ")");

		startDocument ( name , null , null ) ;

		logger.debug("Leave startDocument()");
	}

	/**
	 * Starts an XML document with its attributes and data.
	 * 
	 * @param name of the XML document.
	 * @param attrs of the XML document.
	 * @param data of the XML document.
	 */
	public void startDocument ( String name , Map<String,String> attrs , String data ) {
		logger.debug("Enter startDocument(" + name + ", " + attrs + ", " + data + ")");

		// save the name of the root element for use when ending the document.
		root = name ;

		// check and change the document state
		checkDocumentState ( READY , STARTED ) ;

		// XML prolog
		if ( addXmlProlog ) {
			write ("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
			if ( formatting )
				write ( "\n\n" ) ;
		}

		// start the root element
		startElement ( name , attrs , data ) ;

		logger.debug("Leave startDocument()");
	}

	/**
	 * Ends an XML document. A document, once it is ended, it can't be changed
	 * anymore.
	 */
	public void endDocument ( ) {
		logger.debug("Enter endDocument()");

		// end the root element
		endElement ( root ) ;

		// check and change the document state
		checkDocumentState ( STARTED , ENDED ) ;

		logger.debug("Leave endDocument()");
	}

	/**
	 * Adds an element to the XML document. An element, once added can't be
	 * changed anymore. This method is used to add element with no attributes
	 * and no data.
	 * 
	 * @param name of the element.
	 */
	public void addElement ( String name ) {
		logger.debug("Enter addElement(" + name + ")");

		addElement ( name , null , null ) ;

		logger.debug("Leave addElement()");
	}

	/**
	 * Adds an element to the XML document with its attributes and data. An
	 * element, once added can't be changed anymore.
	 * 
	 * @param name of the element.
	 * @param attrs of the element.
	 * @param data of the element.
	 */
	public void addElement ( String name , Map<String,String> attrs , String data ) {
		logger.debug("Enter addElemnt(" + name + ", " + attrs + ", " + data + ")");

		startElement ( name , attrs , data ) ;
		endElement ( name ) ;

		logger.debug("Leave addElement()");
	}

	/**
	 * Starts an element. Attributes, data and children elements can be added to
	 * this element using 'addAttr()', addAttrs()', 'addData()', 'addElement()'
	 * and 'startElement()' methods. A started element can be ended either by a
	 * call to 'endElement()', by starting a new element or by ending the XML
	 * document.
	 * 
	 * @param name
	 */
	public void startElement ( String name ) {
		logger.debug("Enter startElemnt(" + name + ")");

		startElement ( name , null , null ) ;

		logger.debug("Leave startElement()");
	}

	/**
	 * Starts an element with its attributes and data. Children elements can be
	 * added to this element using 'addElement()' and 'startElement()'. A
	 * started element can be ended either by a call to 'endElement()', by
	 * starting a new element or by ending the XML document.
	 * 
	 * @param name of the element.
	 * @param attrs of the element.
	 * @param data of the element.
	 */
	public void startElement ( String name , Map<String,String> attrs , String data ) {
		logger.debug("Enter startElemnt(" + name + ", " + attrs + ", " + data + ")");

		// check and change the document state
		checkDocumentState ( STARTED , STARTED ) ;

		// Do we have an in-progress element?
		if ( lastElmentTagStillOpen ) {
			// Yes, we do; close the in-progress element first
			write(">") ;
			if ( formatting ) 
				write("\n") ;
		}

		// write the start of the element
		if ( formatting )
			write ( tab() ) ;
		write ( "<" + name ) ;

		// Indicate that we have an in-progress element
		lastElmentTagStillOpen = true ;

		// write the attributes
		addAttrs ( attrs ) ;

		// Increase tabulation level
		tabLevel ++ ;

		// write the data
		addData ( data ) ;

		// flushing data
		flush() ;

		logger.debug("Leave startElement()");
	}

	/**
	 * Ends an element. An element, once ended, can't be changed.
	 * 
	 * @param name of the element.
	 */
	public void endElement ( String name ) {
		logger.debug("Enter endElemnt(" + name + ")");

		// check and change the document state
		checkDocumentState ( STARTED , STARTED ) ;

		// Decrease tabulation level
		tabLevel -- ;

		// Do we have an in-progress element?
		if ( lastElmentTagStillOpen ) {
			// Yes, we do; close the in-progress element
			write("/>") ;
			if ( formatting )
				write("\n") ;

			// Indicate that we don't have an in-progress element
			lastElmentTagStillOpen = false ;
		}
		else {
			// No, we don't have; write the end of the element
			if ( formatting )
				write ( tab() ) ;
			write ( "</" + name	+ ">" ) ;
			if ( formatting )
				write("\n") ;
		}

		// flushing data
		flush() ;

		logger.debug("Leave endElement()");
	}


	/**
	 * Adds data to an XML document or an element.
	 * 
	 * @param data of the element.
	 */
	public void addData ( String data ) {
		logger.debug("Enter addData(" + data + ")");

		// check and change the document state
		checkDocumentState ( STARTED , STARTED ) ;

		if ( data != null ) {
			// Do we have an in-progress element?
			if ( lastElmentTagStillOpen ) {
				// Yes, we do; close the in-progress element
				write(">") ;
	
				if ( formatting )
					write( "\n" + tab() );
				
				// Indicate that we don't have an in-progress element
				lastElmentTagStillOpen = false ;
			}
	
			// No, we don't have; write the end of the element
			write ( data ) ;

			if ( formatting )
				write( "\n" );
		}

		logger.debug("Leave addData()");
	}


	/**
	 * Adds a comment to the XML Document.
	 * 
	 * @param comment to added.
	 */
	public void addComment ( String comment ) {
		logger.debug("Enter addComment(" + comment + ")");

		// check and change the document state
		checkDocumentState ( STARTED , STARTED ) ;

		if ( comment != null ) {
			// Do we have an in-progress element?
			if ( lastElmentTagStillOpen ) {
				// Yes, we do; close the in-progress element
				write(">") ;
	
				if ( formatting )
					write( "\n" + tab() );
				
				// Indicate that we don't have an in-progress element
				lastElmentTagStillOpen = false ;
			}
	
			// No, we don't have; write the comment
			write ( "<!-- " + comment + " -->" ) ;

			if ( formatting )
				write( "\n" );
		}

		logger.debug("Leave addComment()");
	}

	/**
	 * Adds an element to the XML document. An element, once added can't be
	 * changed anymore. This method is used to add element with no attributes
	 * and no data.
	 * 
	 * @param name of the element.
	 */

	/**
	 * Adds an attribute to an XML document or an element.
	 * 
	 * @param name of the attribute.
	 * @param value of the attribute.
	 */
	public void addAttr ( String name , String value ) {
		logger.debug("Enter addAttr(" + name + ", " + value + ")");

		// check and change the document state
		checkDocumentState ( STARTED , STARTED ) ;

		if (!lastElmentTagStillOpen) {
			String errmsg =
				"Can't added '" + name + "' attribute to '" + root + "' document.\n"
				+ "There is no open element."
				;
			throw new RuntimeException ( errmsg ) ;
		}

		write(" " + name + "=\"" + value + "\"");

		logger.debug("Leave addAttr()");
	}


	/**
	 * Adds attributes to a document or an element.
	 * 
	 * @param attrs of the element.
	 */
	public void addAttrs ( Map<String,String> attrs ) {
		logger.debug("Enter addAttrs(" + attrs + ")");

		if (attrs != null ) {
			Iterator<String> iter = attrs.keySet().iterator() ;
			while ( iter.hasNext() ) {
				String attr = iter.next() ;
				addAttr ( attr , attrs.get(attr) ) ;
			}
		}

		logger.debug("Leave addAttrs()");
	}


	/**
	 * Sets the tabulation string.
	 * 
	 * @param tabString
	 */
	public void setTabString ( String tab ) {
		tabString = tab ;
	}


	/**
	 * Gets the tabulation string.
	 * 
	 * @return the tabulation string.
	 */
	public String getTabString () {
		return tabString ;
	}


	/**
	 * Sets the formatting flag.
	 * 
	 * @param formatting flag.
	 */
	public void setFormatting ( boolean formatting ) {
		this.formatting = formatting ;
	}


	/**
	 * Gets the formatting flag.
	 * 
	 * @return the formatting flag.
	 */
	public boolean getFormatting () {
		return formatting ;
	}

	/**
	 * @return the tabulation based on the current position in the document.
	 */
	private String tab() {
		String result = "" ;
		for ( int i = 0 ; i < tabLevel ; i++ )
			result += tabString ;
		return result ;
	}


	/**
	 * Checks the document state and change it as requested. a RuntimeException
	 * will be thrown in case the expected state is not the document's current
	 * state.
	 * 
	 * @param expetced state of the document.
	 * @param next state of the document.
	 */
	private void checkDocumentState ( String expetced , String next ) {
		// check the document state
		if ( ! state.equals(expetced) ) {
			String errmsg =
				"Can't start the document '" + root + "'.\n"
				+ "The document can't be started when it is in '" + state + "' state.\n"
				+ "The document should be in '" + expetced + "' state."
				;
			throw new RuntimeException ( errmsg ) ;
		}

		// change the document state
		state = next ;
	}

	private void write ( String text ) {
		try {
			writer.write ( text ) ;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage()) ;
		}
	}

	private void flush () {
		try {
			writer.flush() ;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage()) ;
		}
	}


	public boolean isAddXmlProlog() {
		return addXmlProlog;
	}
	public void setAddXmlProlog(boolean addXmlProlog) {
		this.addXmlProlog = addXmlProlog;
	}

	public static void format(String xml, Writer writer) {
		try {
			Source xmlInput = new StreamSource(new StringReader(xml));
			StreamResult xmlOutput = new StreamResult(writer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			String javaVersion = System.getProperty("java.version").substring(0, 3);
			Transformer transformer = null;
			if ( ObjectUtils.IN(javaVersion, "1.6", "1.7") ) {
				transformerFactory.setAttribute("indent-number", 4);

				transformer = transformerFactory.newTransformer();
				transformer.setParameter("omit-xml-declaration", true);
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			}
			else {
				transformer = transformerFactory.newTransformer();
			}
			transformer.transform(xmlInput, xmlOutput);
			} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Element readAsDomElement(String source) {
		InputStream is = null;
		try {
			is = new FileInputStream(source);
		} catch ( RuntimeException e) {
			throw e;
		} catch ( Throwable e) {
			throw new RuntimeException(e);
		}
		return readAsDomElement(is);
	}

	public static Element readAsDomElement(InputStream source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		Document document = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(source);
		} catch ( RuntimeException e) {
			throw e;
		} catch ( Throwable e) {
			throw new RuntimeException(e);
		}

		return document.getDocumentElement();
	}

	public static boolean compare(InputStream source1, InputStream source2){
		Element e1 = readAsDomElement(source1);
		Element e2 = readAsDomElement(source2);
		e1.normalize();
		e2.normalize();
		
		return e1.isEqualNode(e2);
	}

	public static boolean compare(String source1, String source2){
		Element e1 = readAsDomElement(source1);
		Element e2 = readAsDomElement(source2);
		e1.normalize();
		e2.normalize();
		
		return e1.isEqualNode(e2);
	}
	
	/**
	 * Create XML format from java Object.
	 */
	public static String convertObjectToXml ( Class<?> clazz, Object obj ) {
		if ( obj == null ){
			return null;
		}
		if ( clazz == null ){
			clazz = obj.getClass();
		}
		if ( !clazz.equals(obj.getClass()) ){
			return null;
		}
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(obj, os);
			
			return new String(os.toByteArray(), "UTF-8");
		} 
		catch (JAXBException e) {
			throw new RuntimeException(ExceptionUtils.lookupAllMessages(e));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(ExceptionUtils.lookupAllMessages(e));
		}
	}
	
	/**
	 * Create java Object from XML format.
	 */
	public static Object convertXmlToObject ( Class<?> clazz, String xml ) {
		if ( xml == null ){
			return null;
		}
		if ( clazz == null ){
			return null;
		}
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object obj = jaxbUnmarshaller.unmarshal(new StringReader(xml));
			
			return obj;
		} 
		catch (JAXBException e) {
			throw new RuntimeException(ExceptionUtils.lookupAllMessages(e));
		}
	}
	
	/**
	 * Create java Object from XML format.
	 */
	public static Object convertXmlToObject ( String xml, Class<?>... clazzs ) {
		if ( xml == null ){
			return null;
		}
		if ( clazzs == null || clazzs.length == 0 ){
			return null;
		}
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazzs);
			 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object obj = jaxbUnmarshaller.unmarshal(new StringReader(xml));
			
			return obj;
		} 
		catch (JAXBException e) {
			throw new RuntimeException(ExceptionUtils.lookupAllMessages(e));
		}
	}
	
	public static boolean validate(String xml, String xsdFileName){

		boolean result = false;
        try {
	        // 1. Lookup a factory for the W3C XML Schema language
	        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
	         
	        // 2. Compile the schema
	        Resource resource = new ClassPathResource(xsdFileName);
	        Schema schema = schemaFactory.newSchema(resource.getFile());
	     
	        // 3. get a validator from the schema
	        Validator validator = schema.newValidator();
	         
	        // 4. Parse the document you want to check
	        Source source = new StreamSource(new StringReader(xml));
	        
	        // 5. Check the document
            validator.validate(source);

            result = true;
        }
        catch (Exception ex) {
        	result = false;
        }

        return result;
		
	}
	
	private final static String READY = "Ready";
	private final static String STARTED = "Started" ;
	private final static String ENDED = "Ended" ;
	private String state = READY;

	private String root = null ;
	private Writer writer = null ;
	private String tabString = "\t" ;
	private long tabLevel = 0 ;
	private boolean lastElmentTagStillOpen = false ;
	private boolean formatting = true ;
	private boolean addXmlProlog = true ;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
}
