package org.diembo.base.utils.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.diembo.base.enums.ErrorCode;
import org.diembo.base.utils.SaphirException;


public class TextFileUtils {


	public static List<String[]> readCsvFile(String file) { 
	    List<String[]> content = new ArrayList<String[]>();
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	        }
	        br.close();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
	    } catch (IOException e) {
			throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
		}
	    return content;
	}
	
	public static List<String[]> readFixedPositionFile(
			String file, 
			List<TextFileField> header,
			List<TextFileField> fields,
			List<TextFileField> footer,
			String  footerPrefix) { 
		
	    List<String[]> content = new ArrayList<String[]>();
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	        String line = "";
	        
	        line = br.readLine();
            content.add(split(line, header));
            
	        while ((line = br.readLine()) != null) {
	        	if (! line.startsWith(footerPrefix)) {
		            content.add(split(line, fields));
	        	} else {
		            content.add(split(line, footer));
	        	}
	        }
	        br.close();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new SaphirException(ErrorCode.file_not_found, e.getMessage());
	    } catch (IOException e) {
			throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
		}
	    return content;
	}
	
	public static String[] split(String line, List<TextFileField> fields) { 
		
		String[] result = new String[fields.size()];
	
		int index =  0;
		for (TextFileField field : fields) {
			result[index++] = line.substring(field.getStart()-1, field.getStart()-1 + field.getLength());
		}
		
		return result;
	}
	
//	public static Map<String, String> split(String line, List<TextFileField> fields) { 
//		
//		Map<String, String> result = new HashMap<String, String>();
//	
//		for (TextFileField field : fields) {
//			String item = line.substring(field.getStart(), field.getLength());
//			result.put(field.getName(), item);
//		}
//		
//		return result;
//	}
	
}
