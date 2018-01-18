package main.java.assignment;

import java.io.Serializable;

/**
 * @author Arbel Nathan
 * @author Isabella Oren
 * @category represents a Point
 *
 */
public class Point3D implements Serializable {
	private double Lat,Lon,Alt;
/**
 * @category constructor for Point3D
 * @param lat
 * @param lon
 * @param alt
 */
	public Point3D(double lat, double lon, double alt) {
		super();
		this.Lat = lat;
		this.Lon = lon;
		this.Alt = alt;
	}

	/**
	 * @category default constructor
	 */
	public Point3D() {
		this.Lat = -4000;
		this.Lon = -4000;
		this.Alt = -4000;
	}

	/**
	 * @category copy constructor
	 * @param a
	 */
	public Point3D(Point3D a) {
		super();
		this.Lat = a.Lat;
		this.Lon = a.Lon;
		this.Alt = a.Alt;
	}

	/**
	 * @category get lat
	 * @return lat
	 */
	public double getLat() {
		return Lat;
	}
/**
 * @category setLat
 * @param lat
 */
	public void setLat(double lat) {
		this.Lat = lat;
	}
	/**
	 * @category get lon
	 * @return lon
	 */
	public double getLon() {
		return Lon;
	}
	/**
	 * @category setLon
	 * @param lon
	 */
	public void setLon(double lon) {
		this.Lon = lon;
	}
	/**
	 * @category get alt
	 * @return alt
	 */
	public double getAlt() {
		return Alt;
	}
	/**
	 * @category setAlt
	 * @param alt
	 */
	public void setAlt(double alt) {
		this.Alt = alt;
	}
/**
 * @category checks if the points are equal
 * @param a
 * @return true or false
 */
	public boolean equals(Point3D a){
		if(
				this.Alt==a.Alt&&
				this.Lat==a.Lat&&
				this.Lon==a.Lon
				)
		{
			return true;
		}
		else return false;
	}

	@Override
	/**
	 * @category toString
	 */
	public String toString() {
		return "Lat=" + Lat + ", Lon=" + Lon + ", Alt=" + Alt ;
	}
	
}
