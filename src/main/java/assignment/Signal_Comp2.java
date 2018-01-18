package main.java.assignment;


import java.util.Comparator;

import main.java.dataBase.Network;
/**
 * @author Arbel Nathen
 * @author Isabella Oren
 *@category signal comparator for the second assingment
 *
 */
public class Signal_Comp2 implements Comparator<Network> {

	@Override
	public int compare(Network arg0, Network arg1) {
		int t = Math.abs(arg0.getSign()) - Math.abs(arg1.getSign());
		return t;
	}

}
