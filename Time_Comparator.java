package assingment;
import java.util.ArrayList;
import java.util.Comparator;




public class Time_Comparator implements Comparator<ArrayList<String>>  {

	@Override
	public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
		String [] data0=arg0.get(0).split(" ");
		String [] data1=arg1.get(0).split(" ");
		int ans= data0[0].compareTo(data1[0]);
		if(ans==0)
			ans=data0[1].compareTo(data1[1]);
		return ans;
	}
	
	
	

}
