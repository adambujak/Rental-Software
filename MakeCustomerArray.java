import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
public class MakeCustomerArray{
	public static String[][] read(String textFile) throws IOException {
		BufferedReader inputFile = new BufferedReader(new FileReader(textFile));
		int length = 0;
		String line = inputFile.readLine().toString();
		while (line!=null){
			line = inputFile.readLine().toString();
			if (line.equals("end!90*")){
				break;
			}
			else if (line.equals("@#$")){
				length++;
			}
		}
		String[][] array = new String[length][10];
		array = fillArray(array);
		inputFile.close();
		inputFile = new BufferedReader(new FileReader(textFile));
		line = inputFile.readLine().toString();
		int counter = 0;
		int cnt = 0;
		
		while (counter<length){
			if (line.equals("@#$")){
				counter++;
				cnt = 0;
			}
			else{
			array[counter][cnt] = line;
			cnt++;
			}
			line = inputFile.readLine().toString();
		}
		inputFile.close();
	return array;
	}
	public static String[][] fillArray(String[][] array){
		for (int cnt = 0; cnt < array.length; cnt++){
			for (int cnt2 = 0; cnt2 < 10; cnt2++){
				array[cnt][cnt2]="";
			}
		}
		return array;
	}
}


