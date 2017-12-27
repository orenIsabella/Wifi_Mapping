package filter;

import dataBase.Networks;

/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_Time filters the data we received by the time wanted.
 */
public class Filter_By_Time implements Filter {

	private boolean flag=true;
	private String time;




	public Filter_By_Time(String time) {
		this.time = time;

	}

	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * 
	 * @category This function filters the data we have in nets by the time we receive.
	 * 
	 * @param time
	 * @param nets
	 * 
	 */
	public void filter(Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(flag) {
				if(!(nets.getNetworks().get(place).getTime().matches(time))) {
					nets.getNetworks().remove(place);
					place--;
				}
			}
			else {
				if((nets.getNetworks().get(place).getTime().matches(time))) {
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



