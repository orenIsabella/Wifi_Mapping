package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvToArray {

	/**  
	 * @author arbel and isabella
	 *  csvToArray() Reading folder with the method File witch in the java.io,
	 *  and adding it's files, Line by Line with FileReader and BufferedReader
	 *  (they are from java.io as well)to ArrayList<String[]> 'All_Networks'.
	 *  in the process, every line run in  private methods to Extract only the date we required.  
	 */

	public  void csvToArray (String folderName){

		File The_file=new File(folderName);
		File[] filePath=The_file.listFiles();
		for(int i=0;i<filePath.length;i++){
			// try read from the file
			
			try {
				/*
				 * FileReader() Creates an object that allows access to 
				 * a file on the disk
				 * This means opening a file to read
				 */

				FileReader fr = new FileReader(filePath[i].getPath());
				if(!(filePath[i].getPath().contains("csv")&&filePath[i].getPath().contains("WigleWifi"))){
					System.out.println(filePath[i].getPath()+" is unvalid file!");
					continue;
					}
				/*
				 * A constructor that accepts a FileReader object and allows
				 * Read information from a file by a 
				 * readLine () function that reads an entire row.
				 */
				BufferedReader br = new BufferedReader(fr);

				String currentLine;
				currentLine = br.readLine();
				List<String> model=Arrays.asList(currentLine.split(","));
				nets.addId(model);
				currentLine = br.readLine();
				currentLine = br.readLine();
				while(currentLine!=null){
					List<String> temp=Arrays.asList(currentLine.split(","));
					nets.add(temp);
					currentLine = br.readLine();
				}
				br.close();
				fr.close();
			}
			catch(IOException ex) {
				System.out.print("Error reading file\n" + ex);
				System.exit(2);
			}
		}
	
	}
	
	

	public All_Networks getNets() {
		return nets;
	}




	// ************** Private *******************
	private All_Networks nets =new All_Networks();
	
	
	}
