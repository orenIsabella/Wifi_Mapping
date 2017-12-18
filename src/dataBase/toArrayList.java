package dataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class toArrayList {
	private Networks nets=new Networks();
	private String DestinationFolder;

	public toArrayList(String destinationFolder,Networks nets) {
		this.nets = nets;
		DestinationFolder = destinationFolder;
	}
	

	public  void toCSV(){
		PrintWriter pw=null;;
		try {
			pw = new PrintWriter(new File(DestinationFolder));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<nets.getNetworks().size(); i++){
			ArrayList<String>  temp= conv_line(nets.getNetworks().get(i));
			String line_temp=String.join(",", temp);
			pw.write(line_temp);
			pw.write("\n");
		}
		pw.close();

	}
	
	private ArrayList<String> conv_line(A_Point a){
		ArrayList<String> line=new ArrayList<String>();
		line.add(a.getTime());
		line.add(a.getID());
		line.add(Double.toString(a.getLocation().getLat()));
		line.add(Double.toString(a.getLocation().getLon()));
		line.add(Double.toString(a.getLocation().getAlt()));
		line.add(Integer.toString(a.getNets().size()));
		for(int j=0;j<a.getNets().size();j++){
			line.add(a.getNets().get(j).getSsid());
			line.add(a.getNets().get(j).getMac());
			line.add(Double.toString(a.getNets().get(j).getFreq()));
			line.add(Integer.toString(a.getNets().get(j).getSign()));
		}
		return line;
	}
}
