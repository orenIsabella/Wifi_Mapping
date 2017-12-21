package assignment;
/**
 * @author Arbel Nathan
 * @author Isabella Oren
 * @category represents a network
 *
 */
public class Network {
private String Time,Id,Ssid,Mac;
private double freq;
private int sign;
private Point3D location=new Point3D();

/**
 * @category getTime
 * @return time
 */
public String getTime() {
	return Time;
}
/**
 * @category sets Time
 * @param time
 */
public void setTime(String time) {
	Time = time;
}

/**
 * @category getId
 * @return Id
 */
public String getId() {
	return Id;
}
/**
 * @category sets Id
 * @param Id
 */
public void setId(String id) {
	Id = id;
}
/**
 * @category getSsid
 * @return Ssid
 */
public String getSsid() {
	return Ssid;
}
/**
 * @category sets Ssid
 * @param ssid
 */
public void setSsid(String ssid) {
	Ssid = ssid;
}
/**
 * @category get Mac
 * 
 *   @return Mac
 */
public String getMac() {
	return Mac;
}
/**
 * @category sets Mac
 * @param mac
 */
public void setMac(String mac) {
	Mac = mac;
}
/**
 * @category getLocation
 * @return location
 */
public Point3D getLocation() {
	return location;
}
/**
 * @category sets Location
 * @param location
 */
public void setLocation(Point3D location) {
	this.location = location;
}
/**
 * @category getFreq
 * @return freq
 */
public double getFreq() {
	return freq;
}
/**
 * @category sets freq
 * @param freq
 */
public void setFreq(double freq) {
	this.freq = freq;
}
/**
 * @category getSign
 * @return sign
 */
public int getSign() {
	return sign;
}
/**
 * @category sets sign
 * @param sign
 */
public void setSign(int sign) {
	this.sign = sign;
}


/**
 * @category toString
 */
@Override
public String toString() {
	return "Network [Time=" + Time + ", Id=" + Id + ", Ssid=" + Ssid + ", Mac=" + Mac + ", freq=" + freq + ", sign="
			+ sign + ", location=" + location + "]";
}

}
