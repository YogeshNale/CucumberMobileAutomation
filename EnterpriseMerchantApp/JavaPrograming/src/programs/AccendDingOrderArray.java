package programs;

public class AccendDingOrderArray {

	public static void main(String[] args) {
	
		
		int a[]= {50,20,10,66,33,77,22};
		//10,20,22,33,50,66,77
		int temp;
		for(int i=0;i<a.length;i++) {
			   
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
