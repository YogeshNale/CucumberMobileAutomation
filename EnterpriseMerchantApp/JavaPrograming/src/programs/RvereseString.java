 package programs;

public class RvereseString {

	public static void main(String args[]) {
		// StringBuffer a= new StringBuffer("Yogesh Nale ");
		// a.reverse();
		// System.out.println(a);

		// plaindrom means when we reverese the string then also its same

		String a = "Madam";
		String t = "";

		for (int i = a.length() - 1; i >= 0; i--) {

			t = t + a.charAt(i);
		}
		System.out.println(t);
		if (t.equals(a)) {
			System.out.println("its same ");
		}
		else {
			System.out.println("Not same ");
		}

	}
}
