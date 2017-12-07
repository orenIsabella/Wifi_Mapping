package assignment;

public class Algo1 {
	
	All_Networks nets;
	static double[][] strongest=new double[4][4];
	
	public static void findStrongestFour(All_Networks nets, String mac) {
		int counter=0,counterForNets=1;
		boolean end=false;
		Network currentNet=nets.getNetworks().get(0);
		while(counter<4 && end==false) {
			if(currentNet.getMac().equals(mac)) {
				strongest[counter][0]=currentNet.getSign();
				strongest[counter][1]=currentNet.getAlt();
				strongest[counter][2]=currentNet.getLon();
				strongest[counter][3]=currentNet.getLat();
				counter++;
			}
			currentNet=nets.getNetworks().get(counterForNets);
			counterForNets++;
			if(nets.getNetworks().size()==(counterForNets+1))
				end=true;
		}
		putinorder();
		while (end==false) {
			if(nets.getNetworks().size()==(counterForNets+1))
				end=true;
			if(currentNet.getSign()>strongest[0][0])
				addBigger(currentNet.getSign(), currentNet.getAlt(), currentNet.getLon(), currentNet.getLat());
			currentNet=nets.getNetworks().get(counterForNets);
			counterForNets++;
			if(nets.getNetworks().size()==(counterForNets+1))
				end=true;
		}
		
	}
	
	public static void putinorder() {
		int tempSign;
		double tempAlt, tempLon, tempLat;
		for(int i=0; i<4;i++)
			for(int j=i; j<4;j++) {
				if(strongest[j][0]>strongest[i][0]) {
					tempSign=(int) strongest[i][0];
					tempAlt=strongest[i][1];
					tempLon=strongest[i][2];
					tempLat=strongest[i][3];
					strongest[i][0]=strongest[j][0];
					strongest[i][1]=strongest[j][1];
					strongest[i][2]=strongest[j][2];
					strongest[i][3]=strongest[j][3];
					strongest[j][0]=tempSign;
					strongest[j][1]=tempAlt;
					strongest[j][2]=tempLon;
					strongest[j][3]=tempLat;
					
				}
			}
		
	}
	
	public static void addBigger(int sign, double alt, double lon, double lat) {
		boolean stillLooking=true;
		for(int i=0; i<4 && stillLooking ;i++)
			if(sign>strongest[i][0]) {
				stillLooking=false;
				strongest[i][0]=sign;
				strongest[i][1]=alt;
				strongest[i][2]=lon;
				strongest[i][3]=lat;
			}
				
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
