package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateNets {

	/**  
	 * @author arbel and isabella
	 *  csvToArray() Reading folder with the method File witch in the java.io,
	 *  and adding it's files, Line by Line with FileReader and BufferedReader
	 *  (they are from java.io as well)to ArrayList<String[]> 'All_Networks'.
	 *  in the process, every line run in  private methods to Extract only the date we required.  
	 */

	public  void CreateN (String folderName){

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
					add(temp);
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
	/**
	 * @category adds the current line
	 * @param currentLine
	 */
	public void add(List<String> currentLine){
		Network net=new Network();
		net.setTime(currentLine.get(3));
		net.setId(ID);
		net.getLocation().setLat(Double.parseDouble(currentLine.get(6)));
		net.getLocation().setLon(Double.parseDouble(currentLine.get(7)));
		net.getLocation().setAlt(Double.parseDouble(currentLine.get(8)));
		net.setSsid(currentLine.get(1));
		net.setMac(currentLine.get(0));
		net.setFreq(Double.parseDouble(currentLine.get(4)));
		net.setSign(Integer.parseInt(currentLine.get(5)));
		ChanToFreq(net);
		if(chackValid(net))
			nets.add(net);
		}
	/**
	 * @category adds Id
	 * @param currentLine
	 */
	public void addId(List<String> currentLine){
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
		if(!(curr.getMac().contains(":"))||curr.getTime().length()!=19)
			flag=false;
		if(
				curr.getTime().isEmpty()||
				curr.getLocation().getLat()==-4000||
				curr.getLocation().getLon()==-4000||
				curr.getLocation().getAlt()==-4000||
				curr.getSsid().isEmpty()||
				curr.getMac().isEmpty()||
				curr.getFreq()==0||
				curr.getSign()==0
				)
			flag=false;
		
		return flag;
	}
	
/**
 * 
 * @return nets
 */
	public ArrayList<Network> getNets() {
		return nets;
	}




	// ************** Private *******************
	private ArrayList<Network> nets=new ArrayList<Network>();
	private String ID;
	
	}
