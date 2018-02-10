import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchInventoryActivity {
	static JTextField itemID;
	static JFrame frame;
	public static void run(){
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(700,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = frame.getWidth()/2;
		int y = frame.getHeight()/2;
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton button = new JButton("Search");
		panel.add(button);
		button.setBounds(x-55,y+140,100,50);
		button.addActionListener (new Action1());
		itemID = new JTextField();
		panel.add(itemID);
		itemID.setText("");
		itemID.setBounds(x-100,y-150,200,30);
		JButton editButton = new JButton("Search");
		
		editButton.setBounds(x-55,y+140,100,50);
		editButton.addActionListener (new Action1());
		if (window.manager){
			panel.add(editButton);
		}
		String textMessage = "Game or Movie Name";
		Font font = new Font("Calibri", Font.PLAIN, 12);
		JLabel textLabel = new JLabel("<html><div style='text-align: center;'>" + textMessage + "</div></html>");
		
		textLabel.setFont(font);
		
		panel.add(textLabel);
		textLabel.setBounds(x-65,y-200,135,40);
		JButton exitButton = new JButton("Done");
		panel.add(exitButton);
		exitButton.setBounds(x-55,y+220,100,50);
		exitButton.addActionListener (new Action2());
	}
	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			SortItemsByName.sort(window.items);
			String name = itemID.getText().toString();
			int item = SearchInventoryByName.searchArray(window.items, name, window.items.length, 0);
			if (item==-1){
				JOptionPane.showMessageDialog(
						null, "Item Not Found", 
						"Video Rental", JOptionPane.ERROR_MESSAGE);
			}
			else{
			ItemInfo.run(item);
			}
		}
	}   
	static class Action2 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {  
			frame.dispose();
		}
	}   
}
