import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortAndOutputEmployees {
	public static String[][] save(String[][] employees) throws IOException{
		employees = sort(employees);
		
		BufferedWriter outputFile = new BufferedWriter(new FileWriter("employees.txt"));
		PrintWriter writer = new PrintWriter(outputFile);
		for (int cnt = 0; cnt < employees.length; cnt++){
			for (int inner = 0; inner<window.numEmployeeFields; inner++){
				writer.println(employees[cnt][inner]);
			}
			writer.println("@#$");
		}
		writer.println("end!90*");
		writer.close();
		return employees;
		
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
				temp = array[outer][2];
				tempArray = array[outer];
				inner = outer;
				while (inner > h - 1 && (array[inner - h][2].compareTo(temp)>=0)) {
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
			for (int cnt2=0; cnt2<5; cnt2++){
				System.out.println(array[cnt][cnt2]);
			}
			System.out.println("");
		}
	}
}
