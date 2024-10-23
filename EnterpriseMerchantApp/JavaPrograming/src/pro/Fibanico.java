package pro;

public class Fibanico {

	public static void main(String[] args) {
		
	int a=0;
	int b=1;
	int temp=0;
	for (int i=0;i<=10;i++) {
		System.out.println(a);
		temp=a+b;
		b=a;
		a=temp;
	}
	}

}
