package filter;

import java.io.Serializable;

import dataBase.Networks;

public interface Filter extends Serializable{ 
	
	public void filter(Networks Data);
	public void setFlag(boolean flag);

}
