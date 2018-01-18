package tests.java;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import main.java.assignment.CreateKML;
import main.java.dataBase.Networks;

public class CreateKMLTest {

	@Test
	public void testCreateKML() {
		Networks test=new Networks();
		test.addFromInput("test/testcomplete.csv");
		CreateKML kml =new CreateKML(test, "test/KMLtest.kml");
		kml.createTheKmlFile();
		File destfolder=new File("test");
		File[] list_of_files=destfolder.listFiles();
		boolean check=true;
		for(int i=0;i<list_of_files.length;i++)
			if(list_of_files[i].getPath().equals("test/KMLtest.kml"))
				check=false;
		if(check)
		fail("kml file not caeted");
	}

}
