package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
	private static void changeByFilter(String filter, List<ArrayList<String>> currentcsv){
		if(filter.equals("id")){
			Predicate<ArrayList<String>> id=s -> s.get(1).contains("OnePlus3T");
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,id);
			currentcsv=afterFilter;
			//System.out.println(afterFilter.size());
		}
		if(filter.equals("time")){
			Predicate<ArrayList<String>> time=s -> s.get(0).contains("00:00");
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,time);	
			currentcsv=afterFilter;
		}
		if(filter.equals("location")){
			Predicate<ArrayList<String>> location=s -> s.get(1).contains("London");
			List<ArrayList<String>> afterFilter=filterby(currentcsv ,location);	
			currentcsv=afterFilter;
		}

	}
	private static List<ArrayList<String>> filterby(List<ArrayList<String>> data, Predicate<ArrayList<String>> term)
	{
		
		List<ArrayList<String>> out=new ArrayList<ArrayList<String>>(); 
		
		for(int i=1; i<data.size(); i++)
		{
			System.out.println("v");
			if(term.test(data.get(i))==false)
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
