package algorithems;

import java.util.ArrayList;
import java.util.Arrays;

import assignment.Point3D;
import dataBase.A_Point;
import dataBase.Network;
import dataBase.Networks;
import dataBase.toArrayList;

public class Algo2 {
	private int	power=	2,
			norm =10000;
	private double sig_diff=0.4;
	private Networks Data1=new Networks();
	private Networks Comp=new Networks();
	private Weight_Comperator comper=new Weight_Comperator();


	public Algo2(String Data2, String comp2) {
		Data1.addFromInput(Data2);
		Comp.addFromInput(comp2);
	}
	//sending every line from the file with the ??? to find it's location
	public void algo2(){
		for(int i=0;i<Comp.size();i++){
			Comp.getNetworks().get(i).setLocation(simNets(Comp.getNetworks().get(i)));
		}//export to csv 
		toArrayList b=new toArrayList("C:/Users/Student/Desktop/alg2.csv", Comp);
		b.toCSV();
	}
	//comparing every line in the Data (file without the ???) to the line we sent to him
	//checking first if there any similar MACs between them and sending to find the similarity level
	//foe every one.
	private Point3D simNets(A_Point a){
		//System.out.println(a.toString());
		Networks Data=new Networks(Data1);
		Point3D ans=new Point3D();
		A_Point arr[]=new A_Point[3];


		for(int i=0;i<Data.size();i++){
			ArrayList<Network> corrnet=Data.getNetworks().get(i).getNets();
			double one=0,two=0,three=0;
			if(corrnet.size()>=3&&a.getNets().size()>=3){

				if(a.getNets().get(1).getMac().equals(corrnet.get(1).getMac())){
					one=comper(a.getNets().get(1),corrnet.get(1));
					if(a.getNets().get(2).getMac().equals(corrnet.get(2).getMac())){
						two=comper(a.getNets().get(2),corrnet.get(2));
						three=comper(a.getNets().get(0),corrnet.get(0));
					}else {
						two=comper(a.getNets().get(0),corrnet.get(2));
						three=comper(a.getNets().get(2),corrnet.get(0));
					}
				}
				else if(a.getNets().get(1).getMac().equals(corrnet.get(2).getMac())){
					one=comper(a.getNets().get(1),corrnet.get(2));
					if(a.getNets().get(2).getMac().equals(corrnet.get(1).getMac())){
						two=comper(a.getNets().get(2),corrnet.get(1));
						three=comper(a.getNets().get(0),corrnet.get(0));
					}else {
						two=comper(a.getNets().get(0),corrnet.get(1));
						three=comper(a.getNets().get(2),corrnet.get(0));
					}
				}
				else if(a.getNets().get(1).getMac().equals(corrnet.get(0).getMac())){
					one=comper(a.getNets().get(1),corrnet.get(0));
					if(a.getNets().get(2).getMac().equals(corrnet.get(2).getMac())){
						two=comper(a.getNets().get(2),corrnet.get(2));
						three=comper(a.getNets().get(0),corrnet.get(1));
					}else {
						two=comper(a.getNets().get(0),corrnet.get(2));
						three=comper(a.getNets().get(2),corrnet.get(1));
					}
				}
				else if(a.getNets().get(2).getMac().equals(corrnet.get(1).getMac())){
					one=comper(a.getNets().get(2),corrnet.get(1));
					if(a.getNets().get(1).getMac().equals(corrnet.get(2).getMac())){
						two=comper(a.getNets().get(1),corrnet.get(2));
						three=comper(a.getNets().get(0),corrnet.get(0));
					}else {
						two=comper(a.getNets().get(0),corrnet.get(2));
						three=comper(a.getNets().get(2),corrnet.get(0));
					}
				}
				else if(a.getNets().get(2).getMac().equals(corrnet.get(2).getMac())){
					one=comper(a.getNets().get(2),corrnet.get(2));
					if(a.getNets().get(1).getMac().equals(corrnet.get(1).getMac())){
						two=comper(a.getNets().get(1),corrnet.get(1));
						three=comper(a.getNets().get(0),corrnet.get(0));
					}else {
						two=comper(a.getNets().get(0),corrnet.get(1));
						three=comper(a.getNets().get(1),corrnet.get(0));
					}
				}
				else if(a.getNets().get(2).getMac().equals(corrnet.get(0).getMac())){
					one=comper(a.getNets().get(2),corrnet.get(0));
					if(a.getNets().get(1).getMac().equals(corrnet.get(2).getMac())){
						two=comper(a.getNets().get(1),corrnet.get(2));
						three=comper(a.getNets().get(0),corrnet.get(1));
					}else {
						two=comper(a.getNets().get(0),corrnet.get(2));
						three=comper(a.getNets().get(1),corrnet.get(1));
					}
				}
				else if(a.getNets().get(0).getMac().equals(corrnet.get(1).getMac())){
					one=comper(a.getNets().get(0),corrnet.get(1));
					if(a.getNets().get(2).getMac().equals(corrnet.get(2).getMac())){
						two=comper(a.getNets().get(2),corrnet.get(2));
						three=comper(a.getNets().get(1),corrnet.get(0));
					}else {
						two=comper(a.getNets().get(1),corrnet.get(2));
						three=comper(a.getNets().get(2),corrnet.get(0));
					}
				}
				else if(a.getNets().get(0).getMac().equals(corrnet.get(2).getMac())){
					one=comper(a.getNets().get(0),corrnet.get(2));
					if(a.getNets().get(2).getMac().equals(corrnet.get(1).getMac())){
						two=comper(a.getNets().get(2),corrnet.get(1));
						three=comper(a.getNets().get(1),corrnet.get(0));
					}else {
						two=comper(a.getNets().get(1),corrnet.get(1));
						three=comper(a.getNets().get(2),corrnet.get(0));
					}
				}
				else if(a.getNets().get(0).getMac().equals(corrnet.get(0).getMac())){
					one=comper(a.getNets().get(0),corrnet.get(0));
					if(a.getNets().get(2).getMac().equals(corrnet.get(2).getMac())){
						two=comper(a.getNets().get(2),corrnet.get(2));
						three=comper(a.getNets().get(1),corrnet.get(1));
					}else {
						two=comper(a.getNets().get(1),corrnet.get(2));
						three=comper(a.getNets().get(2),corrnet.get(1));
					}
				}
				else{
					one=comper(a.getNets().get(1),corrnet.get(1));
					two=comper(a.getNets().get(2),corrnet.get(2));
					three=comper(a.getNets().get(0),corrnet.get(0));
				}
				//adding the pi section in the exel:  
				Data.getNetworks().get(i).setWeight(one*two*three);
			}
			else if(corrnet.size()==2&&a.getNets().size()==2){
				if(a.getNets().get(0).getMac().equals(corrnet.get(0).getMac())){
					one=comper(a.getNets().get(0),corrnet.get(0));
					two=comper(a.getNets().get(1),corrnet.get(1));
				}
				else if(a.getNets().get(0).getMac().equals(corrnet.get(1).getMac())){
					one=comper(a.getNets().get(0),corrnet.get(1));
					two=comper(a.getNets().get(1),corrnet.get(0));

				}
				else if(a.getNets().get(1).getMac().equals(corrnet.get(0).getMac())){
					one=comper(a.getNets().get(1),corrnet.get(0));
					two=comper(a.getNets().get(0),corrnet.get(1));
				}
				else if(a.getNets().get(1).getMac().equals(corrnet.get(1).getMac())){
					one=comper(a.getNets().get(1),corrnet.get(1));
					two=comper(a.getNets().get(1),corrnet.get(0));

				}
				else{
					one=comper(a.getNets().get(1),corrnet.get(1));
					two=comper(a.getNets().get(0),corrnet.get(0));
				}
				Data.getNetworks().get(i).setWeight(one*two);
			}
			else{
				int j=0;
				boolean flag=true;
				while(flag &&j<=(corrnet.size()-1)){
					if (a.getNets().get(0).getMac().equals(corrnet.get(j).getMac())){
						one=comper(a.getNets().get(0),corrnet.get(j));
						flag=false;
					}
					j++;
				}
				if (flag) one=comper(a.getNets().get(0),corrnet.get(0));
				Data.getNetworks().get(i).setWeight(one);
			}
		}
		//there is comparator for the weights to sort by there value and to take 3 best:
		Data.getNetworks().sort(comper);;
		arr[0]=Data.getNetworks().get(0);
		arr[1]=Data.getNetworks().get(1);
		arr[2]=Data.getNetworks().get(2);
		//here I checked if the sorting actually worked and to an impact- its looks like its not
		//really had any effect to the result
		//	System.out.println(arr[0].getWeight());
		//  System.out.println(arr[1].getWeight());
		//	System.out.println(arr[2].getWeight());
		//	System.out.println();

		//sending to function that gives me the final location for the line
		ans=weight(arr);

		return ans;
	}

	//calculating pi
	private double comper(Network comp,Network data){
		int diff=0;
		if(-120<data.getSign()){
			diff=Math.max(3,Math.abs(Math.abs(comp.getSign())-Math.abs(data.getSign())));
		}else diff=100;
		double weight=(norm/(Math.pow(diff,sig_diff )*Math.pow(comp.getSign(),power )));
		//System.out.println(weight+" "+diff+" "+comp.getSign());
		return weight;

	}
	//calculating the final point with the 3 networks that have the highest weight
	private Point3D weight(A_Point a[]){
		Point3D point1=new Point3D();
		Point3D point2=new Point3D();
		Point3D point3=new Point3D();
		Point3D ans=new Point3D();
		point1.setLat(a[0].getLocation().getLat()*a[0].getWeight());
		point2.setLat(a[1].getLocation().getLat()*a[1].getWeight());
		point3.setLat(a[2].getLocation().getLat()*a[2].getWeight());
		point1.setLon(a[0].getLocation().getLon()*a[0].getWeight());
		point2.setLon(a[1].getLocation().getLon()*a[1].getWeight());
		point3.setLon(a[2].getLocation().getLon()*a[2].getWeight());
		point1.setAlt(a[0].getLocation().getAlt()*a[0].getWeight());
		point2.setAlt(a[1].getLocation().getAlt()*a[1].getWeight());
		point3.setAlt(a[2].getLocation().getAlt()*a[2].getWeight());
		double sumWeight=a[0].getWeight()+a[1].getWeight()+a[2].getWeight();
		ans.setLat((point1.getLat()+point2.getLat()+point3.getLat())/sumWeight);
		ans.setLon((point1.getLon()+point2.getLon()+point3.getLon())/sumWeight);
		ans.setAlt((point1.getAlt()+point2.getAlt()+point3.getAlt())/sumWeight);
		return ans;
	}

}
