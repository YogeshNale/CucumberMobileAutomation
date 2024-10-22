package programs;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		int a=9 ;int b=0;
		
		for (int i=1 ; i<=a;i++) {
			if (a%i==0) {
				b++;
			}
		}
		if(b>2) {
			System.out.println("Number is not prime number");
		}
		else {
			System.out.println("number is  prime number ");
		}

	}

}
