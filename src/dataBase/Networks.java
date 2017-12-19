package dataBase;

import java.util.ArrayList;

public class Networks {
private ArrayList<A_Point> Networks=new ArrayList<A_Point>();


public Networks(Networks networks) {
	Networks = networks.getNetworks();
}
public Networks() {
}
public void addFromInput(String path){
	Output2Networks a=new Output2Networks();
	a.add(path, Networks);
}

public ArrayList<A_Point> getNetworks() {
	return Networks;
}
public int size(){
	return Networks.size();
}

}
