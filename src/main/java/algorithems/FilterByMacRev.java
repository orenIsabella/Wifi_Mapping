package main.java.algorithems;

import main.java.dataBase.Networks;

/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *
 *@category the class filters by Mac
 */
public class FilterByMacRev {
	
	//All_Networks nets=new All_Networks("ScanInput");
	/**
	 * @category filters the nets by the given mac
	 * @param mac
	 * @param nets
	 */
	public void filter(String mac,Networks nets) {
	for(int i=0;i<nets.size();i++) {
		int place=0;
		while(place<nets.getNetworks().get(i).getNets().size()) {
			if((nets.getNetworks().get(i).getNets().get(place).getMac().equals(mac))) {
				nets.getNetworks().get(i).getNets().remove(place);
				place--;
			}
			place++;
		}
	}
	int place=0;
	while(place<nets.size()) {
		if((nets.getNetworks().get(place).getNets().size()==0)) {
			nets.getNetworks().remove(place);
			place--;
		}
		place++;
	}
	}
	

}
