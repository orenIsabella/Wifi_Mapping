package tests;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import assignment.CsvToArray;


public class CsvToArrayTest {

	@Test
	public void testCsvToArray() {
		CsvToArray Array=new CsvToArray();
		Array.csvToArray("ScanInput");
		ArrayList<ArrayList<String>> arr_test =Array.getAll_Networks();
		for(int i=1;i<arr_test.size();i++)
			for(int j=0;j<arr_test.get(i).size();j++){
				switch(j){
				case 0:	if(arr_test.get(i).get(j).length()!=19)
					fail("time is not correct");
				continue;
				case 1: if(arr_test.get(i).get(j).contains("&")||arr_test.get(i).get(j).isEmpty())
					fail("ID is bad or missing");
				continue;
				case 2: 
					if(arr_test.get(i).get(j).matches(".*[a-z].*"))
						fail("Lat is bad");
					double lat=Double.parseDouble(arr_test.get(i).get(j));
					if(lat>90||lat<0)
						fail("Lat is bad");
					continue;
				case 3:
					if(arr_test.get(i).get(j).matches(".*[a-z].*"))
						fail("Lon is bad");
					double lon=Double.parseDouble(arr_test.get(i).get(j));
					if(lon>180||lon<0)
						fail("Lon is bad");
					continue;
				case 4:
					if(arr_test.get(i).get(j).matches(".*[a-z].*"))
						fail("Alt is bad");
					continue;
				case 5:
					if(arr_test.get(i).get(j).isEmpty())
						fail("bad SSID");
					continue;
				case 6:
					if(arr_test.get(i).get(j).matches(".*[g-z].*"))
						fail("bad mac-not hexa");
					if(arr_test.get(i).get(j).length()!=17)
						fail("bad mac!");
					continue;
				case 7:
					if(!(arr_test.get(i).get(j).equals("2.4Ghz")||arr_test.get(i).get(j).equals("5Ghz")))
						fail("bad freq");
					continue;
				case 8:
					int signal=Integer.parseInt(arr_test.get(i).get(j));
					if(signal<=-113||signal>=0)
						fail("bad signal");
					continue;
				default:
					fail("too many fields");
				}
			}

	}

}
