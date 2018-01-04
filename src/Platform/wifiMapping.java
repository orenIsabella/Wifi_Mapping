package Platform;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

import algorithems.Algo2;
import assignment.CreateKML;
import assignment.ToCsv;
import dataBase.Networks;
import dataBase.toArrayList;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;

public class wifiMapping {

	private JFrame frame;
	protected Networks net;
	public String custom;
	protected String destinationFolder;
	public int filtersUsed;
	protected int files;
	private int devices;
	private JTextField textField;
	private JTextField txtMin;
	private JTextField txtMax;
	private JTextField txtMinLat;
	private JTextField txtMaxLat;
	private JTextField txtMinLon;
	private JTextField txtMaxLon;
	private JTextField textField_1;


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

	/**
	 * Create the application.
	 */
	public wifiMapping() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 844, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAddFoldersName = new JButton("Add Folder");
		btnAddFoldersName.setForeground(new Color(0, 0, 0));
		btnAddFoldersName.setBackground(new Color(153, 204, 204));
		btnAddFoldersName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				String folderName = null;
				JOptionPane.showInputDialog("Please enter the folders file", folderName);
				net.addFromInput(folderName);
				
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
				net.addFromWiggle(csvFileName);
			}
		});
		btnNewButton.setBounds(22, 95, 167, 37);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				net.deleteAllData();
				
			}
		});
		btnNewButton_1.setBackground(new Color(153, 204, 204));
		btnNewButton_1.setBounds(22, 165, 167, 37);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Save to CSV");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to save all our database to a combined csv file
				String destinationFolder="";
				toArrayList help=new toArrayList(destinationFolder, net);
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
				CreateKML n=new CreateKML(net,destinationFolder);
			}
		});
		btnSaveToKml.setBackground(new Color(153, 204, 204));
		btnSaveToKml.setBounds(22, 279, 167, 37);
		frame.getContentPane().add(btnSaveToKml);

		JButton btnShowData = new JButton("Show Data");
		btnShowData.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				//we need to print/show the data we have in this format: 
				//filters used, how many files, how many devices.
				files=net.size();
			Component parentComponent;
				//	devices=net.getNetworks().
				JOptionPane.showConfirmDialog(parentComponent, "the amount of filters used is: "+ filtersUsed + "There are "+ files+" files. "+"There are "+ devices+ " devices. ");
			}
		});
		btnShowData.setBackground(new Color(153, 204, 204));
		btnShowData.setBounds(22, 334, 167, 37);
		frame.getContentPane().add(btnShowData);

		JButton btnUndoTheFilter = new JButton("Undo the filter");
		btnUndoTheFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//here we need to undo the last filter
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
			}
		});
		btnSavefilter.setBackground(new Color(204, 204, 255));
		btnSavefilter.setBounds(211, 165, 175, 98);
		frame.getContentPane().add(btnSavefilter);

		JButton btnAlgo = new JButton("Algo1");
		btnAlgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mac = null;
				JOptionPane.showInputDialog("Please enter the device name you want to filter the data by", mac);
				//here we need to show the algo1 results (lon lat alt) for the mac we recieved
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
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(418, 118, 36, 29);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(418, 202, 36, 29);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(418, 302, 36, 29);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(418, 437, 36, 29);
		frame.getContentPane().add(radioButton_3);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(472, 102, 29, 30);
		frame.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(472, 125, 115, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		
		JCheckBox chckbxUse = new JCheckBox("");
		chckbxUse.setBounds(588, 118, 36, 37);
		frame.getContentPane().add(chckbxUse);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(594, 194, 36, 37);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(607, 294, 36, 37);
		frame.getContentPane().add(checkBox_1);
		
		JLabel lblUploadFromSaved = new JLabel("upload from saved files");
		lblUploadFromSaved.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUploadFromSaved.setBounds(472, 407, 140, 29);
		frame.getContentPane().add(lblUploadFromSaved);
		
		textField_1 = new JTextField();
		textField_1.setBounds(474, 437, 123, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
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
		
			}
		});
		btnApply.setBackground(new Color(255, 255, 153));
		btnApply.setBounds(660, 313, 134, 161);
		frame.getContentPane().add(btnApply);
		
		JEditorPane dtrpnTheData = new JEditorPane();
		dtrpnTheData.setText("The Data");
		dtrpnTheData.setBounds(211, 279, 175, 92);
		frame.getContentPane().add(dtrpnTheData);
	}
}
