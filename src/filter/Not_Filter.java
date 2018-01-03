package filter;

import java.io.Serializable;

import dataBase.Networks;

public class Not_Filter implements Filter{

	private Filter a;
	private boolean flag=false; 
	public Not_Filter(Filter a) {
		this.a = a;
	}


	public void filter(Networks Data) {
		a.setFlag(flag);
		a.filter(Data);

		
	}
//if we doing not to not:
	public void setFlag(boolean flag) {
	if(!this.flag) this.flag=true;
	else this.flag=flag;
	
		
	}

}
