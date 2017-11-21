package assignment;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class CreateKML {
	public static void main(String[] args) throws FileNotFoundException {
	Kml kml = KmlFactory.createKml();
	String text = "2011-10-02 18:48:05";
	Timestamp ts = Timestamp.valueOf(text);
	Placemark p = KmlFactory.createPlacemark();
	p.setName("uno");
	p.setVisibility(true);
	p.setOpen(false);
	p.createAndSetTimeStamp().addToTimeStampSimpleExtension(ts);
	p.createAndSetPoint().addToCoordinates(32.957366,34.143567);
	Placemark p2 = KmlFactory.createPlacemark();
	p2.setName("dos");
	p2.setVisibility(true);
	p2.setOpen(false);
	p2.createAndSetTimeStamp().addToTimeStampSimpleExtension(ts);
	p2.createAndSetPoint().addToCoordinates(31.957366,33.143567);
	de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument().withName("MyMarkers");
	kml.setFeature(doc);
	kml.marshal(new File("C:/Users/Isabella Oren/Desktop/Htest2.kml"));
	}
	
/*
	private static List<ArrayList<String>> currentcsv=new ArrayList<ArrayList<String>> ();



	public static void main(String[] args) {
		toKML();
	}
		public static void toKML() {
		String csvFile = "C:/Users/arbel/Desktop/test2.csv";
		BufferedReader br = null;
		//next string is line
		String l = "";
		//next string is the sign for us to split
		String split = ",";
		try {
			br = new BufferedReader(new FileReader(csvFile));
			
			// thw while works as long as we have something to read from in the array list
			while ((l = br.readLine()) != null) {
				List<String> in = Arrays.asList(l.split(split));
				ArrayList<String> inner=new ArrayList<String>(in);
				//שולח לפונקציה שבודקת אם בשורה יש תא ריק או הסימן & שמשגע
				//את הקובץ kml
				if(checkValid(inner))
					currentcsv.add(inner);
			}
			//creating a kml file for the data filtered by the id:
			//if we want to use a filter we need to change the next string:
			String filter="id";
			changeByFilter(filter, currentcsv);

			FileWriter writer2 = new FileWriter("C:/Users/arbel/Desktop/test3.kml");
			String kmlstart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>   ";
			String kmlstart2="<kml xmlns=\"http://earth.google.com/kml/2.0\">   ";
			String kmlstart3="<Document>   ";
			writer2.write(kmlstart+"\n");
			writer2.write(kmlstart2+"\n");
			writer2.write(kmlstart3+"\n");
			String placment="<Placemark>  ";
			String closeplacement="</Placemark>";
			for(int k=1; k<currentcsv.size(); k++)
			{
				writer2.write(placment+"\n");
				writer2.write("<name>"+currentcsv.get(k).get(1)+"</name>"+"\n");
				// העתקתי את התבנית לתיאור מקובץ קיי-אמ-אל מוכן ועכשיו הוא נותן את כל השדות הפרטיים של הנטוורק הראשון
				writer2.write("<description>"+"BSSID: <b>"+currentcsv.get(k).get(6)+"</b><br/>Mac: <b>"+currentcsv.get(k).get(7)+"</b><br/>Frequency: <b>"+currentcsv.get(k).get(8)+"</b><br/>signal: <b>"+currentcsv.get(k).get(9)+"</b></description>\n");
				//השדות כאן היו מבולבלים, רק סידרתי לפי הטבלה הסופית שלנו
				writer2.write("<Point><coordinates>"+currentcsv.get(k).get(3)+","+currentcsv.get(k).get(2)+","+currentcsv.get(k).get(4)+"</coordinates></Point>"+"\n");
				writer2.write(closeplacement+"\n");
			}
			String kmlclose2="</Document>";
			String kmlclose3="</kml>";
			writer2.write(kmlclose2+"\n");
			writer2.write(kmlclose3+"\n");
			writer2.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	private static void changeByFilter(String filter, List<ArrayList<String>> currentcsv2) {
			// TODO Auto-generated method stub
			
		}
	public static boolean checkValid(ArrayList<String> arr){
		boolean flag =true;
		for(int i=0;i<arr.size();i++){
			String check=arr.get(i);
			if(check==""||check.contains("&")){
				flag=false;
			}
		}

		return flag;
	}
	*/
}