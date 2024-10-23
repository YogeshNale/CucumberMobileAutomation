 package programs;

import java.util.ArrayList;

public class SameValuesInArray {

	public static void main(String[] args) {
		int a[]= {1,4,6,8,9,23,44,56};
		int b[]= {2,5,7,8,10,23,7,56};
		ArrayList<Integer> ab=new ArrayList<Integer>()
;		for(int i=0;i<a.length;i++) {
			if(a[i]==b[i]) {
				  ab.add(a[i]);
			}
}
			Object[] c = ab.toArray();
			

			for(Object d :c) {
				System.out.println(d);
			}
		
	}
	

}
