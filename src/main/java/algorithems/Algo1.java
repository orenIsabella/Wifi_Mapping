package main.java.algorithems;

import main.java.assignment.Point3D;
import main.java.dataBase.Networks;

public class Algo1 {
	
	private Networks nets=new Networks();
	private String mac;
	
	
	
	public Algo1(Networks nets, String mac) {
		
		this.nets = nets;
		this.mac = mac;
	}



	public Point3D algo1full() {
	
				MacPoint temp=new MacPoint();
				temp.setMac(mac);
				temp.setLocation(algo1(mac));
		
			
		return temp.getLocation();
	}
	

	
	private  Point3D algo1(String mac) {
		Point3D w=new Point3D();
		FilterByMac filtered=new FilterByMac();
		filtered.filter(mac,  nets);
		double mone=0.0;
		double mechane=0.0;
		for(int i=0; i<nets.size(); i++)
			for(int j=0; j<nets.getNetworks().get(i).getNets().size(); j++){
			double koved=1.0/(nets.getNetworks().get(i).getNets().get(j).getSign()*nets.getNetworks().get(i).getNets().get(j).getSign());
			mone+=nets.getNetworks().get(i).getLocation().getAlt() *koved;
			mechane+=koved;	
		}
		w.setAlt((mone/mechane));
		mone=0.0;
		mechane=0.0;
		for(int i=0; i<nets.size(); i++)
			for(int j=0; j<nets.getNetworks().get(i).getNets().size(); j++){
			double koved=1.0/(nets.getNetworks().get(i).getNets().get(j).getSign()*nets.getNetworks().get(i).getNets().get(j).getSign());
			mone+=nets.getNetworks().get(i).getLocation().getLon() *koved;
			mechane+=koved;			
		}
		w.setLon((mone/mechane));
		
		mone=0.0;
		mechane=0.0;
		for(int i=0; i<nets.size(); i++)
			for(int j=0; j<nets.getNetworks().get(i).getNets().size(); j++){
			double koved=1.0/(nets.getNetworks().get(i).getNets().get(j).getSign()*nets.getNetworks().get(i).getNets().get(j).getSign());
			mone+=nets.getNetworks().get(i).getLocation().getLat() *koved;
			mechane+=koved;			
		}
		w.setLat((mone/mechane));
		
		return w;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
