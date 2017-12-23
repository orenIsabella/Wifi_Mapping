package algorithems;

import java.util.ArrayList;

import assignment.Point3D;
import assignment.ToCsv;
import dataBase.Networks;

public class Algo1 {
	private static ArrayList<MacPoint> ans=new  ArrayList<MacPoint>();
	
	public  void algo1full() {
		Networks  Data=new Networks();
		Data.addFromInput("C:/Users/Student/Desktop/_comb_all_BM2_.csv");
		while(Data.size()>0) {
				MacPoint temp=new MacPoint();
				String mac=Data.getNetworks().get(0).getNets().get(0).getMac();
				temp.setMac(mac);
				temp.setLocation(algo1(mac));
				ans.add(temp);
				FilterByMacRev filtered=new FilterByMacRev();
				filtered.filter(mac, Data);
			}
		print();
	}
	

	
	private static Point3D algo1(String mac) {
		Point3D w=new Point3D();
		Networks  nets=new Networks();
		nets.addFromInput("C:/Users/Student/Desktop/_comb_all_BM2_.csv");
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
	
	private void print() {
		ArrayList<ArrayList<String>> p=new ArrayList<ArrayList<String>>();
		for(int i=0;i<ans.size();i++) {
			ArrayList<String> s=new ArrayList<String>();
			s.add(ans.get(i).getMac());
			s.add(Double.toString(ans.get(i).getLocation().getLat()));
			s.add(Double.toString(ans.get(i).getLocation().getLon()));
			s.add(Double.toString(ans.get(i).getLocation().getAlt()));
			p.add(s);
		}
			ToCsv print=new ToCsv("C:/Users/Student/Desktop/check.csv",p);
			print.toCSV();
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
