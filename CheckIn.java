
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class CheckIn {
	public static void checkInItem (String itemID){
		int item = SearchItem.search(window.items, itemID);
		if (item == -1){
			JOptionPane.showMessageDialog(
					null, "Item Not Found", 
					"Video Rental", JOptionPane.ERROR_MESSAGE);
		}
		else{
			int customer = SearchArray.search(window.customers, window.items[item][4]);
			for (int cnt = 4; cnt < 10; cnt ++){
				if (window.customers[customer][cnt].equals(itemID)){
					window.customers[customer][cnt]="";
				}
			}
			JOptionPane.showMessageDialog(
					null, "Success!", 
					"Video Rental", JOptionPane.PLAIN_MESSAGE);
			Date localDate = new Date();
			long date = localDate.getTime();
			long date2 = TimeUnit.MILLISECONDS.toDays(date);
			long date1 = Long.parseLong(window.items[item][5]);
			double fine = 0;
			long numDays = date2-date1;
			if (numDays>7){
				numDays-=7;
				fine = numDays*0.50;
			}
			window.items[item][3]="in";
			window.items[item][4]="";
			window.items[item][5]="";
			fine+= Double.parseDouble(window.customers[customer][2]);
			window.customers[customer][2] = fine+"";
			if (fine > 0){
				
			}
		}
	}
}
