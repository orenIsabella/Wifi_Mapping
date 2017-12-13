package assignment;

public class Point3D {
	private double Lat,Lon,Alt;

	public Point3D(double lan, double lon, double alt) {
		super();
		this.Lat = lan;
		this.Lon = lon;
		this.Alt = alt;
	}

	public Point3D() {
		this.Lat = -4000;
		this.Lon = -4000;
		this.Alt = -4000;
	}

	public Point3D(Point3D a) {
		super();
		this.Lat = a.Lat;
		this.Lon = a.Lon;
		this.Alt = a.Alt;
	}

	public double getLat() {
		return Lat;
	}

	public void setLat(double lat) {
		this.Lat = lat;
	}

	public double getLon() {
		return Lon;
	}

	public void setLon(double lon) {
		this.Lon = lon;
	}

	public double getAlt() {
		return Alt;
	}

	public void setAlt(double alt) {
		this.Alt = alt;
	}

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
}
