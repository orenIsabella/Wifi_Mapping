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
	private Networks nets;

	
	
	public Filter_By_Time(String time, Networks nets) {
		this.time = time;
		this.nets = nets;
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
	public void filter() {
		int place=0;
		while(place<nets.size()) {
			if(flag&&!(nets.getNetworks().get(place).getTime().matches(time))) {
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

	

