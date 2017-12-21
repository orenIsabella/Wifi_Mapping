package assignment;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *@category time comparator
 *
 */

public class Time_Comparator implements Comparator<Network>  {

	@Override
	public int compare(Network arg0, Network arg1) {
		String [] data0=arg0.getTime().split(" ");
		String [] data1=arg1.getTime().split(" ");
		int ans= data0[0].compareTo(data1[0]);
		if(ans==0)
			ans=data0[1].compareTo(data1[1]);
		return ans;
	}
	
	
	

}
