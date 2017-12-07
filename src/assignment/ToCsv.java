package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ToCsv {
	/**
	 * @author arbel and isabella
	 * toCSV() using PrintWriter from java.io to write the final networks 
	 * that we get from Final_Order method into 
	 *  lines and adding the matching headline witch formed a .csv file.
	 */

	public ToCsv(String destinationFolder, ArrayList<ArrayList<String>> inputArr) {
		DestinationFolder = destinationFolder;
		InputArr = inputArr;
	}

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