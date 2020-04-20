package GUI;

import People.*;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class NewPerson {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAttribute;
	private String type;
	private HashMap<Integer, Person> list;

	/**
	 * Launch frame for "Doctor" or "Patient" based on String parameter
	 * @param type
	 */
	public static void addPersonFrame(String type, HashMap<Integer, Person> list) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPerson window = new NewPerson(type, list);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * When we initialize this object we take in a pointer to the listModel that our JList from HomeMenu uses to display our Person objects
	 */
	public NewPerson(String type, HashMap<Integer, Person> list) {
		this.type = type;
		this.list = list;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(160, 70, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		//displays text based on the type
		txtAttribute = new JTextField();
		if(type.equalsIgnoreCase("Patient")) {
			txtAttribute.setText("Condition");
		}
		else if(type.equalsIgnoreCase("Doctor")) {
			txtAttribute.setText("Specialty");
		}
		txtAttribute.setBounds(160, 100, 130, 26);
		frame.getContentPane().add(txtAttribute);
		txtAttribute.setColumns(10);
		
		//Adds Doctor/Patient with given information to respective list
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type.equalsIgnoreCase("Doctor")){
					// Add a new DoctorNode to the listModel
					DoctorNode temp = new DoctorNode(txtName.getText(), txtAttribute.getText());
					list.put(temp.getIDNumber(), temp);
				}
				else if (type.equalsIgnoreCase("Patient")){
					// Add a new PatientNode to the listModel
					PatientNode temp = new PatientNode(txtName.getText(), txtAttribute.getText());
					list.put(temp.getIDNumber(), temp);
				}
				frame.dispose();
			}
		});
		btnAdd.setBounds(102, 150, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		//closes frame
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(221, 150, 117, 29);
		frame.getContentPane().add(btnCancel);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
