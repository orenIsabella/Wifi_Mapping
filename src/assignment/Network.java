package assignment;

public class Network {
private String Time,Id,Ssid,Mac;
private double lot,lon,alt,freq,sign;

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
public double getLot() {
	return lot;
}
public void setLot(double lot) {
	this.lot = lot;
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
public double getSign() {
	return sign;
}
public void setSign(double sign) {
	this.sign = sign;
}

}
