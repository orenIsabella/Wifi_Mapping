package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *@category this class filteres the data
 *
 */
public class Filter {
/**
 * @category filters the data by the given filter 
 * @param filter
 * @param currentcsv
 * @param theFilter
 */
	private static void changeByFilter(String filter, List<ArrayList<String>> currentcsv, String theFilter){
		if(filter.equals("id")){
			Predicate<ArrayList<String>> id=s -> s.get(1).contains(theFilter);
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,id);
			currentcsv=afterFilter;
			//System.out.println(afterFilter.size());
		}
		if(filter.equals("time")){
			Predicate<ArrayList<String>> time=s -> s.get(0).contains(theFilter);
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,time);	
			currentcsv=afterFilter;
		}
		if(filter.equals("location")){
			Predicate<ArrayList<String>> location=s -> s.get(1).contains(theFilter);
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,location);	
			currentcsv=afterFilter;
		}

	}
	/**
	 *@category filteres the data by the filter given
	 * @param data
	 * @param term
	 * @return out
	 */
	private static List<ArrayList<String>> filterby(List<ArrayList<String>> data, Predicate<ArrayList<String>> term)
	{
		
		List<ArrayList<String>> out=new ArrayList<ArrayList<String>>(); 
		
		for(int i=1; i<data.size(); i++)
		{
			System.out.println("v");
			if(term.test(data.get(i))==true)
			{
				out.add(data.get(i));
			}
		}
		return out;


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
