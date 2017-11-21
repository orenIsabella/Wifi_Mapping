package assignment;

import java.util.ArrayList;
import java.util.Comparator;


public class Signal_Comparator implements Comparator<ArrayList<String>> {
	

	
	@Override
	public int compare(ArrayList<String> o1, ArrayList<String> o2) {
			int t = Math.abs(Integer.parseInt(o1.get(3))) - Math.abs(Integer.parseInt(o2.get(3)));
			return t;
	}

}
