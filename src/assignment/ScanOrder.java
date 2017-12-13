package assignment;

import java.util.ArrayList;

public class ScanOrder {

	/**
	 * @author arbel and isabella
	 * final_order() transform all the networks we get from csvToArray method to contain 
	 * only the data we need and at the correct order.
	 * the method using private methods and Comparator to take only ten best-signal network in each point.
	 */
	public ScanOrder(All_Networks nets,String dest){
		this.nets = nets;
		DestinationFolder=dest;
	}
	
	public void order(){
		nets.getNetworks().sort(COMP_By_TIME);
		String time="";
		String ID="";
		String Lat="";
		Final_Networks.add(toline(nets.getNetworks().get(0)));
		for(int i=1;i<nets.size();i++){
			time =nets.getNetworks().get(i).getTime();
			ID=nets.getNetworks().get(i).getId();
			Lat=Double.toString(nets.getNetworks().get(i).getLocation().getLat());
			if(time.equals(Final_Networks.get(Final_Networks.size()-1).get(0))&&
					ID.equals(Final_Networks.get(Final_Networks.size()-1).get(1))&&
					Lat.equals(Final_Networks.get(Final_Networks.size()-1).get(2))){
				addNetToNetwork_Per_Time(i);
				if(i==nets.getNetworks().size()-1){
					addNetToFinal_Networks();
				}
			}
			else{
				addNetToFinal_Networks();
				Final_Networks.add(toline(nets.getNetworks().get(i)));
			}
		}
		Head();
		Final_Networks.add(0,HeadLine);
		ToCsv export=new ToCsv(DestinationFolder,Final_Networks);
		export.toCSV();
	}
	
	// ************** Private *******************
	private  void addNetToFinal_Networks(){
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
	private ArrayList<String> toline(Network a){
		ArrayList<String> temp=new ArrayList<String>();
		temp.add(a.getTime());
		temp.add(a.getId());
		temp.add(Double.toString(a.getLocation().getLat()));
		temp.add(Double.toString(a.getLocation().getLon()));
		temp.add(Double.toString(a.getLocation().getAlt()));
		temp.add(a.getSsid());
		temp.add(a.getMac());
		temp.add(Double.toString(a.getFreq()));
		temp.add(Integer.toString(a.getSign()));
		return temp;
	}
	
	private  void addNetToNetwork_Per_Time(int k){
		ArrayList<String> temp=new ArrayList<String>();
			temp.add(nets.getNetworks().get(k).getSsid());
			temp.add(nets.getNetworks().get(k).getMac());
			temp.add(Double.toString(nets.getNetworks().get(k).getFreq()));
			temp.add(Integer.toString(nets.getNetworks().get(k).getSign()));
		Network_Per_Time.add(temp);
	}
	private  void topTen (){
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
	private  void Head(){
		HeadLine.add("Time");
		HeadLine.add("ID");
		HeadLine.add("Lat");
		HeadLine.add("Lon");
		HeadLine.add("Alt");
		HeadLine.add("#");
		;
		if(NetCounter>10)NetCounter=10;
		for(int i=1;i<=NetCounter;i++){
			HeadLine.add("SSID"+i);
			HeadLine.add("MAC"+i);
			HeadLine.add("Frequncy"+i);
			HeadLine.add("Signal"+i);
		}
	}
	public ArrayList<ArrayList<String>> getFinal_Networks() {
		return Final_Networks;
	}

	
	String DestinationFolder;
	private static ArrayList<String> HeadLine=new ArrayList<String>();
	private All_Networks nets; 
	private  int NetCounter=0;
	private  final Signal_Comparator COMP_By_SIGNAL = new Signal_Comparator();
	private  final Time_Comparator COMP_By_TIME = new Time_Comparator();
	private  ArrayList<ArrayList<String>> Final_Networks=new ArrayList<ArrayList<String>>();
	private  ArrayList<ArrayList<String>> Network_Per_Time=new ArrayList<ArrayList<String>>();
}