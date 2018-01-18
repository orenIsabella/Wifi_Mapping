package main.java.algorithems;

import java.util.Comparator;

import main.java.dataBase.A_Point;
/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *
 *@category weight comperator
 */
public class Weight_Comperator implements Comparator<A_Point> {

	@Override
	public int compare(A_Point o1, A_Point o2) {
		int ans = (int)((o2.getWeight()-o1.getWeight())*100);
		return ans;
	}

}
