import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class AddCustomer {
	public static void write(String textFile, 
			String firstName, String lastName, 
		 String phoneNumber) throws IOException {
		
		BufferedReader inputFile = new BufferedReader(new FileReader(textFile));
		int length = 1;
		String line = inputFile.readLine().toString();
		
		while (line!=null){
			line = inputFile.readLine().toString();
			if (line.equals("end!90*")){
				break;
			}
			length++;	
		}
		inputFile.close();
		inputFile = new BufferedReader(new FileReader(textFile));
		line = inputFile.readLine().toString();
		String[] lines = new String[length];
		int cnt = 0;
		while (cnt<length){
			lines[cnt]=line;
			line = inputFile.readLine().toString(); 
			cnt++;
		}
		inputFile.close();
		BufferedWriter outputFile = new BufferedWriter(new FileWriter(textFile));
		PrintWriter writer = new PrintWriter(outputFile);
		
		for (cnt = 0; cnt < length; cnt++){
			writer.println(lines[cnt]);
		}
		
		writer.println(firstName);
		writer.println(lastName);
		writer.println("0");  //for fines
		writer.println(phoneNumber);
		writer.println("@#$");
		writer.println("end!90*");
		writer.close();
		outputFile.close();
		window.refreshCustomers();
		
	}
}
