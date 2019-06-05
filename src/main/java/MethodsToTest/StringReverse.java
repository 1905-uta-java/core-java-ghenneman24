package MethodsToTest;

public class StringReverse {
	
	public void ReverseString(String string) {
		
		int len = (int) string.length();
		char[] charArr = new char[len];
		for(int i = 0; i <len; i++) {
			charArr[i] = string.charAt((len-1-i));
			System.out.println(charArr);
		}
	}

	public StringReverse() {
		super();
	}
}
