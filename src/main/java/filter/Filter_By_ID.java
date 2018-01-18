package main.java.filter;

import main.java.dataBase.Networks;
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


	public Filter_By_ID(String iD) {
		super();
		ID = iD;
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
	public void filter(Networks nets) {
		int place=0;
		while(place<nets.size()) {
			if(flag) {if(!(nets.getNetworks().get(place).getID().matches(ID))) {
				nets.getNetworks().remove(place);
				place--;
			}
			}else {
				if((nets.getNetworks().get(place).getID().matches(ID))) {
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
