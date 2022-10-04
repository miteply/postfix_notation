package ferovinum.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Reads file
 * 
 * @author T.Mykhaylo
 *
 */
public class FileUtil {
	
	
	public BufferedReader readFile(String filePath) {
		
		try {
			
		File inputF = new File(filePath);
	  
		return new BufferedReader(new InputStreamReader(new FileInputStream(inputF)));
			 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
