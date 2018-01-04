package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataBase.Networks;
import filter.Filter_By_ID;

public class Filter_By_IDTest {

	@Test
	public void test() {
		Networks test=new Networks();
		test.addFromInput("test/testcomplete.csv");
		 Filter_By_ID filt=new Filter_By_ID("OnePlus3T");
		 filt.filter(test);
		 if(test.size()!=4) fail("filter is bad");	
		
	}

}
