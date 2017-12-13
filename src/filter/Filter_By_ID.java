package filter;

import assignment.All_Networks;

public class Filter_By_ID {

	public void filter(String ID,All_Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(!(nets.getNetworks().get(place).getId().equals(ID))) {
				nets.getNetworks().remove(place);
				place--;
			}
			place++;
		}
		
	}
	
	
}
