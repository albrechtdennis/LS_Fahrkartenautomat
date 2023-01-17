
public class ArrayUbung {
	
	public static void main(String[] args) {
		int Zahlen[] = new int[10];
		
		for(int j = 0; j < 10; j++) { 
			Zahlen[j] = j;}
		
		for (int i= 0; i < Zahlen.length; i++) {
			System.out.println(Zahlen[i]);}
	
		int Zahlen1[] = {1, 6, 3, 7, 2, 2, 4, 8};
		for(int z=1; z<=Zahlen1.length-1; z = z+2) {
			System.out.println(Zahlen1[z] + ",");
	}
}
}
