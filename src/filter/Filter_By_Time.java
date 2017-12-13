package filter;

import assignment.All_Networks;
/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_Time filters the data we received by the time wanted.
 */
public class Filter_By_Time {

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
