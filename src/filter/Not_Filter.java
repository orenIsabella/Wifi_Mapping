package filter;

import java.io.Serializable;

import dataBase.Networks;

public class Not_Filter implements Serializable{

	private Filter a;

	public Not_Filter(Filter a) {
		this.a = a;
	}

	public void  not(Networks nets) {
		a.setFlag(false);
		a.filter(nets);

	}

}
