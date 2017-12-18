package dataBase;

import java.util.ArrayList;

import assignment.Point3D;

public class A_Point {
private ArrayList<Network> nets=new ArrayList<Network>();
private String Time,ID;
private double weight;
private Point3D location=new Point3D();

public ArrayList<Network> getNets() {
	return nets;
}
public void setNets(ArrayList<Network> nets) {
	this.nets = nets;
}
public String getTime() {
	return Time;
}
public void setTime(String time) {
	Time = time;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public Point3D getLocation() {
	return location;
}
public void setLocation(Point3D location) {
	this.location = location;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}


}
