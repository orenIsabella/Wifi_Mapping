package assignment;

import java.util.ArrayList;
import java.util.List;

public class All_Networks {
	private ArrayList<Network> Networks=new ArrayList<Network>();

	
public All_Networks(String SourceFile) {
	CsvToArray a=new CsvToArray();
	a.csvToArray(SourceFile);
	Networks=a.getNets();
	}
public ArrayList<Network> getNetworks() {
	return Networks;
}
public int size(){
	return Networks.size();
}

}

