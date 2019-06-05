package MethodsToTest;

public class StringAcronym {
	
	public void AcronymString(String string) {
		
		int len = (int) string.length();
		int count = 0;
		char[] charArrVersion = string.toCharArray();
		for(int i = 0; i < len; i++) {;
			if(charArrVersion[i] == ' ' || charArrVersion[i] == '-') {
				count++;
			}
			}
		
		char[] charACRNM = new char[count+1];
		charACRNM[0] = charArrVersion[0];
		charACRNM[0] = Character.toUpperCase(charACRNM[0]);
		for(int j = 1; j<count+1; j++) {
			for(int i = 0; i<len; i++) {
				if(charArrVersion[i]==' ' || charArrVersion[i] =='-') {
					charACRNM[j] = charArrVersion[i+1];
					charArrVersion[i]='N';
					charACRNM[j] = Character.toUpperCase(charACRNM[j]);
					break;
				}
			}
		}
		System.out.println(charACRNM);
	}

	public StringAcronym() {
		super();
		// TODO Auto-generated constructor stub
	}

}
