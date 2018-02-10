import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ItemInfo {
	static JFrame frame;
	static JTextField textLabel;
	static JTextField textLabel1;
	static JTextField textLabel2;
	static JTextField textLabel3;
	static JButton save;
	static JButton button;
	static int g_item;
	public static void run(int item){
		g_item = item;
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(700,400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = frame.getWidth()/2;
		int y = frame.getHeight()/2;
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		button = new JButton("Edit");
		if (window.manager){
			panel.add(button);
		}
		button.setBounds(x-55,y+120,100,50);
		button.addActionListener (new Action1());
		save = new JButton("Save");
		if (window.manager){
			panel.add(save);
		}
		save.setVisible(false);
		save.setBounds(x-55,y+120,100,50);
		save.addActionListener (new Action2());
		
		String title = window.items[item][1];
		String itemNum = window.items[item][0];
		String status= window.items[item][3];
		String phoneNumber = window.items[item][4];
		
		Font font = new Font("Calibri", Font.PLAIN, 12);
		textLabel = new JTextField(title);
		textLabel1 = new JTextField( itemNum );
		textLabel2 = new JTextField(status);
		textLabel3 = new JTextField(phoneNumber);
		boolean inStock = false;
		if (status.equals("in")){
			inStock=true;
		}
		textLabel.setEditable(false);
		textLabel1.setEditable(false);
		textLabel2.setEditable(false);
		textLabel3.setEditable(false);
		textLabel.setFont(font);
		textLabel1.setFont(font);
		textLabel2.setFont(font);
		textLabel3.setFont(font);
		panel.add(textLabel);
		panel.add(textLabel1);
		panel.add(textLabel2);
		if (!inStock){
			panel.add(textLabel3);
		}
		textLabel.setBounds(x-65,y-200,135,20);
		textLabel1.setBounds(x-65,y-160,135,20);
		textLabel2.setBounds(x-65,y-120,135,20);
		textLabel3.setBounds(x-65,y-80,135,20);
		
		//exitButton.addActionListener (new Action2());
		
	}
	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			textLabel.setEditable(true);
			textLabel2.setEditable(true);
			textLabel3.setEditable(true);
			save.setVisible(true);
			button.setVisible(false);
		}
	}   
	static class Action2 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			String title = textLabel.getText().toString();
			String status = textLabel2.getText().toString();
			String customer;
			if (status.equals("in")){
				customer="";
			}
			else{
				customer = textLabel3.getText().toString();
			}
			if (title.equals("")||status.equals("")){
				JOptionPane.showMessageDialog(
						null, "Please Enter Valid Values", 
						"Video Rental", JOptionPane.ERROR_MESSAGE);
			}
			else{
				window.items[g_item][1] = title;
				window.items[g_item][2] = status;
				window.items[g_item][3] = customer;
			}
			//sort and save
			JOptionPane.showMessageDialog(
					null, "Saved", 
					"Video Rental", JOptionPane.PLAIN_MESSAGE);
		}
	}   
}
