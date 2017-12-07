package assignment;

import java.util.ArrayList;
import java.util.List;

public class All_Networks {
	private ArrayList<Network> Networks=new ArrayList<Network>();
	private String ID;
	
public void add(List<String> currentLine){
	Network net=new Network();
	net.setTime(currentLine.get(3));
	net.setId(ID);
	net.setLat(Double.parseDouble(currentLine.get(6)));
	net.setLon(Double.parseDouble(currentLine.get(7)));
	net.setAlt(Double.parseDouble(currentLine.get(8)));
	net.setSsid(currentLine.get(1));
	net.setMac(currentLine.get(0));
	net.setFreq(Double.parseDouble(currentLine.get(4)));
	net.setSign(Integer.parseInt(currentLine.get(5)));
	ChanToFreq(net);
	if(chackValid(net))
		Networks.add(net);
	}
public void addId(List<String> currentLine){
	ID = currentLine.get(4).split("=")[1];
}

private static void ChanToFreq(Network curr){
	if(curr.getFreq()!=0)
		if(curr.getFreq()<12)
			curr.setFreq(2.4);
		else curr.setFreq(5);
}
private static boolean chackValid(Network curr) {
	boolean flag=true;
	if(!(curr.getMac().contains(":"))||curr.getTime().length()!=19)
		flag=false;
	if(
			curr.getTime().isEmpty()||
			curr.getLat()==0||
			curr.getLon()==0||
			curr.getAlt()==0||
			curr.getSsid().isEmpty()||
			curr.getMac().isEmpty()||
			curr.getFreq()==0||
			curr.getSign()==0
			)
		flag=false;
	
	return flag;
}
public ArrayList<Network> getNetworks() {
	return Networks;
}
public int size(){
	return Networks.size();
}

}

