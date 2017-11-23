package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import assignment.ToCsv;

public class ToCsvTest {

	@Test
	public void testToCSV() {
		ToCsv Ans=new ToCsv();
		Ans.toCSV("ScanInput","ScanInput/csvCheck.csv");
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
