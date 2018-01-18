package tests.java;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.java.assignment.Point3D;
import main.java.dataBase.Networks;
import main.java.filter.Filter_By_location;

public class Filter_By_locationTest {

	@Test
	public void testFilter() {
		Point3D point1=new Point3D(32.16876665,34.81320792,37);
		Point3D point2=new Point3D(32.16876665,34.81320795,37);
		Networks test=new Networks();
		test.addFromInput("test/testcomplete.csv");
		Filter_By_location filt =new Filter_By_location(point1,point2);
		filt.filter(test);
		if(test.size()!=1) fail("filter is bad");	
		
	}

}
