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


public class CheckInActivity {
	static JTextField itemID;
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
		JButton button = new JButton("Check In");
		panel.add(button);
		button.setBounds(x-55,y+140,100,50);
		button.addActionListener (new Action1());
		itemID = new JTextField();
		panel.add(itemID);
		itemID.setText("");
		itemID.setBounds(x-100,y-150,200,30);
		
		String textMessage = "Item ID";
		Font font = new Font("Calibri", Font.PLAIN, 25);
		JLabel textLabel = new JLabel(textMessage);
		textLabel.setFont(font);
		panel.add(textLabel);
		textLabel.setBounds(x-75,y-200,150,30);
		JButton exitButton = new JButton("Done");
		panel.add(exitButton);
		exitButton.setBounds(x-55,y+220,100,50);
		exitButton.addActionListener (new Action2());
		
	}
	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			String s_itemID = itemID.getText().toString();
			
			if (s_itemID.equals("")){
				JOptionPane.showMessageDialog(null, 
						"Please enter a value!", 
						"Video Rental", JOptionPane.PLAIN_MESSAGE);
			}
			else{
				CheckIn.checkInItem(s_itemID);
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
