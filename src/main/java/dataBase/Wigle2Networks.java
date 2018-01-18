package main.java.dataBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.assignment.Signal_Comp2;

public class Wigle2Networks {

	/**  
	 * @author arbel and isabella
	 *  csvToArray() Reading folder with the method File witch in the java.io,
	 *  and adding it's files, Line by Line with FileReader and BufferedReader
	 *  (they are from java.io as well)to ArrayList<String[]> 'All_Networks'.
	 *  in the process, every line run in  private methods to Extract only the date we required.  
	 */

	public ArrayList<A_Point> add(String folderName,ArrayList<A_Point> input){
		nets=input;
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

				addId(model);
				currentLine = br.readLine();
				currentLine = br.readLine();
				while(currentLine!=null){
					List<String> temp=Arrays.asList(currentLine.split(","));
					A_Point temp_point=addA_P(temp);
					if(chackValid_A_P(temp_point)) {
						if(notCont(temp_point)) {
							nets.add(temp_point);
						}
						Network n=add_N(temp);
						if(n!=null)
							nets.get(nets.size()-1).getNets().add(n);
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
		topTen();
		return nets;

	}


	private void topTen() {
		for(int i=0;i<nets.size();i++) {
			nets.get(i).getNets().sort(COMP_By_SIGNAL);
			while(nets.get(i).getNets().size()>10)
				nets.get(i).getNets().remove(10);
		}

	}


	private boolean notCont(A_Point point) {
		boolean flag=true;
		if(nets.size()>0)
			if(point.equals(nets.get(nets.size()-1)))
				flag= false;

		return flag;	
	}
	private A_Point addA_P(List<String> currentLine){
		A_Point point=new A_Point();
		point.setTime(currentLine.get(3));
		point.setID(ID);
		point.getLocation().setLat(Double.parseDouble(currentLine.get(6)));
		point.getLocation().setLon(Double.parseDouble(currentLine.get(7)));
		point.getLocation().setAlt(Double.parseDouble(currentLine.get(8)));
		return point;
	}
	/**
	 * @category adds the current line
	 * @param currentLine
	 */
	private Network add_N(List<String> currentLine){
		Network net=new Network();
		net.setSsid(currentLine.get(1));
		net.setMac(currentLine.get(0));
		net.setFreq(Double.parseDouble(currentLine.get(4)));
		net.setSign(Integer.parseInt(currentLine.get(5)));
		ChanToFreq(net);
		if(chackValid(net)) {
			return net;
		}
		return null;
	}
	/**
	 * @category adds Id
	 * @param currentLine
	 */
	private void addId(List<String> currentLine){
		ID = currentLine.get(4).split("=")[1];
	}

	/**
	 * @category changes the frequancy to the correct one
	 * @param curr
	 */
	private static void ChanToFreq(Network curr){
		if(curr.getFreq()!=0)
			if(curr.getFreq()<12)
				curr.setFreq(2.4);
			else curr.setFreq(5);
	}
	/**
	 * @category checks if valid
	 * @param curr
	 * @return true or false
	 */
	private static boolean chackValid(Network curr) {
		boolean flag=true;
		if(!(curr.getMac().contains(":")))
			flag=false;
		if(
				curr.getSsid().isEmpty()||
				curr.getMac().isEmpty()||
				curr.getFreq()==0||
				curr.getSign()==0
				)
			flag=false;

		return flag;
	}
	private static boolean chackValid_A_P(A_Point curr2) {
		boolean flag=true;
		if(!(curr2.getTime().length()>=16)) {
			flag=false;}
		if(
				curr2.getTime().isEmpty()||
				curr2.getLocation().getLat()==-4000||
				curr2.getLocation().getLon()==-4000||
				curr2.getLocation().getAlt()==-4000
				) {
			flag=false;
		}
		return flag;
	}
	/**
	 * 
	 * @return nets
	 */
	public ArrayList<Network> getNets() {
		return net;
	}




	// ************** Private *******************
	private ArrayList<Network> net=new ArrayList<Network>();
	private ArrayList<A_Point> nets=new ArrayList<A_Point>();
	private String ID;
	private  final Signal_Comp2 COMP_By_SIGNAL = new Signal_Comp2();
}
