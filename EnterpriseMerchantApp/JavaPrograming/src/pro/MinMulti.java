package pro;

public class MinMulti {

	public static void main(String[] args) {
		
		int a [][]= {{5,3,7},{3,9,7},{11,23,44},{4,69,64}};
		
		int min= a[0][0];
		for (int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				
				if(a[i][j]<min) {
					min=a[i][j];
				}
			}
		}
		System.out.println(min);

	}

}
