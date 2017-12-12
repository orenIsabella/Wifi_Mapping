package assignment;

public class Algo1 {
	
	
	
	static String wantedMac="";
	
	public static Point3D algo1() {
		Point3D w=new Point3D();
		All_Networks nets=new All_Networks("ScanInput");
		FilterByMac filtered=new FilterByMac();
		filtered.filter(wantedMac, nets);
		Signal_Comp2 comp= new Signal_Comp2();
		nets.getNetworks().sort(comp);
		double mone=0.0;
		double mechane=0.0;
		for(int i=0; i<nets.size(); i++) {
			double koved=1/(nets.getNetworks().get(i).getSign()*nets.getNetworks().get(i).getSign());
			mone+=nets.getNetworks().get(i).getLocation().getAlt() *koved;
			mechane+=koved;			
		}
		w.setAlt((mone/mechane));
		
		mone=0.0;
		mechane=0.0;
		for(int i=0; i<nets.size(); i++) {
			double koved=1/(nets.getNetworks().get(i).getSign()*nets.getNetworks().get(i).getSign());
			mone+=nets.getNetworks().get(i).getLocation().getLon() *koved;
			mechane+=koved;			
		}
		w.setLon((mone/mechane));
		
		mone=0.0;
		mechane=0.0;
		for(int i=0; i<nets.size(); i++) {
			double koved=1/(nets.getNetworks().get(i).getSign()*nets.getNetworks().get(i).getSign());
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
