 package programs;

public class MinNumberFromArray {

	public static void main(String[] args) {

		int a[][] = { { 10, 6, 7, }, { 3, 5, 9 }, { 5, 9, 6 } };
		int min = a[0][0];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] > min) {
					min = a[i][j];
				}
			}
		}

		System.out.println(min);

	}

}
