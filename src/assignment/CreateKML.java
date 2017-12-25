package assignment;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Predicate;

import javax.print.Doc;

import dataBase.Networks;
import dataBase.toArrayList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 * @author Arbel Nathan
 * @author Isabella Oren
 *
 *@category creates a KML
 */
public class CreateKML {
	private  String Id ="";
	private  Double Lat =0.0;
	private  Double Lon =0.0;
	private  Double Alt =0.0;
	private String dest;
	private Networks nets;
	/**
	 * @category constructor
	 * @param nets
	 * @param dest
	 */
	public CreateKML(Networks nets, String dest) {
		this.dest = dest;
		this.nets = nets;
	}

	//creates a KML file with a timeline
	/**
	 * @category creates a KML file with a timeline
	 */
	public void createTheKmlFile() {
		toArrayList b=new toArrayList("ScanInput/csvKML.csv",nets);
		b.toCSV();
		final Kml kml=new Kml();
		de.micromata.opengis.kml.v_2_2_0.Document doc = kml.createAndSetDocument();
		try {
			
			FileReader filereader = new FileReader("ScanInput/csvKML.csv");
			BufferedReader br = new BufferedReader(filereader);
			String line;
			//the first line in the file is not relevant thats why we read it and then dont use it but override it.
			line = br.readLine();
			line = br.readLine();
			List <String> neededLine= Arrays.asList(line.split(","));
			String time = neededLine.get(0);
			String id = neededLine.get(1);
			String lat = neededLine.get(2);
			String lon = neededLine.get(3);
			String alt = neededLine.get(4);

			while(line != null){
				Id= id;
				Lat = Double.parseDouble(lat);
				Lon = Double.parseDouble(lon);
				Alt = Double.parseDouble(alt);
				List <String> theDataArray= Arrays.asList(line.split(","));
				time = theDataArray.get(0);
				id = theDataArray.get(1);
				lat = theDataArray.get(2);
				lon = theDataArray.get(3);
				alt = theDataArray.get(4);
				time = time.replace(' ','T');
				time = time+'Z';
				Placemark place = KmlFactory.createPlacemark();
				place.createAndSetTimeStamp().withWhen(time);
				String location=lon+","+lat+","+alt;

				doc.createAndAddPlacemark().withName(Id).withTimePrimitive(place.getTimePrimitive())
				.createAndSetPoint().addToCoordinates(location);

				line = br.readLine();
			}
			line = br.readLine();
			line = br.readLine();
			br.close();
			filereader.close();
			kml.marshal(new File(dest));
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

}