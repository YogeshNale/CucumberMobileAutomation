package pro;

public class RverseNumber {

	public static void main(String[] args) {
		
		int a=987;
		int reverse=0;
		while(a!=0) {
			int c=a%10;
			reverse =reverse*10 + c;
			a=a/10;
		}
		System.out.println(reverse);

	}

}
