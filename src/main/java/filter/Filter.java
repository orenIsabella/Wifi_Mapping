package main.java.filter;

import java.io.Serializable;

import main.java.dataBase.Networks;

public interface Filter extends Serializable{ 
	
	public void filter(Networks Data);
	public void setFlag(boolean flag);

}
