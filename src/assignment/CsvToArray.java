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
				model=Arrays.asList(model.get(4).split("="));
				currentLine = br.readLine();
				currentLine = br.readLine();
				while(currentLine!=null){
					List<String> temp1=Arrays.asList(currentLine.split(","));
					ArrayList<String> temp2=new ArrayList<>(temp1);
					ArrayList<String> temp3=new ArrayList<>();
					temp2.add(model.get(1));
					ChanToFreq(temp2);
					temp3=By_Order(temp2);
					if(chackValid(temp3)){
					All_Networks.add(temp3);
					}
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
	
	public  ArrayList<ArrayList<String>> getAll_Networks() {
		return All_Networks;
	}

	// ************** Private *******************
	private static ArrayList<ArrayList<String>> All_Networks=new ArrayList<ArrayList<String>>();
	
	
	private static void ChanToFreq(ArrayList<String> arr){
		if(Integer.parseInt(arr.get(4))!=0)
			if(Integer.parseInt(arr.get(4))<12)
				arr.set(4, "2.4Ghz");
			else arr.set(4, "5Ghz");
	}

	private static ArrayList<String> By_Order(ArrayList<String> arr){
		ArrayList<String> Final=new ArrayList<>();
		Final.add(arr.get(3));
		Final.add(arr.get(11));
		Final.add(arr.get(6));
		Final.add(arr.get(7));
		Final.add(arr.get(8));
		Final.add(arr.get(1));
		Final.add(arr.get(0));
		Final.add(arr.get(4));
		Final.add(arr.get(5));
		return Final;
	}
	private static boolean chackValid(ArrayList<String> temp2) {
		boolean flag=true;
		if(temp2.size()!=9||!(temp2.get(6).contains(":"))||temp2.get(0).length()!=19)
			flag=false;
		for(int i=0;i<temp2.size();i++)
		if(temp2.get(i).isEmpty())
			flag=false;
		
		return flag;
	}
	
	
	
	}
