package filter;

import assignment.All_Networks;

public class Filter_By_Time {

	public void filter(String time,All_Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(!(nets.getNetworks().get(place).getTime().equals(time))) {
				nets.getNetworks().remove(place);
				place--;
			}
			place++;
		}

	}


}
