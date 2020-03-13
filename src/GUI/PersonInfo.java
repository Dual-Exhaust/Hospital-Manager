package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import People.DoctorNode;
import People.PatientNode;
import People.PersonNode;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonInfo {

	private JFrame frame;
	private PersonNode person;

	/**
	 * Launches frame to display the data of PersonNode object
	 * @param p
	 */
	public static void personInfoFrame(PersonNode p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonInfo window = new PersonInfo(p);
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
	public PersonInfo(PersonNode person) {
		this.person = person;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(298, 30, 246, 302);
		frame.getContentPane().add(list);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(40, 30, 246, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblVisits = new JLabel("Visits");
		lblVisits.setBounds(298, 6, 61, 16);
		frame.getContentPane().add(lblVisits);
		
		//takes user back to home menu and closes current menu
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(94, 273, 117, 29);
		frame.getContentPane().add(btnClose);
		
		//generates labels based on PersonNode type
		if(person instanceof PatientNode) {
			JLabel lblCondition = new JLabel("Condition: ");
			lblCondition.setBounds(40, 120, 246, 16);
			frame.getContentPane().add(lblCondition);
		}
		else if(person instanceof DoctorNode) {
			JLabel lblSpecialty = new JLabel("Specialty: ");
			lblSpecialty.setBounds(40, 120, 246, 16);
			frame.getContentPane().add(lblSpecialty);
		}
		
		frame.setBounds(100, 100, 550, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
