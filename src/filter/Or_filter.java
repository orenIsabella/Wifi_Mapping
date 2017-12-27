package filter;

import dataBase.Networks;

public class Or_filter {

	public void  Or(Filter a,Filter b,Networks nets) {
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
