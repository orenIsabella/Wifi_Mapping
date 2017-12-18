package dataBase;


public class Network {
	private String Ssid,Mac;
	private double freq;
	private int sign;
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
	
}
