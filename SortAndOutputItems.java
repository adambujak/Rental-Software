import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortAndOutputItems {
	public static String[][] save(String[][] items) throws IOException{
		items = sort(items);
		//outputArray(items);
		BufferedWriter outputFile = new BufferedWriter(new FileWriter("items.txt"));
		PrintWriter writer = new PrintWriter(outputFile);
		for (int cnt = 0; cnt < items.length; cnt++){
			for (int inner = 0; inner<6; inner++){
				writer.println(items[cnt][inner]);
			}
			writer.println("@#$");
		}
		writer.println("end!90*");
		writer.close();
		return items;

	}

	public static String[][] sort(String[][] array){

		int inner, outer;
		String temp;
		String[] tempArray;

		int h = 1;
		while (h <= array.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (outer = h; outer < array.length; outer++) {
				temp = array[outer][0];
				tempArray = array[outer];
				inner = outer;
				while (inner > h - 1 && (array[inner - h][0].compareTo(temp)>=0)) {
					array[inner] = array[inner - h];
					inner -= h;
				}
				array[inner] = tempArray;
			}
			h = (h - 1) / 3;
		}

		return array;
	}
	public static void outputArray(String[][] array){

		for (int cnt = 0; cnt < array.length; cnt++){
			for (int cnt2=0; cnt2<6; cnt2++){
				System.out.println(array[cnt][cnt2]);
			}
			System.out.println("");
		}
	}
}
