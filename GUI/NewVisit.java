package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import People.DoctorNode;
import People.PatientNode;
import People.Person;
import People.VisitNode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class NewVisit {

	private JFrame frame;
	private JTextField txtCondition;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private HashMap<Integer, Person> personList;
	private HashMap<Integer, VisitNode> visitList;

	/**
	 * Launch the application.
	 */
	public static void addVisitFrame(HashMap<Integer, Person> personList, HashMap<Integer, VisitNode>visitList) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewVisit window = new NewVisit(personList, visitList);
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
	public NewVisit(HashMap<Integer, Person> personList, HashMap<Integer, VisitNode> visitList) {
		this.personList = personList;
		this.visitList = visitList;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		frame.getContentPane().setLayout(null);
		
		txtCondition = new JTextField();
		txtCondition.setText("Condition");
		txtCondition.setBounds(160, 100, 130, 26);
		frame.getContentPane().add(txtCondition);
		txtCondition.setColumns(10);
		
		//closes pop up window
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(221, 150, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		comboBox = new JComboBox<PatientNode>();
		comboBox.setBounds(221, 61, 130, 27);
		
		comboBox_1 = new JComboBox<DoctorNode>();
		comboBox_1.setBounds(89, 61, 130, 27);
		for(Person p:personList.values()) {
			if(p instanceof PatientNode) {
				comboBox.addItem(p);
			}
			else if(p instanceof DoctorNode) {
				comboBox_1.addItem(p);
			}
		}
		frame.getContentPane().add(comboBox);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientNode tempPatient = (PatientNode)comboBox.getSelectedItem();
				DoctorNode tempDoctor = (DoctorNode)comboBox_1.getSelectedItem();
				VisitNode newNode = new VisitNode(tempPatient, tempDoctor, txtCondition.getText());
				visitList.put(newNode.getIDNumber(), newNode);
				tempPatient.addVisit(newNode.getIDNumber());
				tempDoctor.addVisit(newNode.getIDNumber());
				frame.dispose();
				
			}
		});
		btnAdd.setBounds(102, 150, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(102, 44, 61, 16);
		frame.getContentPane().add(lblDoctor);
		
		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setBounds(229, 44, 61, 16);
		frame.getContentPane().add(lblPatient);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
