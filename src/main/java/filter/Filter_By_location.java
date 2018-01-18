package main.java.filter;

import main.java.assignment.Point3D;
import main.java.dataBase.Networks;

/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_Location filters the data we received by the Location wanted.
 */
public class Filter_By_location implements Filter {
	private boolean flag=true;
	private Point3D pointmin;
	private Point3D pointmax;



	public Filter_By_location(Point3D pointmin ,Point3D pointmax) {
		this.pointmin = pointmin;
		this.pointmax=pointmax;
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
	public void filter(Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(flag) {
				if(nets.getNetworks().get(place).getLocation().getLat()<pointmin.getLat()||
						nets.getNetworks().get(place).getLocation().getLon()<pointmin.getLon()||
						nets.getNetworks().get(place).getLocation().getLat()>pointmax.getLat()||
						nets.getNetworks().get(place).getLocation().getLon()>pointmax.getLon()){
					nets.getNetworks().remove(place);
					place--;
				}
			}
			else {
				if(nets.getNetworks().get(place).getLocation().getLat()>pointmin.getLat()||
						nets.getNetworks().get(place).getLocation().getLon()>pointmin.getLon()||
						nets.getNetworks().get(place).getLocation().getLat()<pointmax.getLat()||
						nets.getNetworks().get(place).getLocation().getLon()<pointmax.getLon()) {
					nets.getNetworks().remove(place);
					place--;
				}
			}
			place++;
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;

	}
}
