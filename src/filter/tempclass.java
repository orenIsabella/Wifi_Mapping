package filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dataBase.Networks;
import dataBase.toArrayList;

public class tempclass {
	public static void main(String[] args)  {
		Networks a=new Networks();
		a.addFromWiggle("ScanInput");
		
		Filter_By_ID f=new Filter_By_ID("");
		try {
			
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("1.bin"));
			os.writeObject(f);
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			
			ObjectInputStream is=new ObjectInputStream(new FileInputStream("1.bin"));
			Filter_By_ID f2=(Filter_By_ID) is.readObject();
			f2.filter(a);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		toArrayList b=new toArrayList("C:/Users/Isabella Oren/Desktop/elad.csv",a);
		b.toCSV();
	}

	
	
}
