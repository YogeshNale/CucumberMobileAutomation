  package programs;

import java.util.ArrayList;

public class RemoveDuplicate {

	
	public static void main(String args[]) {
		int a[]= {1,2,4,3,2,1,5,6,7,6,5};
		ArrayList<Integer> ab= new ArrayList<Integer>();	
		for (int i=0;i<=a.length-1;i++) {
			int k=0;
	
		if(!ab.contains(a[i])) {
			ab.add(a[i]);
		for (int j=0;j<=a.length-1;j++) {
			if(a[i]==a[j]) {
				k++;
			}
		}
		if(k==1) {
			System.out.println(a[i]);
		}
			}
}
}
}