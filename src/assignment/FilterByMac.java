package assignment;

public class FilterByMac {
	
	//All_Networks nets=new All_Networks("ScanInput");
	
	public void filter(String mac,All_Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(!(nets.getNetworks().get(place).getMac().equals(mac))) {
				nets.getNetworks().remove(place);
				place--;
			}
			place++;
		}
		
	}
	

}
