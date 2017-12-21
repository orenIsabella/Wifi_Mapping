package algorithems;

import assignment.Point3D;

public class MacPoint {
private String Mac;
private Point3D location=new Point3D();

public String getMac() {
	return Mac;
}
public void setMac(String mac) {
	Mac = mac;
}
public Point3D getLocation() {
	return location;
}
public void setLocation(Point3D location) {
	this.location = location;
}
@Override
public String toString() {
	return "MacPoint [Mac=" + Mac + ", location=" + location + "]";
}


}
