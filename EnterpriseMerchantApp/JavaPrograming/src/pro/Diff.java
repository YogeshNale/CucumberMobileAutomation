package pro;

public class Diff {

	public static void main(String[] args) {
		int a[] = { 1,4,6,8,99,99};

		int sub1 = 0;
		for (int i = 0; i < a.length - 1; i++) {
			int sub;
			sub = a[i]-a[i + 1];

			if (sub<sub1) {
				sub1 = sub;
			}

		}
		System.out.println(sub1);
	}

}
