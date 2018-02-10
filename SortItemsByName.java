

public class SortItemsByName {
	

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
				temp = array[outer][1];
				tempArray = array[outer];
				inner = outer;
				while (inner > h - 1 && (array[inner - h][1].compareTo(temp)>=0)) {
					array[inner] = array[inner - h];
					inner -= h;
				}
				array[inner] = tempArray;
			}
			h = (h - 1) / 3;
		}

		return array;
	}
	
}
