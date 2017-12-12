package assignment;


import java.util.Comparator;

public class Signal_Comp2 implements Comparator<Network> {

	@Override
	public int compare(Network arg0, Network arg1) {
		int t = Math.abs(arg0.getSign()) - Math.abs(arg0.getSign());
		return t;
	}

}
