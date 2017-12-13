package filter;

import assignment.All_Networks;
import assignment.Point3D;

public class Filter_By_location {

	public void filter(Point3D point,All_Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(!(nets.getNetworks().get(place).getLocation().equals(point))) {
				nets.getNetworks().remove(place);
				place--;
			}
			place++;
		}
		
	}
	
	
}
