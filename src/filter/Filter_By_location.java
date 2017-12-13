package filter;

import assignment.All_Networks;
import assignment.Point3D;
/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_Location filters the data we received by the Location wanted.
 */
public class Filter_By_location {
	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * 
	 * @category This function filters the data we have in nets by the point we receive.
	 * 
	 * @param point
	 * @param nets
	 * 
	 */
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
