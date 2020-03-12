package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPerson {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAttribute;
	private String type;

	/**
	 * Launch frame for "Doctor" or "Patient" based on String parameter
	 * @param type
	 */
	public static void addPersonFrame(String type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPerson window = new NewPerson(type);
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
	public NewPerson(String type) {
		this.type = type;
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