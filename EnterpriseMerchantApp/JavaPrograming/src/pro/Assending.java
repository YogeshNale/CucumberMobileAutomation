package pro;

public class Assending {

	public static void main(String[] args) {
		int a[]= {5,4,3,99,7,0,5,8};
		
		for(int i=0;i<a.length;i++) {
			int temp=0;
			for (int j=i+1;j<a.length;j++) {
				if (a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
				
			}
			System.out.println(a[i]);
	}

}
}
