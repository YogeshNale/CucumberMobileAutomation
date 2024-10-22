 package programs;

public class MaxDiffArray {
	public static void main(String args[]) {
		int a[] = { 1, 4, 8, 15, 17 ,99};
		int sub = 0;
		for (int i = 0; i < a.length-1; i++) {

			if (a[i + 1] - a[i] > sub) {
				sub = a[i + 1] - a[i];
			}

		}
		System.out.println(sub);

	}

}
