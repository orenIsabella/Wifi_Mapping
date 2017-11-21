package assingment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests {
	public static void main(String[] args)  {

		//List<String> list;
		//list=Arrays.asList(test_comp4);
		//ArrayList<String> arr2=new ArrayList<String>(list);
		//System.out.println("arr2: "+arr2.toString());

		//making pretending lines
		String test_comp="-40;8;5;8";
		String test_comp2="-70;8;8;8";
		String test_comp5="-20;8;8;8";
		//turn the lines into arrays
		List<String> test_comp3=Arrays.asList(test_comp.split(";"));
		String[] test_comp4=test_comp2.split(";");
		String[] test_comp6=test_comp5.split(";");
		ArrayList<String> arr2=new ArrayList<>(test_comp3);
		
		ArrayList<String> arr3=new ArrayList<>(test_comp3);
		//System.out.println(arr2.get(0).toString());
		//arr2.clear();
		System.out.println(arr2.toString());
		if(arr2==null){}
		
		/*
		ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
		//adding the arrays to arraylist
		arr.add(arr2);
		arr.add(arr3);
		//arr.add(test_comp4);
		//arr.add(test_comp6);
		//System.out.println(""+arr.get(1));
		//sorting the array by signal
		//arr.sort(COMP_By_SIGNAL);
		arr.get(0).remove(2);
		//System.out.println(arr.get(0));
		//System.out.println(Arrays.toString(arr.get(0)));

		File test_file=new File("C:\\Users\\arbel\\Desktop\\wifi");
		String[] test=test_file.list();
		File[] test2=test_file.listFiles();
		//System.out.println(test2[0].getPath());
		test_file.delete();
		//System.out.println(Arrays.toString(test));
		
		List<String> test1000 =arr3;
		String a=String.join(",", test1000);
		System.out.println(a);
		 PrintWriter pw=null;;
	        try {
	            pw = new PrintWriter(new File("test.csv"));
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        StringBuilder sb = new StringBuilder();
	        sb.append("id");
	        sb.append(',');
	        sb.append("Name");
	        sb.append('\n');

	        sb.append("1");
	        sb.append(',');
	        sb.append("Prashant Ghimire");
	        sb.append('\n');
	
	        pw.write(test_comp5);
	        pw.close();
	        System.out.println(arr2.toString());
		*/
	}
}
