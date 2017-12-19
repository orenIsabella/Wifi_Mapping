package algorithems;

import java.util.Comparator;

import dataBase.A_Point;

public class Weight_Comperator implements Comparator<A_Point> {

	@Override
	public int compare(A_Point o1, A_Point o2) {
		int ans = (int)((o2.getWeight()-o1.getWeight())*100);
		return ans;
	}

}
