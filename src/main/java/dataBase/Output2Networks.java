package main.java.dataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.assignment.Point3D;

/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *
 *@category converts the output to a type Networks
 */
public class Output2Networks {

	
	/**
	 * @category adds path to nets
	 * @param path
	 * @param nets
	 */
	public  void add(String path,ArrayList<A_Point> nets){


		try {
			/*
			 * FileReader() Creates an object that allows access to 
			 * a file on the disk
			 * This means opening a file to read
			 */

			FileReader fr = new FileReader(path);
			if(!(path.contains("csv"))){
				System.out.println(path+" is unvalid file!");
			}
			/*
			 * A constructor that accepts a FileReader object and allows
			 * Read information from a file by a 
			 * readLine () function that reads an entire row.
			 */
			BufferedReader br = new BufferedReader(fr);

			String currentLine;
			currentLine = br.readLine();
			currentLine = br.readLine();
			
			while(currentLine!=null){
				List<String> current=Arrays.asList(currentLine.split(","));
				nets.add(addA(current));
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
	/**
	 * @category converts a List<String> a to a point
	 * @param a
	 * @return curr
	 */

private A_Point addA(List<String> a){
   A_Point curr = new A_Point();
   curr.setTime(a.get(0));
   curr.setID(a.get(1));
	Point3D temp=new Point3D(Double.parseDouble(a.get(2)),Double.parseDouble(a.get(3)),Double.parseDouble(a.get(4)));
	curr.setLocation(temp);
	curr.setNets(addN(a));
	return curr;
}
	/**
	 * @category adds a List<String> to currs
	 * @param a
	 * @return ArrayList<Network>
	 */
private ArrayList<Network> addN(List<String> a){
	ArrayList<Network> currs=new ArrayList<Network>();
	for(int j=0;j<Integer.parseInt(a.get(5));j++){
		Network temp=new Network();
		int current=(j*4)+6;
		temp.setFreq(Double.parseDouble(a.get(current+2)));
		temp.setMac(a.get(current+1));
		temp.setSign(Integer.parseInt(a.get(current+3)));
		temp.setSsid(a.get(current));
		currs.add(temp);
	}
	return currs;
}
	





}
