package assignment;

import java.util.ArrayList;

public class All_Networks {
	private ArrayList<Network> Networks=new ArrayList<Network>();
	private String ID;
	
public void add(ArrayList<String> currentLine){
	Network net=new Network();
	net.setTime(currentLine.get(3));
	net.setId(ID);
	net.setLat(Double.parseDouble(currentLine.get(6)));
	net.setLon(Double.parseDouble(currentLine.get(7)));
	net.setAlt(Double.parseDouble(currentLine.get(8)));
	net.setSsid(currentLine.get(1));
	net.setMac(currentLine.get(0));
	net.setFreq(Double.parseDouble(currentLine.get(4)));
	net.setSign(Double.parseDouble(currentLine.get(5)));
	ChanToFreq(net);
	if(chackValid(net))
		Networks.add(net);
	}
public void addId(ArrayList<String> currentLine){
	
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
			curr.getTime()==null||
			curr.getLat()==0||
			curr.getLon()==0||
			curr.getAlt()==0||
			curr.getSsid()==null||
			curr.getMac()==null||
			curr.getFreq()==0||
			curr.getSign()==0
			)
		flag=false;
	
	return flag;
}

}

