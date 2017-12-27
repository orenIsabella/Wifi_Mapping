package filter;

import assignment.Point3D;
import dataBase.Networks;

/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_Location filters the data we received by the Location wanted.
 */
public class Filter_By_location implements Filter {
	private boolean flag=true;
	private Point3D point;
	private Networks nets;
	
	
	public Filter_By_location(Point3D point, Networks nets) {
		this.point = point;
		this.nets = nets;
	}

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
	public void filter() {
		int place=0;
		while(place<nets.size()) {
			if(flag&&!(nets.getNetworks().get(place).getLocation().equals(point))) {
				nets.getNetworks().remove(place);
				place--;
			}
			place++;
		}
		}

	public void setFlag(boolean flag) {
		this.flag = flag;
	
}
}
