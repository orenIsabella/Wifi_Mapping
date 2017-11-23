package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ToCsv {
	/**
	 * @author arbel and isabella
	 * toCSV() using PrintWriter from java.io to write the final networks 
	 * that we get from Final_Order method into 
	 *  lines and adding the matching headline witch formed a .csv file.
	 */
	public  void toCSV(String sourseFolder,String DestinationFolder){
		Array.final_order(sourseFolder);
		PrintWriter pw=null;;
		try {
			pw = new PrintWriter(new File(DestinationFolder));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Head();
		pw.write(HeadLine);

		for(int i=0; i<Array.getFinal_Networks().size(); i++){
			List<String>  temp=Array.getFinal_Networks().get(i);
			String line_temp=String.join(",", temp);
			pw.write("\n");
			pw.write(line_temp);

		}
		pw.close();
		
	}
	
	// ************** Private *******************
	
	private static void Head(){
		if(Array.getNetCounter()>10)Array.setNetCounter(10);
		for(int i=1;i<=Array.getNetCounter();i++){
			HeadLine+=",SSID"+i+",MAC"+i+",Frequncy"+i+",Signal"+i;
}
}
	private static Final_order Array=new Final_order();
	private static String HeadLine="Time, ID, Lat, Lon, Alt,#";
}