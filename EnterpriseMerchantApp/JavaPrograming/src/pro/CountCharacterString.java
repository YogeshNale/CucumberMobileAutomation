package pro;

public class CountCharacterString {

	public static void main(String[] args) {
		
  String a="fdsfdsfhdfhh";
  int count =0;
  for(int i=0;i<a.length();i++) {
	 
	  if(a.charAt(i)=='f') {
		  count++;
	  }
  }
		System.out.println(count);
	}	



}
