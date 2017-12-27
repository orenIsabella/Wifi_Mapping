package filter;

import java.io.Serializable;

import dataBase.Networks;

public class Not_Filter implements Serializable{

	public void  not(Filter a,Networks nets) {
		a.setFlag(false);
		a.filter(nets);
		
	}
	
}
