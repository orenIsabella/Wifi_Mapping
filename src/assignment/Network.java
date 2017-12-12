package assignment;

public class Network {
private String Time,Id,Ssid,Mac;
private double freq;
private int sign;
private Point3D location=new Point3D();
public String getTime() {
	return Time;
}
public void setTime(String time) {
	Time = time;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getSsid() {
	return Ssid;
}
public void setSsid(String ssid) {
	Ssid = ssid;
}
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
public double getFreq() {
	return freq;
}
public void setFreq(double freq) {
	this.freq = freq;
}
public int getSign() {
	return sign;
}
public void setSign(int sign) {
	this.sign = sign;
}

@Override
public String toString() {
	return "Network [Time=" + Time + ", Id=" + Id + ", Ssid=" + Ssid + ", Mac=" + Mac + ", freq=" + freq + ", sign="
			+ sign + ", location=" + location + "]";
}

}
