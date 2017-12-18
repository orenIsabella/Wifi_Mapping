package algorithems;

import assignment.Point3D;
import dataBase.A_Point;
import dataBase.Networks;

public class Algo2 {
	private int	power=	2,
			norm =10000,
			min_diff=3,
			no_ignal=-120,
			diff_no_sig=100;
	private double sig_diff=0.4;
	private Networks Data=new Networks();
	private Networks Comp=new Networks();
	
	public Algo2(String Data1, String comp1) {
		Data.addFromInput(Data1);
		Comp.addFromInput(comp1);
	}
	
	public void algo2(){
		for(int i=0;i<Comp.getNetworks().size();i++){
			Comp.getNetworks().get(i).setLocation(simNets(Comp.getNetworks().get(i)));
		}
	}
	
	private Point3D simNets(A_Point a){
		Point3D ans=new Point3D();
		A_Point arr[]=new A_Point[3];
		
		
		ans=weight(arr);
		return ans;
		
	}
	
	private Point3D weight(A_Point a[]){
		Point3D point1=new Point3D();
		Point3D point2=new Point3D();
		Point3D point3=new Point3D();
		Point3D ans=new Point3D();
		point1.setLat(a[0].getLocation().getLat()/a[0].getWeight());
		point2.setLat(a[1].getLocation().getLat()/a[1].getWeight());
		point3.setLat(a[3].getLocation().getLat()/a[3].getWeight());
		point1.setLon(a[0].getLocation().getLon()/a[0].getWeight());
		point2.setLon(a[1].getLocation().getLon()/a[1].getWeight());
		point3.setLon(a[3].getLocation().getLon()/a[3].getWeight());
		point1.setAlt(a[0].getLocation().getAlt()/a[0].getWeight());
		point2.setAlt(a[1].getLocation().getAlt()/a[1].getWeight());
		point3.setAlt(a[3].getLocation().getAlt()/a[3].getWeight());
		double sumWeight=a[0].getWeight()+a[1].getWeight()+a[2].getWeight();
		ans.setLat((point1.getLat()+point2.getLat()+point3.getLat())/sumWeight);
		ans.setLon((point1.getLon()+point2.getLon()+point3.getLon())/sumWeight);
		ans.setAlt((point1.getAlt()+point2.getAlt()+point3.getAlt())/sumWeight);
		return ans;
	}

}
