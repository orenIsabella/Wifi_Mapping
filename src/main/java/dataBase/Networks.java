package main.java.dataBase;

import java.util.ArrayList;
/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *
 */
public class Networks {
/**
 * @category this class represents networks
 */
	
private ArrayList<A_Point> Networks=new ArrayList<A_Point>();

/**
 * @category a copy constructor
 * @param networks
 */
public Networks(Networks networks) {
	Networks.addAll(networks.getNetworks());
}
/**
 * @category a constuctor
 */
public Networks() {
}
/**
 * @category adds to networks another path
 * @param path
 */
public void addFromInput(String path){
	Output2Networks a=new Output2Networks();
	a.add(path, Networks);
}

public void addFromWiggle(String path){
	Wigle2Networks a=new Wigle2Networks();
	a.add(path, Networks);
}
/**
 * 
 * @return networks
 */

public ArrayList<A_Point> getNetworks() {
	return Networks;
}
/**
 * 
 * @return size of network
 */
public int size(){
	return Networks.size();
}
/**
 * @category deletes all the data 
 */
public void deleteAllData() {
	Networks.clear();
}

}
