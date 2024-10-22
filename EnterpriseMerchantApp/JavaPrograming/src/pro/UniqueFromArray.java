package pro;

import java.util.ArrayList;

public class UniqueFromArray {

	public static void main(String[] args) {
		
		int a[]= {3,4,6,5,7,8,9,4,3,2,9,6};
		ArrayList<Integer> ab=new ArrayList<Integer>();
	for(int i=0;i<a.length-1;i++) {
		int k=0;
		for(int j=0;j<=a.length-1;j++) {
			if (a[i]==a[j]) {
				k++;
			}
		}
		if(k==1) {
			System.out.println(a[i]);
		}
	}}		

}
