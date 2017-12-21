package assignment;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Arbel Nathan
 * @author Isabella Oren
 * @category All_Networks
 *
 */
public class All_Networks {
	private ArrayList<Network> Networks=new ArrayList<Network>();

/**
 * @category creates a Networks field from the source file	
 * @param SourceFile
 */
public All_Networks(String SourceFile) {
	CreateNets a=new CreateNets();
	a.CreateN(SourceFile);
	Networks=a.getNets();
	}
/**
 * 
 * @return Networks
 */
public ArrayList<Network> getNetworks() {
	return Networks;
}
/**
 * 
 * @return size of networks
 */
public int size(){
	return Networks.size();
}

}

