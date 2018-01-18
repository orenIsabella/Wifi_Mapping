package tests.java;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.java.dataBase.Networks;
import main.java.filter.Filter_By_ID;

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
