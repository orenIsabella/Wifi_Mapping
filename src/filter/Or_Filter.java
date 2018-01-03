package filter;

import dataBase.Networks;

public class Or_Filter implements Filter{

	private Filter a, b;
	private boolean flag=true; 

	public Or_Filter(Filter a, Filter b) {
		this.a = a;
		this.b = b;
	}


	@Override
	public void filter(Networks Data) {
		if(flag) {
			Networks temp1=new Networks(Data);
			Networks temp2=new Networks(Data);
			Networks temp3=new Networks();
			a.filter(temp1);
			b.filter(temp2);
			System.out.println(temp1.size());
			System.out.println(temp2.size());
			temp3.getNetworks().addAll(temp1.getNetworks());
			temp3.getNetworks().addAll(temp2.getNetworks());
			Data.getNetworks().clear();
			Data.getNetworks().addAll(temp3.getNetworks());
		}
		else {
			Not_Filter g=new Not_Filter(a);
			Not_Filter w=new Not_Filter(b);
			And_Filter f=new And_Filter(g, w);
			f.filter(Data);
		}
	}

	@Override
	public void setFlag(boolean flag) {
		this.flag=flag;


	}
}
