 package programs;

public class ReverseNumber {

	public static void main(String[] args) {
	
		
		int a=987;
		int reverse=0;
		while(a!=0) {
			int num =a%10;
			reverse = num+reverse*10;
			a=a/10;
			
		}
		System.out.print(reverse);

	}

}
