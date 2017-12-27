package filter;

import dataBase.Networks;
/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 * @category The class Filter_By_ID filters the data we received by the ID wanted.
 */
public class Filter_By_ID implements Filter{
	private boolean flag=true;
	private String ID;
	private Networks nets;
	
	
	public Filter_By_ID(String iD, Networks nets) {
		super();
		ID = iD;
		this.nets = nets;
	}

	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * 
	 * @category This function filters the data we have in nets by the ID we receive.
	 * 
	 * @param ID
	 * @param nets
	 * 
	 */
	public void filter() {
		int place=0;
		while(place<nets.size()) {
			if(flag&&!(nets.getNetworks().get(place).getID().matches(ID))) {
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
 