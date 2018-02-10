import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ManagerActivity {
	static JTextField itemID;
	static JFrame frame;
	public static void run(){
		JFrame frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(700,800);
		int x = frame.getWidth()/2;
		int y = frame.getHeight()/2;
		JPanel panel = new JPanel();
		panel.setLayout(null);
		//Manager from here
		JLabel label = new JLabel("Manager");
		JButton employeeAdd = new JButton("Add an Employee");
		panel.add(employeeAdd);
		employeeAdd.setBounds(x-100, 25,200,50);
		//employeeAdd.addActionListener (new Action1());
		
		// to here just copy everything else forEmployeeActivity
		JButton checkOut = new JButton("Check Out Items");
		panel.add(checkOut);
		checkOut.setBounds(x-100, 100,200,50);
		checkOut.addActionListener (new CheckOutAction());
		
		JButton checkIn = new JButton("Check In Items");
		panel.add(checkIn);
		checkIn.setBounds(x-100, 175,200,50);
		checkIn.addActionListener (new CheckInAction());
		
		JButton addCustomer = new JButton("Add a New Customer");
		panel.add(addCustomer);
		addCustomer.setBounds(x-100, 250,200,50);
		addCustomer.addActionListener (new Action1());
		
		JButton searchCustomer = new JButton("Search For a Customer"); //add editing
		panel.add(searchCustomer);
		searchCustomer.setBounds(x-100, 325,200,50);
		searchCustomer.addActionListener (new LookupCustomer());
		
		JButton searchItems = new JButton("Search Inventory");
		panel.add(searchItems);
		searchItems.setBounds(x-100, 400,200,50);
		searchItems.addActionListener(new SearchInventoryAction());
		frame.add(panel);
		panel.add(label);
	}
	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			AddNewCustomer.run();
		}
	}   
	static class CheckOutAction implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			CheckOutActivity.run();
		}
	}   
	static class CheckInAction implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			CheckInActivity.run();
		}
	}   
	static class SearchInventoryAction implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			SearchInventoryActivity.run();
		}
	} 
	static class NewEmployee implements ActionListener{
		public void actionPerformed (ActionEvent e){
			
		}
	}
	static class LookupCustomer implements ActionListener{
		public void actionPerformed (ActionEvent e){
			CustomerLookupWindow.run();
		}
	}
}
