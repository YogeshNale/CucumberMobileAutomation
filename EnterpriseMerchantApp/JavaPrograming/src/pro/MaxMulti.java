package pro;

public class MaxMulti {

	public static void main(String[] args) {
		int a[][]= {{1,2,3,9},{7,8,9,1},{7,6,5,3}};
		
		int max=a[0][0];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				
			if(a[i][j]>max) {
				
				max=a[i][j];
					
				}
			}
		}
		System.out.println(max);
		

	}

}
