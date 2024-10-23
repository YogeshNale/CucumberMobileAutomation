package programs;

public class Fibonicice {

	public static void main(String[] args) {
	//0 ,1 ,1 ,2,3,5,8
		
		
		int a=0;
		int b=1;
		
		int c;
		
		for (int i=0;i<=10;i++) {
			System.out.println(a);
			c=a+b;
			b=a;
			a=c;
			
			
			
		}

	}

}
