package dataBase;

import java.util.ArrayList;

public class Networks {
private ArrayList<A_Point> Networks=new ArrayList<A_Point>();

public void AddFromInput(String path){
	Output2Networks a=new Output2Networks();
	a.add(path, Networks);
}

public ArrayList<A_Point> getNetworks() {
	return Networks;
}

}