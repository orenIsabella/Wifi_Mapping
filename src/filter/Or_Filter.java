package filter;

import java.io.Serializable;

import dataBase.Networks;

public class Or_Filter implements Serializable{

	private Filter a, b;

	public Or_Filter(Filter a, Filter b) {
		this.a = a;
		this.b = b;
	}

	public void  Or(Networks nets) {
		Networks temp1=new Networks(nets);
		Networks temp2=new Networks(nets);
		Networks temp3=new Networks();
		a.filter(temp1);
		b.filter(temp2);
		temp3.getNetworks().addAll(temp1.getNetworks());
		temp3.getNetworks().addAll(temp2.getNetworks());
		nets=temp3;
	}
}
