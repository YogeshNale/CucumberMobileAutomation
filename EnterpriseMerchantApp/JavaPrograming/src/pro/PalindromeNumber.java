package pro;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		int a =121;
		int b=a;
		int reverse=0;
		while(a>0) {
			int c=a%10;
			reverse = reverse*10+c;
			a=a/10;
		}
		
		System.out.println(reverse);
		if (reverse == b) {
			System.out.println(" Number is pallindrome Number ");
		}
		else {
			System.out.println("Number is not a pallindrome number ");
		}

	}

}
