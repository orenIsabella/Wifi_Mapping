package tests.java;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.java.dataBase.Networks;

public class Output2NetworksTest {

	@Test
	public void testAdd() {
		Networks test=new Networks();
		test.addFromInput("test/testcomplete.csv");
		if(test.size()!=9) fail("Not added all APs "+test.size());	
	}

}
