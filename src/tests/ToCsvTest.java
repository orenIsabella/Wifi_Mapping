package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import assignment.ToCsv;

public class ToCsvTest {

	@Test
	public void testToCSV() {
		ArrayList<ArrayList<String>> test=new ArrayList<ArrayList<String>>();
		ArrayList<String> test2=new ArrayList<String>();
		test2.add(":-)");
		test.add(test2);
		ToCsv Ans=new ToCsv("ScanInput\\csvCheck.csv",test);
		Ans.toCSV();
		File destfolder=new File("ScanInput");
		File[] list_of_files=destfolder.listFiles();
		boolean check=true;
		for(int i=0;i<list_of_files.length;i++)
			if(list_of_files[i].getPath().equals("ScanInput\\csvCheck.csv"))
				check=false;
		if(check)
		fail("csv file not caeted");
	}

}
