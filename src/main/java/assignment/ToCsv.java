package main.java.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Arbel Nathan
 * @author Isabella Oren
 * 
 * ToCsv class converts the data to a CSV file
 */
public class ToCsv {
	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * 
	 * the constructor
	 */

	public ToCsv(String destinationFolder, ArrayList<ArrayList<String>> inputArr) {
		DestinationFolder = destinationFolder;
		InputArr = inputArr;
	}

	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * 
	 * toCSV() uses PrintWriter from java.io to write the final networks 
	 * that we get from Final_Order method into 
	 *  lines and adding the matching headline witch formed a .csv file.
	 */

	public  void toCSV(){
		PrintWriter pw=null;;
		try {
			pw = new PrintWriter(new File(DestinationFolder));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<InputArr.size(); i++){
			List<String>  temp=InputArr.get(i);
			String line_temp=String.join(",", temp);
			pw.write(line_temp);
			pw.write("\n");
		}
		pw.close();

	}



	



	// ************** Private *******************

	String DestinationFolder;
	private ArrayList<ArrayList<String>> InputArr=new ArrayList<ArrayList<String>>();
}