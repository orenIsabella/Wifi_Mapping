package dataBase;

import java.util.ArrayList;

import assignment.Point3D;
/**
 * 
 * @author Isabella Oren
 * @author Arbel Nathan
 * 
 *@category This class represents a Point.
 *
 */
public class A_Point {

	private ArrayList<Network> nets=new ArrayList<Network>();
	private String Time,ID;
	private double weight;
	private Point3D location=new Point3D();
	/**
	 * 
	 * @return nets
	 */
	public ArrayList<Network> getNets() {
		return nets;
	}
	/**
	 * @category sets nets
	 * @param nets
	 */
	public void setNets(ArrayList<Network> nets) {
		this.nets = nets;
	}
	/**
	 * 
	 * @return time
	 */
	public String getTime() {
		return Time;
	}
	/**
	 * @category sets time
	 * @param time
	 */
	public void setTime(String time) {
		Time = time;
	}
	/**
	 * 
	 * @return id
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @category sets id
	 * @param iD
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * 
	 * @return location
	 */
	public Point3D getLocation() {
		return location;
	}
	/**
	 * @category sets location
	 * @param location
	 */
	public void setLocation(Point3D location) {
		this.location = location;
	}
	/**
	 * 
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @category sets weight
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public boolean equals(A_Point a) {
		if(a.getID()==this.ID&&
				a.getLocation()==this.location&&
				a.getTime()==this.Time)
			return true;
		else return false;
	}

}
