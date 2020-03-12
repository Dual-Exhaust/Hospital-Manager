package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class NewVisit {

	private JFrame frame;
	private JTextField txtCondition;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void addVisitFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewVisit window = new NewVisit();
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
	public NewVisit() {
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(102, 150, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		//closes pop up window
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(221, 150, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(221, 61, 130, 27);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(89, 61, 130, 27);
		frame.getContentPane().add(comboBox_1);
		
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