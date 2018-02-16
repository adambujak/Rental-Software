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

/*
 * Customer array (customers) 0: first name
 * 						   1: last name
 * 						   2: fines ($)
 *                         3: phone Number
 *       - max 6 checkouts at once
 */

public class window {
	public static String[][] customers = {{"",""}};
	public static int numCustomerFields = 10;
	public static int numEmployeeFields = 5;
	public static String[][] items = {{"",""}};
	public static boolean manager = false;
	public static String[][] employees = {{"",""}};
	static JFrame frame;
	static JTextField employeeID;
	static JTextField password;
	public static void main(String[] args){
		
		runWindow();
		
		
		refreshCustomers();
		refreshItems();
		
		try {
			SortAndOutputCustomers.save(customers);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			SortAndOutputItems.save(items);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(SearchItem.search(items, "0001"));
		try {
			employees = MakeEmployeeArray.read("employees.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			employees = SortAndOutputEmployees.save(employees);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IT CAUGHT");
		}
		
		
		
	
	}
	public static void refreshCustomers(){

		try {
			customers = MakeCustomerArray.read("customers.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			customers = SortAndOutputCustomers.save(customers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void refreshItems(){

		try {
			items = MakeItemArray.read("items.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			items= SortAndOutputItems.save(items);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static class login implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			String ID = employeeID.getText();
			String s_password = password.getText();
	
			
			int employee = SearchEmployee.search(employees, ID);
			
			if (employee==-1){
				JOptionPane.showMessageDialog(
						null, "Employee Not Found", 
						"Video Rental", JOptionPane.ERROR_MESSAGE);
			}
			else if (s_password.equals(employees[employee][3])){
				if (employees[employee][4].equals("Manager")){
					ManagerActivity.run();
					manager = true;
					frame.dispose();
					}
				else {
					EmployeeActivity.run();
					frame.dispose();
				}
			}
			else{
				JOptionPane.showMessageDialog(
						null, "Username or Password Incorrect!", 
						"Video Rental", JOptionPane.ERROR_MESSAGE);
			}
		}
	}   
	public static void runWindow(){ //setting up main page GUI and running it
        final String idFieldStr = "Employee ID";
		final Font font = new Font("Calibri", Font.PLAIN, 25);
        final String passwordFieldStr = "Password";
        
        
        JLabel textLabel2 = new JLabel(passwordFieldStr);
        JLabel textLabel = new JLabel(idFieldStr);
        
        JButton button = new JButton("Login");
        JPanel panel = new JPanel();
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(700,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = frame.getWidth()/2;
		int y = frame.getHeight()/2;
        
        
		
		frame.add(panel);
		panel.setLayout(null);
		
		panel.add(button);
		button.setBounds(x-55,y+140,100,50);
		button.addActionListener (new login());
		employeeID = new JTextField();
		panel.add(employeeID);
		employeeID.setBounds(x-100,y-150,200,30);
		password = new JTextField();
		panel.add(password);
		password.setBounds(x-100,y-10,200,30);
		textLabel.setFont(font);
		panel.add(textLabel);
		textLabel.setBounds(x-65,y-200,150,30);
		textLabel2.setFont(font);
		panel.add(textLabel2);
		textLabel2.setBounds(x-55,y-55,150,30);
	}
}
