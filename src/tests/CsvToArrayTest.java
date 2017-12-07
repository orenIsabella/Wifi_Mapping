package tests;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import assignment.CsvToArray;
import assignment.Network;


public class CsvToArrayTest {

	@Test
	public void testCsvToArray() {
		CsvToArray Array=new CsvToArray();
		Array.csvToArray("ScanInput");
		ArrayList<Network> arr_test =Array.getNets().getNetworks();

		for(int j=0;j<arr_test.size();j++){

			if(arr_test.get(j).getTime().length()!=19)
				fail("time is not correct");
			if(arr_test.get(j).getId().contains("&")||arr_test.get(j).getId().isEmpty())
				fail("ID is bad or missing");
			double lat=arr_test.get(j).getLat();
			if(lat>90||lat<0)
				fail("Lat is bad");
			double lon=arr_test.get(j).getLon();
			if(lon>180||lon<0)
				fail("Lon is bad");
			double Alt=arr_test.get(j).getAlt();
			if(Alt>2000)
				fail("Alt is bad");
			if(arr_test.get(j).getSsid().isEmpty())
				fail("bad SSID");
			if(arr_test.get(j).getMac().matches(".*[g-z].*"))
				fail("bad mac-not hexa");
			if(arr_test.get(j).getMac().length()!=17)
				fail("bad mac!");
			if(!(arr_test.get(j).getFreq()==2.4||arr_test.get(j).getFreq()==5))
				fail("bad freq");
			int signal=arr_test.get(j).getSign();
			if(signal<=-113||signal>=0)
				fail("bad signal");
		}
	
}

}
