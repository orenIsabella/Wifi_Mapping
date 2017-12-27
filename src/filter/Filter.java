package filter;

import java.io.Serializable;

public interface Filter extends Serializable{ 
	
	public void filter();
	public void setFlag(boolean flag);

}
