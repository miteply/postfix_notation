package ferovinum;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import ferovinum.utils.FileConverter;
import ferovinum.utils.FileUtil;
import ferovinum.utils.ProcessDataList;

//javac ferovinum\*.java
//java ferovinum/Main
//C:\Development\workspace\interviews\ferovinum\text.csv

public class Main {
	
	public static void main(String [] args) throws IOException {
		 String path = "C:\\Development\\workspace\\interviews\\ferovinum\\text.csv";
	     FileConverter fileConverter = new FileConverter();
	     List<Map<Character, String>> mapFileRowsIntoList = fileConverter.mapFileRowsIntoList(new FileUtil().readFile(path));
		
	     ProcessDataList processFileLineList = new ProcessDataList(mapFileRowsIntoList);
	     processFileLineList.processListItem();
	     
		
	}

}
