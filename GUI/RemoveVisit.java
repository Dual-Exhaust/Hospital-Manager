package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import People.Person;
import People.VisitNode;

import javax.swing.JList;

public class RemoveVisit {

	private JFrame frame;
	private String type; //use this variable to determine which list to display ("Patient", "Doctor", "Visit")
	private JTextField txtSearch;
	private HashMap<Integer, VisitNode> list;

	/**
	 * Launches window that displays data based on "type" input
	 * @param type
	 */
	public static void removeVisit(String type, HashMap<Integer, VisitNode> list) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveVisit window = new RemoveVisit(type, list);
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
	public RemoveVisit(String type, HashMap<Integer, VisitNode> list) {
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
		
		JList jlist = new JList(list.values().toArray());
		
		//removes selected item from LinkedList
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.remove(((VisitNode) jlist.getModel().getElementAt(jlist.getSelectedIndex())).getIDNumber());
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		btnRemove.setBounds(102, 175, 117, 29);
		frame.getContentPane().add(btnRemove);
		
		//closes pop up window
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(221, 175, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 65, 236, 108);
		frame.getContentPane().add(scrollPane);
		
		//displays options to remove
		scrollPane.setViewportView(jlist);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(135, 38, 175, 26);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
