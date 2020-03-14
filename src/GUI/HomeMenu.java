package GUI;

import java.awt.*;
import javax.swing.*;

import People.DoctorNode;
import People.PatientNode;
import People.PersonNode;
import People.Person;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;


public class HomeMenu {

	private JFrame frame;
	private JTextField txtSearch;
	private LinkedList<Person> listModel;
	private JList list;

	/**
	 * Launch home frame
	 */
	public static void homeMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMenu window = new HomeMenu();
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
	public HomeMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 95, 280, 176);
		frame.getContentPane().add(scrollPane);
		
		//creates JList to hold person objects
		listModel = new LinkedList<>();
		listModel.add(new Person("John", "A Person"));
		listModel.add(new Person("Kenny", "From SP"));
		System.out.println(listModel);
		list = new JList(listModel.toArray());
		scrollPane.setViewportView(list);

		//spawns a new pop up frame that presents the data of the selected person object
		//if no object is selected, error message pops up
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!list.isSelectionEmpty()) {
					PersonInfo.personInfoFrame((PersonNode) list.getSelectedValue());
				}
				else {
					//display error message
				}
			}
		});
		btnView.setBounds(303, 60, 117, 29);
		frame.getContentPane().add(btnView);
		
		//user enters text that will search through person objects
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(140, 60, 167, 26);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		frame.setResizable(false);
		frame.setBounds(100, 100, 580, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//saves current data to a text file that will be opened everytime the program runs
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add code to save
			}
		});
		mnFile.add(mntmSave);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		//spawns pop up menu that allows user to fill in doctor data and add them to the list of Doctors
		JMenuItem mntmDoctor = new JMenuItem("Doctor");
		mntmDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//We pass the listModel so we can add a new Person to it
				NewPerson.addPersonFrame("Doctor", listModel);
				/*
				 *This code to update the JList runs too fast, it needs to run after the user clicks 'Add' in the NewPerson window
				 *It makes the JList update on a delay of one because it'll update the last person added when we go to add a new person
				 *Is there a way to listen for when HomeMenu regains focus? Then update the JList after? We dispose the frame when the user clicks add which makes the focus go back to HomeMenu
				 */
				list = new JList(listModel.toArray());
				scrollPane.setViewportView(list);
			}
		});
		mnAdd.add(mntmDoctor);

		//spawns pop up menu that allows user to fill in patient data and add them to the list of Patients
		JMenuItem mntmPatient = new JMenuItem("Patient");
		mntmPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//We pass the listModel so we can add a new Person to it
				NewPerson.addPersonFrame("Patient", listModel);
				/*
				 *This code to update the JList runs too fast, it needs to run after the user clicks 'Add' in the NewPerson window
				 *It makes the JList update on a delay of one because it'll update the last person added when we go to add a new person
				 *Is there a way to listen for when HomeMenu regains focus? Then update the JList after? We dispose the frame when the user clicks add which makes the focus go back to HomeMenu
				 */
				list = new JList(listModel.toArray());
				scrollPane.setViewportView(list);
			}
		});
		mnAdd.add(mntmPatient);
		
		//spawns pop up menu that allows user to fill in Visit data and add them to the list of Visits
		JMenuItem mntmVisit = new JMenuItem("Visit");
		mntmVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewVisit.addVisitFrame();
			}
		});
		mnAdd.add(mntmVisit);
		
		JMenu mnRemove = new JMenu("Remove");
		menuBar.add(mnRemove);
		
		//spawns pop up menu that allows user to select and remove a Doctor from the list of Doctors
		JMenuItem mntmDoctor_1 = new JMenuItem("Doctor");
		mntmDoctor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveFrame.removeFrame("Doctor");
			}
		});
		mnRemove.add(mntmDoctor_1);
		
		//spawns pop up menu that allows user to select and remove a Patient from the list of Patients
		JMenuItem mntmPatient_1 = new JMenuItem("Patient");
		mntmPatient_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveFrame.removeFrame("Patient");
			}
		});
		mnRemove.add(mntmPatient_1);
		
		//spawns pop up menu that allows user to select and remove a Visits from the list of Visits
		JMenuItem mntmVisit_1 = new JMenuItem("Visit");
		mntmVisit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveFrame.removeFrame("Visit");
			}
		});
		mnRemove.add(mntmVisit_1);
	}
}
