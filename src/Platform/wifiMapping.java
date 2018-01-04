package Platform;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import algorithems.Algo1;
import algorithems.Algo2;
import assignment.CreateKML;
import assignment.Point3D;
import dataBase.Networks;
import dataBase.toArrayList;
import filter.And_Filter;
import filter.Filter;
import filter.Filter_By_ID;
import filter.Filter_By_Time;
import filter.Filter_By_location;
import filter.Not_Filter;
import filter.Or_Filter;

public class wifiMapping  extends Thread {

	private  JFrame frame;
	protected Networks net=new Networks();
	protected Networks backup=new Networks();
	public String custom;
	protected String destinationFolder;
	public int filtersUsed;
	protected int files;
	private int devices;
	private JTextField ID;
	private JTextField txtMin;
	private JTextField txtMax;
	private JTextField txtMinLat;
	private JTextField txtMaxLat;
	private JTextField txtMinLon;
	private JTextField txtMaxLon;
	private JTextField uploadFilter;
	private Filter id=null;
	private Filter time=null;
	private Filter location=null;
	private Filter saved=null;
	private Filter toFilter=null;
	private File file;
	private long timeStamp;
	private Thread t1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {



		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wifiMapping window = new wifiMapping();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private boolean isFileUpdated( File file ) {

		if( file.lastModified() != timeStamp ) {
			this.timeStamp = file.lastModified();
			
			//Yes, file is updated
			return true;
		}
		
		//No, file is not updated
		return false;
	}


	/**
	 * Create the application.
	 */
	public wifiMapping() {
		initialize();

	}
	public  void thread_1() {
		file=new File(destinationFolder);
		timeStamp=file.lastModified();
		 t1 = new Thread(new Runnable() {
			public void run() {
				while(frame.isDisplayable()) {
				
					if(isFileUpdated(file)) {
					int a=JOptionPane.showConfirmDialog(null, "your Input folder has been changed,\n would you like to update your database?");
						if(a==0) net.addFromWiggle(destinationFolder);
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
			
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 844, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		if(!frame.isActive())System.out.println("h");
		JLabel DataShow = new JLabel("");
		DataShow.setBounds(211, 250, 175, 92);
		frame.getContentPane().add(DataShow);

		JLabel DataShow2 = new JLabel("");
		DataShow2.setBounds(211, 280, 175, 92);
		frame.getContentPane().add(DataShow2);

		JLabel DataShow3 = new JLabel("");
		DataShow3.setBounds(211, 300, 175, 92);
		frame.getContentPane().add(DataShow3);

		JButton btnAddFoldersName = new JButton("Add Folder");
		btnAddFoldersName.setForeground(new Color(0, 0, 0));
		btnAddFoldersName.setBackground(new Color(153, 204, 204));
		btnAddFoldersName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				destinationFolder=JOptionPane.showInputDialog("Please enter the folders file");
				net.addFromWiggle(destinationFolder);
				backup.getNetworks().addAll(net.getNetworks());
				DataShow.setText(data(1));
				DataShow2.setText(data(2));
				thread_1();
				t1.start();
			}
		});
		btnAddFoldersName.setBounds(22, 28, 167, 43);
		frame.getContentPane().add(btnAddFoldersName);

		JButton btnNewButton = new JButton("Add CSV");
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String csvFileName = null;
				JOptionPane.showInputDialog("Please enter the folders file", csvFileName);
				net.addFromInput(csvFileName);
				backup.getNetworks().addAll(net.getNetworks());
				DataShow.setText(data(1));
				DataShow2.setText(data(2));
			}
		});
		btnNewButton.setBounds(22, 95, 167, 37);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				net.deleteAllData();
				DataShow.setText(data(1));
				DataShow2.setText(data(2));
			}
		});
		btnNewButton_1.setBackground(new Color(153, 204, 204));
		btnNewButton_1.setBounds(22, 165, 167, 37);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Save to CSV");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to save all our database to a combined csv file
				toArrayList help=new toArrayList(destinationFolder+"/a.csv", net);
				help.toCSV();

			}
		});
		btnNewButton_2.setBackground(new Color(153, 204, 204));
		btnNewButton_2.setBounds(22, 226, 167, 37);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnSaveToKml = new JButton("Save to KML");
		btnSaveToKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to save all our database to a combined KML file
				//	toArrayList h=new toArrayList(destinationFolder, net);
				CreateKML n=new CreateKML(net,destinationFolder+"/a.kml");
				n.createTheKmlFile();
			}
		});
		btnSaveToKml.setBackground(new Color(153, 204, 204));
		btnSaveToKml.setBounds(22, 279, 167, 37);
		frame.getContentPane().add(btnSaveToKml);

		//		JButton btnShowData = new JButton("Show Data");
		//		btnShowData.addActionListener(new ActionListener() {
		//
		//
		//			public void actionPerformed(ActionEvent e) {
		//				//we need to print/show the data we have in this format: 
		//				//filters used, how many files, how many devices.
		//				files=net.size();
		//				Component parentComponent;
		//				//	devices=net.getNetworks().
		//				JOptionPane.showConfirmDialog(parentComponent, "the amount of filters used is: "+ filtersUsed + "There are "+ files+" files. "+"There are "+ devices+ " devices. ");
		//			}
		//		});
		//		btnShowData.setBackground(new Color(153, 204, 204));
		//		btnShowData.setBounds(22, 334, 167, 37);
		//		frame.getContentPane().add(btnShowData);

		JButton btnUndoTheFilter = new JButton("Undo the filter");
		btnUndoTheFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to undo the last filter
				net.getNetworks().addAll(backup.getNetworks());
				DataShow.setText(data(1));
				DataShow2.setText(data(2));
			}
		});
		btnUndoTheFilter.setBackground(new Color(204, 204, 255));
		btnUndoTheFilter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUndoTheFilter.setBounds(211, 33, 175, 99);
		frame.getContentPane().add(btnUndoTheFilter);

		JButton btnSavefilter = new JButton("Save Filter");
		btnSavefilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtersUsed++;
				//here we need to update our database and save it by the filter

				ObjectOutputStream os;
				try {
					os = new ObjectOutputStream(new FileOutputStream("1.bin"));
					os.writeObject(toFilter);
					os.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}




			}
		});
		btnSavefilter.setBackground(new Color(204, 204, 255));
		btnSavefilter.setBounds(211, 165, 175, 98);
		frame.getContentPane().add(btnSavefilter);

		JButton btnAlgo = new JButton("Algo1");
		btnAlgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mac = null;
				mac=JOptionPane.showInputDialog("Please enter the mac name you want to filter the data by");
				//here we need to show the algo1 results (lon lat alt) for the mac we recieved
				Algo1 ans=new Algo1(net,mac);
				Point3D point=ans.algo1full();
				JOptionPane.showMessageDialog(null, point.toString());

			}
		});
		btnAlgo.setBackground(new Color(255, 204, 255));
		btnAlgo.setBounds(22, 395, 167, 125);
		frame.getContentPane().add(btnAlgo);

		JButton btnAlgo_1 = new JButton("Algo2");
		btnAlgo_1.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				String option1 = null;
				JOptionPane.showInputDialog("Please enter yes if you want to use this option by entering a string as a line", option1);
				if(option1.equals("yes")){
					String line = null;
					JOptionPane.showInputDialog("Please enter the wanted line", line);
					Algo2 alg2 =new Algo2(net,line);
					alg2.simNets();
				}
				else{
					//	String howmany = null;
					//	JOptionPane.showInputDialog("Please enter how many mac adresses you would like to use (you can use up to 3 macs)", howmany);
					//Component parentComponent;
					//	JOptionPane.showConfirmDialog(parentComponent, "how many mac adressed would you like to use?", title, 3);
					Object[] options = {"1", "2","3"};
					int n = JOptionPane.showOptionDialog(frame, "How many mac adresses would you like to use?", "mac adresses amount",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,	null, options,options[0]); 
					if(n==1){
						String mac1 = null;
						JOptionPane.showInputDialog("Please enter the mac adress", mac1);
						String sig1 = null;
						JOptionPane.showInputDialog("Please enter the signal for the last mac adress", sig1);
						Algo2 alg2 =new Algo2(net,mac1,sig1, null, null, null, null);
						alg2.simNets();
						JOptionPane.showMessageDialog(null, alg2.toString());
					}
					if(n==2){
						String mac1 = null;
						JOptionPane.showInputDialog("Please enter the mac adress", mac1);
						String sig1 = null;
						JOptionPane.showInputDialog("Please enter the signal for the last mac adress", sig1);
						String mac2 = null;
						JOptionPane.showInputDialog("Please enter the mac adress", mac2);
						String sig2 = null;
						JOptionPane.showInputDialog("Please enter the signal for the last mac adress", sig2);
						Algo2 alg2 =new Algo2(net,mac1,sig1, mac2,sig2, null, null);
						alg2.simNets();
						JOptionPane.showMessageDialog(null, alg2.toString());
					}
					if(n==3){
						String mac1 = null;
						JOptionPane.showInputDialog("Please enter the mac adress", mac1);
						String sig1 = null;
						JOptionPane.showInputDialog("Please enter the signal for the last mac adress", sig1);
						String mac2 = null;
						JOptionPane.showInputDialog("Please enter the mac adress", mac2);
						String sig2 = null;
						JOptionPane.showInputDialog("Please enter the signal for the last mac adress", sig2);
						String mac3 = null;
						JOptionPane.showInputDialog("Please enterthe mac adress", mac3);
						String sig3 = null;
						JOptionPane.showInputDialog("Please enter the signal for the last mac adress", sig3);
						Algo2 alg2 =new Algo2(net,mac1,sig1,mac2,sig2, mac3,sig3);
						alg2.simNets();
						JOptionPane.showMessageDialog(null, alg2.toString());
					}
				}

			}
		});
		btnAlgo_1.setBackground(new Color(255, 204, 255));
		btnAlgo_1.setBounds(219, 395, 167, 125);
		frame.getContentPane().add(btnAlgo_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(22, 377, 371, 30);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 537, 371, 2);
		frame.getContentPane().add(separator_1);

		JLabel lblCustomizeTheFilter = new JLabel("Customize the Filter:");
		lblCustomizeTheFilter.setBounds(418, 28, 356, 29);
		frame.getContentPane().add(lblCustomizeTheFilter);

		JLabel lblNot = new JLabel("NOT");
		lblNot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNot.setBounds(414, 69, 36, 29);
		frame.getContentPane().add(lblNot);
		//not id
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(418, 118, 36, 29);
		frame.getContentPane().add(radioButton);
		//not time
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(418, 202, 36, 29);
		frame.getContentPane().add(radioButton_1);
		//not loc
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(418, 302, 36, 29);
		frame.getContentPane().add(radioButton_2);
		//not saved
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(418, 437, 36, 29);
		frame.getContentPane().add(radioButton_3);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(472, 102, 29, 30);
		frame.getContentPane().add(lblId);

		ID = new JTextField();
		ID.setBounds(472, 125, 115, 22);
		frame.getContentPane().add(ID);
		ID.setColumns(10);

		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(472, 173, 104, 29);
		frame.getContentPane().add(lblTime);

		txtMin = new JTextField();
		txtMin.setText("min");
		txtMin.setBounds(472, 197, 56, 34);
		frame.getContentPane().add(txtMin);
		txtMin.setColumns(10);

		txtMax = new JTextField();
		txtMax.setText("max");
		txtMax.setBounds(531, 197, 56, 34);
		frame.getContentPane().add(txtMax);
		txtMax.setColumns(10);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation.setBounds(472, 267, 66, 29);
		frame.getContentPane().add(lblLocation);

		txtMinLat = new JTextField();
		txtMinLat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMinLat.setText("min lat");
		txtMinLat.setBounds(472, 301, 56, 30);
		frame.getContentPane().add(txtMinLat);
		txtMinLat.setColumns(10);

		txtMaxLat = new JTextField();
		txtMaxLat.setText("max lat");
		txtMaxLat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaxLat.setColumns(10);
		txtMaxLat.setBounds(531, 301, 66, 30);
		frame.getContentPane().add(txtMaxLat);

		txtMinLon = new JTextField();
		txtMinLon.setText("min lon");
		txtMinLon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMinLon.setColumns(10);
		txtMinLon.setBounds(472, 342, 56, 30);
		frame.getContentPane().add(txtMinLon);

		txtMaxLon = new JTextField();
		txtMaxLon.setText("max lon");
		txtMaxLon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaxLon.setColumns(10);
		txtMaxLon.setBounds(531, 342, 66, 30);
		frame.getContentPane().add(txtMaxLon);
		//id
		JCheckBox chckbxUse = new JCheckBox("");
		chckbxUse.setBounds(588, 118, 36, 37);
		frame.getContentPane().add(chckbxUse);
		//time
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(594, 194, 36, 37);
		frame.getContentPane().add(checkBox);
		//location
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(607, 294, 36, 37);
		frame.getContentPane().add(checkBox_1);

		JLabel lblUploadFromSaved = new JLabel("upload from saved files");
		lblUploadFromSaved.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUploadFromSaved.setBounds(472, 407, 140, 29);
		frame.getContentPane().add(lblUploadFromSaved);

		uploadFilter = new JTextField();
		uploadFilter.setBounds(474, 437, 123, 30);
		frame.getContentPane().add(uploadFilter);
		uploadFilter.setColumns(10);
		//upload from file
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(607, 437, 36, 37);
		frame.getContentPane().add(checkBox_2);

		JCheckBox chckbxOr = new JCheckBox("OR");
		chckbxOr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxOr.setBounds(640, 167, 71, 37);
		frame.getContentPane().add(chckbxOr);

		JCheckBox chckbxAnd = new JCheckBox("AND");
		chckbxAnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxAnd.setBounds(714, 167, 84, 37);
		frame.getContentPane().add(chckbxAnd);

		JButton btnApply = new JButton("APPLY");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(chckbxUse.isSelected()) {
					Filter_By_ID temp=new Filter_By_ID(ID.getText());
					id =temp;
					toFilter=id;
				
				}
				if( checkBox.isSelected()) {
					System.out.println(txtMin.getText());
					Filter_By_Time temp=new Filter_By_Time(txtMin.getText(),txtMax.getText());
					time =temp;
					toFilter=time;
				}
				if(checkBox_1.isSelected()) {
					Point3D min =new Point3D(Double.parseDouble(txtMinLat.getText()),Double.parseDouble(txtMinLon.getText()),0);
					Point3D max =new Point3D(Double.parseDouble(txtMaxLat.getText()),Double.parseDouble(txtMaxLon.getText()),0);
					Filter_By_location temp=new Filter_By_location(min,max);
					id =temp;
					toFilter=id;

				}
				if(checkBox_2.isSelected()) {
					try {

						ObjectInputStream is=new ObjectInputStream(new FileInputStream("1.bin"));
						saved=(Filter) is.readObject();
						toFilter=saved;

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
				}
				if(radioButton.isSelected()) {
					Not_Filter temp=new Not_Filter(id);
					id=temp;
					toFilter=id;
					System.out.println("v");

				}
				if(radioButton.isSelected()) {
					Not_Filter temp=new Not_Filter(time);
					time=temp;
					toFilter=time;
				}
				if(radioButton.isSelected()) {
					Not_Filter temp=new Not_Filter(location);
					location=temp;
					toFilter=location;
				}
				if(radioButton.isSelected()) {
					Not_Filter temp=new Not_Filter(saved);
					saved=temp;
					toFilter=saved;
				}
				//OR
				if(chckbxOr.isSelected()) {
					if(chckbxUse.isSelected()) {
						if(checkBox.isSelected()) {
							Or_Filter temp =new Or_Filter(id,time);
							toFilter=temp;
							if( checkBox_1.isSelected()) {
								Or_Filter temp2 =new Or_Filter(toFilter,location);
								toFilter=temp2;
								if(checkBox_2.isSelected()) {
									Or_Filter temp3 =new Or_Filter(toFilter,saved);
									toFilter=temp3;
								}
							}
						}
						else if( checkBox_1.isSelected()) {
							Or_Filter temp2 =new Or_Filter(id,location);
							toFilter=temp2;
							if(checkBox_2.isSelected()) {
								Or_Filter temp3 =new Or_Filter(toFilter,saved);
								toFilter=temp3;
							}
						}
						else if(checkBox_2.isSelected()) {
							Or_Filter temp3 =new Or_Filter(id,saved);
							toFilter=temp3;
						}
					}
					else if(checkBox.isSelected()) {
						if(checkBox_1.isSelected()) {
							Or_Filter temp2 =new Or_Filter(time,location);
							toFilter=temp2;
							if(checkBox_2.isSelected()) {
								Or_Filter temp3 =new Or_Filter(toFilter,saved);
								toFilter=temp3;
							}
						}
						else if(checkBox_2.isSelected()) {
							Or_Filter temp3 =new Or_Filter(time,saved);
							toFilter=temp3;
						}
					}
					else if(checkBox_1.isSelected()) {
						if(checkBox_2.isSelected()) {
							Or_Filter temp3 =new Or_Filter(time,saved);
							toFilter=temp3;
						}
					}
				}
				if(chckbxAnd.isSelected()) {
					if(chckbxUse.isSelected()) {
						if(checkBox.isSelected()) {
							And_Filter temp =new And_Filter(id,time);
							toFilter=temp;
							if( checkBox_1.isSelected()) {
								And_Filter temp2 =new And_Filter(toFilter,location);
								toFilter=temp2;
								if(checkBox_2.isSelected()) {
									And_Filter temp3 =new And_Filter(toFilter,saved);
									toFilter=temp3;
								}
							}
						}
						else if( checkBox_1.isSelected()) {
							And_Filter temp2 =new And_Filter(id,location);
							toFilter=temp2;
							if(checkBox_2.isSelected()) {
								And_Filter temp3 =new And_Filter(toFilter,saved);
								toFilter=temp3;
							}
						}
						else if(checkBox_2.isSelected()) {
							And_Filter temp3 =new And_Filter(id,saved);
							toFilter=temp3;
						}
					}
					else if(checkBox.isSelected()) {
						if(checkBox_1.isSelected()) {
							And_Filter temp2 =new And_Filter(time,location);
							toFilter=temp2;
							if(checkBox_2.isSelected()) {
								And_Filter temp3 =new And_Filter(toFilter,saved);
								toFilter=temp3;
							}
						}
						else if(checkBox_2.isSelected()) {
							And_Filter temp3 =new And_Filter(time,saved);
							toFilter=temp3;
						}
					}
					else if(checkBox_1.isSelected()) {
						if(checkBox_2.isSelected()) {
							And_Filter temp3 =new And_Filter(time,saved);
							toFilter=temp3;
						}
					}
				}
				toFilter.filter(net);
				DataShow.setText(data(1));
				DataShow2.setText(data(2));
			}
		});
		btnApply.setBackground(new Color(255, 255, 153));
		btnApply.setBounds(660, 313, 134, 161);
		frame.getContentPane().add(btnApply);
		//		
		//		JEditorPane dtrpnTheData = new JEditorPane();
		//		dtrpnTheData.setText(destinationFolder);
		//		dtrpnTheData.setBounds(211, 279, 175, 92);
		//		frame.getContentPane().add(dtrpnTheData);


	}
	private String data(int i) {
		String ans ="";
		File The_file=new File(destinationFolder);
		File[] filePath=The_file.listFiles();
		if(i==1)
			ans+="files in folder: "+filePath.length+" ";
		if(i==2)
			ans+="# of AP: "+net.size();
		//ans+="filter: "+toFilter.getClass().getCanonicalName()+"\n";
		return ans;

	}

}
