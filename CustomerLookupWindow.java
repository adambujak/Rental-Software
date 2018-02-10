import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class CustomerLookupWindow{ 
	static JTextField phoneNumber;
	public static void run (){   

		JFrame frame = new JFrame("");  


		frame.setVisible(true);  
		frame.setSize(700,700);  
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  


		int x = frame.getWidth()/2;  
		int y = frame.getHeight()/2;  

		JPanel panel = new JPanel();  
		frame.add(panel);  
		panel.setLayout(null);  


		String textMessage = "Enter Phone Number Below";  
		Font font = new Font("Calibri", Font.PLAIN, 25);  
		JLabel textLabel = new JLabel(textMessage);  
		textLabel.setFont(font);  
		panel.add(textLabel);  
		textLabel.setBounds(x-140,y-200,750,30); 

		phoneNumber = new JTextField();  
		panel.add(phoneNumber);  

		phoneNumber.setBounds(x-100,y-110,200,30); 


		JButton button = new JButton("Search");  
		panel.add(button);  
		button.setBounds(x-55,y+60,100,50);

		button.addActionListener (new Action1());  




	} 
	static class Action1 implements ActionListener {          
		public void actionPerformed (ActionEvent e) {       
			String s_phone = phoneNumber.getText();
			boolean validNumber = true;
			try{
				long n = Long.parseLong(s_phone);
			}

			catch(NumberFormatException f){
				JOptionPane.showMessageDialog(null, "Please enter valid phone number.", "Video Rental", JOptionPane.PLAIN_MESSAGE);
				validNumber = false; 
			}
			if (validNumber){
				
				int customer = SearchArray.search(window.customers, s_phone);
				String firstName = window.customers[customer][0];
				


			}



		}  

	}}