package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import assignment.ScanOrder;

public class Final_orderTest {

	@Test
	public void testFinal_order() {
		ScanOrder Array=new ScanOrder();
		Array.final_order("ScanInput");
		ArrayList<ArrayList<String>> test=Array.getFinal_Networks();
		for(int i=0;i<test.size()-1;i++){
			ArrayList<String> checkedLine=test.get(i);
			for(int j=i+1;j<test.size();j++){
				ArrayList<String> currentLine=test.get(j);
				if(currentLine.get(0)==checkedLine.get(0)
						&&currentLine.get(1)==checkedLine.get(1))
					fail("i: "+i+" j: " +j+" Same point!");
				if(checkedLine.size()>46)
					fail("too long line!!");
			}
		}	
		
	}

}
