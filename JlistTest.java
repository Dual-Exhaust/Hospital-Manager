import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JlistTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JlistTest window = new JlistTest();
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
	public JlistTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Item1");
		myList.add("Item2");
		myList.add("Item3");
		myList.add("Item4");
		myList.add("Item5");
		JList list = new JList(myList.toArray());
		
		
		frame.getContentPane().add(list, BorderLayout.CENTER);
		
		JButton btnPrintSelected = new JButton("Print Selected");
		btnPrintSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(list.getSelectedValue());
			}
		});
		frame.getContentPane().add(btnPrintSelected, BorderLayout.SOUTH);
	}

}
