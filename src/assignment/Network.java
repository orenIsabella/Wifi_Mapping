package assignment;

public class Network {
private String Time,Id,Ssid,Mac;
private double lat,lon,alt,freq;
private int sign;
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
public double getLat() {
	return lat;
}
public void setLat(double lot) {
	this.lat = lot;
}
public double getLon() {
	return lon;
}
public void setLon(double lon) {
	this.lon = lon;
}
public double getAlt() {
	return alt;
}
public void setAlt(double alt) {
	this.alt = alt;
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
	return "Network [Time=" + Time + ", Id=" + Id + ", Ssid=" + Ssid + ", Mac=" + Mac + ", lat=" + lat + ", lon=" + lon
			+ ", alt=" + alt + ", freq=" + freq + ", sign=" + sign + "]";
}

}
