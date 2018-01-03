package filter;

import dataBase.Networks;

public class And_Filter implements Filter {

	private Filter a;
	private Filter b;
	private boolean flag=true; 

	public And_Filter(Filter a, Filter b) {
		this.a = a;
		this.b = b;

	}


	@Override
	public void filter(Networks Data) {
		if(flag) {
			a.filter(Data);
			b.filter(Data);
		}
		//de-morgan
		else {
			Not_Filter g=new Not_Filter(a);
			Not_Filter w=new Not_Filter(b);
			Or_Filter h=new Or_Filter(g, w);
			h.filter(Data);
		}
	}

	@Override
	public void setFlag(boolean flag) {
		this.flag=flag;

	}
}
