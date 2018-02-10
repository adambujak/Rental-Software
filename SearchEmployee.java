
public class SearchEmployee {
	public static int search(String[][] array, String phoneNumber){
		int cnt = searchArray(array, phoneNumber, array.length, 0);
		return cnt;
	}
	public static int searchArray(String[][] array, String value, int high, int low){
		int buffer = high;
		high = (high+low)/2;
		if (value.equals(array[high][2])){
			
			return high;
		}
		if (high <=low){
			
			return -1;
		}
		else if (value.compareTo(array[high][2])<=0){
			return (searchArray(array, value, high, low));
		}
		else{	
			low = high;
			high = buffer;
			return (searchArray(array, value, high, low));
		}	
	}
}
