import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class CheckOut {
	public static void checkOutItem (String itemID, String phoneNumber){
		int customer = SearchArray.search(window.customers, phoneNumber);
		int item = SearchItem.search(window.items, itemID);
		if (customer==-1){
			JOptionPane.showMessageDialog(
					null, "Customer Not Found", 
					"Video Rental", JOptionPane.ERROR_MESSAGE);
		}
		else if (item == -1){
			JOptionPane.showMessageDialog(
					null, "Item Not Found", 
					"Video Rental", JOptionPane.ERROR_MESSAGE);
		}
		else{

			if (window.items[item][3].equals("in")){

				
				Date localDate = new Date();
				long date = localDate.getTime();
				long date2 = TimeUnit.MILLISECONDS.toDays(date);
				
				window.items[item][3]="out";
				window.items[item][4]=phoneNumber;
				window.items[item][5]=""+date2;

				for (int cnt = 4; cnt < 10; cnt ++){
					if (window.customers[customer][cnt].equals("")){
						window.customers[customer][cnt]=itemID;
						break;
					}
				}
				JOptionPane.showMessageDialog(
						null, "Success!", 
						"Video Rental", JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(
						null, "Item Is Currently Checked Out!", 
						"Video Rental", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
