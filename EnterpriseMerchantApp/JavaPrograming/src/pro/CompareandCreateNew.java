package pro;

import java.util.ArrayList;

public class CompareandCreateNew {

	public static void main(String[] args) {
		int a[] = { 1, 4, 6, 8, 9 };
		int b[] = { 4, 4, 6, 7, 9 };

		ArrayList<Integer> ab= new ArrayList<Integer>();
		
		for (int i=0; i<a.length;i++) {
			
			if(a[i]==b[i]) {
				ab.add(a[i]);
				
			}
			
		}
		Object c[]=ab.toArray();
		for(Object f:c) {
			System.out.println(f);
		}
	}

}
