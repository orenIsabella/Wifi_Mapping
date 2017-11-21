package assignment;

import java.util.ArrayList;

public class Final_order {

	/**
	 * final_order() transform All_Networks to Final_Networks witch contain 
	 * all the data we need at the correct order.
	 * the method using private methods and Comparator to take only ten best-signal network in each point.
	 */
	public void final_order(String folderName){
		Array.csvToArray(folderName);
		Array.getAll_Networks().sort(COMP_By_TIME);
		String time="";
		String ID="";
		String Lat="";
		Final_Networks.add(Array.getAll_Networks().get(0));
		for(int i=1;i<Array.getAll_Networks().size();i++){
			time =Array.getAll_Networks().get(i).get(0);
			ID=Array.getAll_Networks().get(i).get(1);
			Lat=Array.getAll_Networks().get(i).get(2);
			if(time.equals(Final_Networks.get(Final_Networks.size()-1).get(0))&&
					ID.equals(Final_Networks.get(Final_Networks.size()-1).get(1))&&
					Lat.equals(Final_Networks.get(Final_Networks.size()-1).get(2)) ){
				addNetToNetwork_Per_Time(i);
				if(i==Array.getAll_Networks().size()-1){
					addNetToFinal_Networks();
				}
			}
			else{
				addNetToFinal_Networks();
				Final_Networks.add(Array.getAll_Networks().get(i));
			}

		}

	}
	
	public  int getNetCounter() {
		return NetCounter;
	}

	public ArrayList<ArrayList<String>> getFinal_Networks() {
		return Final_Networks;
	}
	

	public void setNetCounter(int netCounter) {
		NetCounter = netCounter;
	}

	// ************** Private *******************
	private static void addNetToFinal_Networks(){
		int count;
		if(Network_Per_Time.size()+1>10)
			count=10;
		else count=Network_Per_Time.size()+1;
		Final_Networks.get(Final_Networks.size()-1).add(5,Integer.toString(count));
		if(!Network_Per_Time.isEmpty()){

			topTen();
			Network_Per_Time.clear();

		}

	}
	private static void addNetToNetwork_Per_Time(int k){
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=5;i<=8;i++){
			temp.add(Array.getAll_Networks().get(k).get(i));
		}
		Network_Per_Time.add(temp);
	}
	private static void topTen (){
		Network_Per_Time.sort(COMP_By_SIGNAL);
		NetCounter=Math.max(NetCounter, Network_Per_Time.size()+1);
		for(int i=0;i<9;i++){
			if(!Network_Per_Time.isEmpty()){
				for(int k=0;k<4;k++){		
					Final_Networks.get(Final_Networks.size()-1).add(Network_Per_Time.get(0).get(k));
				}
				Network_Per_Time.remove(0);
			}
		}
	}
	
	private static CsvToArray Array=new CsvToArray(); 
	private static int NetCounter=0;
	private static final Signal_Comparator COMP_By_SIGNAL = new Signal_Comparator();
	private static final Time_Comparator COMP_By_TIME = new Time_Comparator();
	private static ArrayList<ArrayList<String>> Final_Networks=new ArrayList<ArrayList<String>>();
	private static ArrayList<ArrayList<String>> Network_Per_Time=new ArrayList<ArrayList<String>>();
}
