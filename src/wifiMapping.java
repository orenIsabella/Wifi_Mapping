import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

import algorithems.Algo2;
import dataBase.Networks;

public class wifiMapping {

	private JFrame frame;

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
		frame.setBounds(100, 100, 639, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAddFoldersName = new JButton("Add Folder");
		btnAddFoldersName.setForeground(new Color(0, 0, 0));
		btnAddFoldersName.setBackground(new Color(153, 204, 204));
		btnAddFoldersName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				String folderName = null;
				JOptionPane.showInputDialog("Please enter the folders file", folderName);
				//here we need to add the files in the folder we recieved to out database
			}
		});
		btnAddFoldersName.setBounds(22, 24, 167, 43);
		frame.getContentPane().add(btnAddFoldersName);

		JButton btnNewButton = new JButton("Add CSV");
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String csvFileName = null;
				JOptionPane.showInputDialog("Please enter the folders file", csvFileName);
				//here we need to add the file csvFileName we recieved to out database
			}
		});
		btnNewButton.setBounds(22, 91, 167, 37);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to delete all the database we have
			}
		});
		btnNewButton_1.setBackground(new Color(153, 204, 204));
		btnNewButton_1.setBounds(22, 152, 167, 37);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Save to CSV");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to save all our database to a combined csv file
			}
		});
		btnNewButton_2.setBackground(new Color(153, 204, 204));
		btnNewButton_2.setBounds(22, 210, 167, 37);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnSaveToKml = new JButton("Save to KML");
		btnSaveToKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to save all our database to a combined KML file
			}
		});
		btnSaveToKml.setBackground(new Color(153, 204, 204));
		btnSaveToKml.setBounds(22, 267, 167, 37);
		frame.getContentPane().add(btnSaveToKml);

		JButton btnShowData = new JButton("Show Data");
		btnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//we need to print/show the data we have in this format: 
				//filters used, how many files, how many devices.
			}
		});
		btnShowData.setBackground(new Color(153, 204, 204));
		btnShowData.setBounds(22, 322, 167, 37);
		frame.getContentPane().add(btnShowData);

		JButton btnFilterByTime = new JButton("Filter by Time");
		btnFilterByTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String min = null;
				JOptionPane.showInputDialog("Please enter the minimum time you want to filter from", min);
				String max = null;
				JOptionPane.showInputDialog("Please enter the maximum time you want to filter to", max);
				//here we need to add a filter from min to max on our database
			}
		});
		btnFilterByTime.setBackground(new Color(204, 204, 255));
		btnFilterByTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFilterByTime.setBounds(211, 27, 175, 48);
		frame.getContentPane().add(btnFilterByTime);

		JButton btnFilterByLocation = new JButton("Filter by Location");
		btnFilterByLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String minlat = null;
				JOptionPane.showInputDialog("Please enter the minimum lat you want to filter from", minlat);
				String maxlat = null;
				JOptionPane.showInputDialog("Please enter the maximum lat you want to filter to", maxlat);
				String minlon = null;
				JOptionPane.showInputDialog("Please enter the minimum lat you want to filter from", minlon);
				String maxlon = null;
				JOptionPane.showInputDialog("Please enter the maximum lat you want to filter to", maxlon);
				String minalt = null;
				JOptionPane.showInputDialog("Please enter the minimum lat you want to filter from", minalt);
				String maxalt = null;
				JOptionPane.showInputDialog("Please enter the maximum lat you want to filter to", maxalt);
				//here we need to add a filter from min to max on our database
			}
		});
		btnFilterByLocation.setBackground(new Color(204, 204, 255));
		btnFilterByLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFilterByLocation.setBounds(211, 91, 175, 48);
		frame.getContentPane().add(btnFilterByLocation);

		JButton btnFilterByDevice = new JButton("Filter by Device");
		btnFilterByDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deviceName = null;
				JOptionPane.showInputDialog("Please enter the device name you want to filter the data by", deviceName);
				//here we need to add a filter by the deviceName we recieved
			}
		});
		btnFilterByDevice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFilterByDevice.setBackground(new Color(204, 204, 255));
		btnFilterByDevice.setBounds(211, 163, 175, 43);
		frame.getContentPane().add(btnFilterByDevice);

		JButton btnUndoTheFilter = new JButton("Undo the filter");
		btnUndoTheFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to undo the last filter
			}
		});
		btnUndoTheFilter.setBackground(new Color(204, 204, 255));
		btnUndoTheFilter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUndoTheFilter.setBounds(211, 228, 175, 37);
		frame.getContentPane().add(btnUndoTheFilter);

		JButton btnSavefilter = new JButton("Save Filter");
		btnSavefilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to update our database and save it by the filter
			}
		});
		btnSavefilter.setBackground(new Color(204, 204, 255));
		btnSavefilter.setBounds(211, 279, 175, 37);
		frame.getContentPane().add(btnSavefilter);

		JButton btnCreateFilter = new JButton("Create Filter");
		btnCreateFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we need to add an option to create a filter by using and or not
			}
		});
		btnCreateFilter.setBackground(new Color(204, 204, 255));
		btnCreateFilter.setBounds(211, 334, 175, 37);
		frame.getContentPane().add(btnCreateFilter);

		JButton btnAlgo = new JButton("Algo1");
		btnAlgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mac = null;
				JOptionPane.showInputDialog("Please enter the device name you want to filter the data by", mac);
				//here we need to show the algo1 results (lon lat alt) for the mac we recieved
			}
		});
		btnAlgo.setBackground(new Color(255, 204, 255));
		btnAlgo.setBounds(408, 47, 167, 125);
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
		btnAlgo_1.setBounds(408, 199, 167, 137);
		frame.getContentPane().add(btnAlgo_1);
	}
}
