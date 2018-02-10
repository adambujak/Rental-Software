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


public class AddNewCustomer {
	static JTextField firstName;
	static JTextField lastName;
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
		JButton button = new JButton("Add");
		panel.add(button);
		button.setBounds(x-55,y+180,100,50);
		button.addActionListener (new Action1());
		firstName = new JTextField();
		firstName.setText("");
		panel.add(firstName);
		firstName.setBounds(x-100,y-150,200,30);
		lastName= new JTextField();
		lastName.setText("");
		panel.add(lastName);
		lastName.setBounds(x-100,y-10,200,30);
		phoneNumber= new JTextField();
		phoneNumber.setText("");
		panel.add(phoneNumber);
		phoneNumber.setBounds(x-100,y+60,200,30);
		String textMessage = "First Name";
		Font font = new Font("Calibri", Font.PLAIN, 25);
		JLabel textLabel = new JLabel(textMessage);
		textLabel.setFont(font);
		panel.add(textLabel);
		textLabel.setBounds(x-65,y-200,150,30);
		String textMessage2 = "Last Name";
		JLabel textLabel2 = new JLabel(textMessage2);
		textLabel2.setFont(font);
		panel.add(textLabel2);
		textLabel2.setBounds(x-55,y-55,150,30);
		JLabel textLabel3 = new JLabel("Phone Number");
		textLabel3.setFont(font);
		panel.add(textLabel3);
		textLabel3.setBounds(x-55,y+40,150,30);

	}
	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			String s_firstName = firstName.getText().toString();
			String s_lastName = lastName.getText().toString();
			String s_number = phoneNumber.getText().toString();

			if (s_firstName.equals("")||s_lastName.equals("")||s_number.equals("")){
				JOptionPane.showMessageDialog(null, "Please enter all values", "Video Rental", JOptionPane.PLAIN_MESSAGE);
			}
			else{
				boolean validNumber = true;
				try{
					long any = Long.parseLong(s_number);
				}
				catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Please enter valid phone number.", "Video Rental", JOptionPane.PLAIN_MESSAGE);
					validNumber = false;
				}
				if (validNumber){
					try {
						AddCustomer.write("customers.txt", s_firstName, s_lastName, s_number);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Added!", "Video Rental", JOptionPane.PLAIN_MESSAGE);

					frame.dispose();
				}
			}
		}
	}   
}
