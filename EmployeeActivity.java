import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EmployeeActivity {
	public static void run(){
		JFrame frame3 = new JFrame("");
		frame3.setVisible(true);
		frame3.setSize(700,800);
		JLabel label = new JLabel("Employee");
		JPanel panel = new JPanel();
		frame3.add(panel);
		panel.add(label);
	}
}
