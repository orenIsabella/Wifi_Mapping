package main.java.filter;

import main.java.dataBase.Networks;

/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_Time filters the data we received by the time wanted.
 */
public class Filter_By_Time implements Filter {

	private boolean flag=true;
	private String timemin;
	private String timemax;






	public Filter_By_Time(String timemin, String timemax) {

		this.timemin = timemin;
		this.timemax = timemax;
	}

	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * 
	 * @category This function filters the data we have in nets by the times we receive.
	 * 
	 * @param time
	 * @param nets
	 * 
	 */
	public void filter(Networks nets) {
		int place=0;
		while(place<nets.size()) {
			String [] time_min=timemin.split(" ");
			String [] time_max=timemax.split(" ");
			String [] data=nets.getNetworks().get(place).getTime().split(" ");
			int min= data[0].compareTo(time_min[0]);
			
			int max= data[0].compareTo(time_max[0]);

			if(min==0)
				min= data[1].compareTo(time_min[1]);
			
			if(max==0)
				max= data[1].compareTo(time_max[1]);
			if(flag) {
				if(min<0||max>0) {
					nets.getNetworks().remove(place);
					place--;
				}
			}
			else {
				if(min>=0||max<=0);
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



