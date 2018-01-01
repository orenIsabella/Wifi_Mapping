package filter;

import java.io.Serializable;

import dataBase.Networks;

public class And_Filter implements Serializable {
	
private Filter a;
private Filter b;


public And_Filter(Filter a, Filter b) {
	super();
	this.a = a;
	this.b = b;

}

	public void and(Networks nets) {
		
		a.filter(nets);
		b.filter(nets);
	}
}
