package programs;

public class SumOFArrayElement {

	public static void main(String[] args) {
	
		int a[]= {1,2,3,4,5};
		sumOFArray(a);

	}
	
	public static int sumOFArray(int a[]) {
		int sum=0;
		for(int i=0 ; i<a.length;i++) {
		 sum = sum+a[i];
		 
		
		}
		System.out.println(sum);
		return sum;
	
		
	}
	

}
