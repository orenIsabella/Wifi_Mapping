package tests.java;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.java.dataBase.Networks;

public class Wigle2NetworksTest {

	@Test
	public void testAdd() {
		Networks test=new Networks();
		test.addFromWiggle("test");
		if(test.size()!=5) fail("Not added all APs "+test.size());
		if(test.getNetworks().get(0).getNets().size()>10) fail("too many nets in AP");
	}

}
