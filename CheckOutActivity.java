import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckOutActivity {
	static JTextField itemID;
	static JTextField phoneNumber;
	static JFrame frame;
	public static void run(){
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(700,800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = frame.getWidth()/2;
		int y = frame.getHeight()/2;
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton checkOutButton = new JButton("Check Out");
		panel.add(checkOutButton);
		checkOutButton.setBounds(x-55,y+140,100,50);
		checkOutButton.addActionListener (new Action1());
		JButton exitButton = new JButton("Done");
		panel.add(exitButton);
		exitButton.setBounds(x-55,y+200,100,50);
		exitButton.addActionListener (new Action2());
		itemID = new JTextField();
		panel.add(itemID);
		itemID.setText("");
		itemID.setBounds(x-100,y-150,200,30);
		phoneNumber = new JTextField();
		panel.add(phoneNumber);
		phoneNumber.setText("");
		phoneNumber.setBounds(x-100,y-10,200,30);
		String textMessage = "Item ID";
		Font font = new Font("Calibri", Font.PLAIN, 25);
		JLabel textLabel = new JLabel(textMessage);
		textLabel.setFont(font);
		panel.add(textLabel);
		textLabel.setBounds(x-75,y-200,150,30);
		String textMessage2 = "Customer Phone Number";
		JLabel textLabel2 = new JLabel(textMessage2);
		textLabel2.setFont(font);
		panel.add(textLabel2);
		textLabel2.setBounds(x-200,y-55,400,30);
	}
	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			String s_itemID = itemID.getText().toString();
			String s_phoneNumber = phoneNumber.getText().toString();
			if (s_itemID.equals("")||s_phoneNumber.equals("")){
				JOptionPane.showMessageDialog(null, 
						"Please enter all values", 
						"Video Rental", JOptionPane.PLAIN_MESSAGE);
			}
			else{
				CheckOut.checkOutItem(s_itemID, s_phoneNumber);
				try {
					SortAndOutputCustomers.save(window.customers);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					SortAndOutputItems.save(window.items);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
	static class Action2 implements ActionListener {        
		public void actionPerformed (ActionEvent e) { 
			frame.dispose();
		}
	}
}
