package main.java.dataBase;
/**
 * @author Isabella Oren
 * @author Arbel Nathan
 *
 */

public class Network {
	/**
	 * @category this class represents a network.
	 */
	private String Ssid,Mac;
	private double freq;
	private int sign;
	
	/**
	 * 
	 * @return ssid
	 */
	public String getSsid() {
		return Ssid;
	}
	/**
	 * @category sets ssid
	 * @param ssid
	 */
	public void setSsid(String ssid) {
		Ssid = ssid;
	}
	/**
	 * 
	 * @return mac
	 */
	public String getMac() {
		return Mac;
	}
	/**
	 * @category sets mac
	 * @param mac
	 */
	public void setMac(String mac) {
		Mac = mac;
	}
	/**
	 * 
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
	 * 
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
	
}
