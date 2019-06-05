package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		int len = string.length();
		char[] charArr = new char[len];
		for(int i = 0; i <len; i++) {
			charArr[i] = string.charAt((len-1-i));
		}
		
		String str = new String(charArr);
		return str;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		int len = (int) phrase.length();
		int count = 0;
		char[] charArrVersion = phrase.toCharArray();
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
				if(charArrVersion[i]==' ' || charArrVersion[i] == '-') {
					charACRNM[j] = charArrVersion[i+1];
					charArrVersion[i]='N';
					charACRNM[j] = Character.toUpperCase(charACRNM[j]);
					break;
				}
			}
		}
		String str = new String(charACRNM);
		return str;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		Double s1 = this.sideOne;
		Double s2 = this.sideTwo;
		Double s3 = this.sideThree;
		
		
		public boolean isEquilateral() {
			if((s1==s2) && (s2==s3)) {
				return true;
			}else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if((s1==s2)||s2==s3|| s1==s3 ||((s1==s2) && (s2==s3))){
				return true;
			}else {
				return false;
			}
		}

		public boolean isScalene() {
			if((s1!=s2)||s2!=s3|| s1!=s3 ||((s1!=s2) && (s2!=s3))) {
				return false;
			}else {
				return true;
			}
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		
		char[] charArr = string.toCharArray();
		int count = 0;
		int len = string.length();
		
		for(int i = 0; i<len; i++) {
			
			switch (string.charAt(i)) {
			
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				count+=1;
				break;
			case 'D':
			case 'G':
				count+=2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				count+=3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				count+=5;
				break;
			case 'J':
			case 'X':
				count+=8;
				break;
			case 'Q':
			case 'Z':
				count+=10;
				break;
			default:
				break;
			}
		}	
		return count;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		StringBuilder str1 = new StringBuilder(string);
		StringBuilder str2 = new StringBuilder();
		char[] str3 = {'0','1','2','3','4','5','6','7','8','9'};
		
		
		//System.out.println(str1);
		
		int len = str1.length();
		
		//System.out.println(len);
		
		for(int i = 0; i<len; i++) {
			//System.out.println(str1.charAt(i));
			for(int j = 0; j < 10; j++) {
				//System.out.println(j);
				if(str1.charAt(i) == str3[j]) {
					str2.append(j); 
					//System.out.println(j);
				}
			}
		}
		
		int len2 = str2.length();
		
		if(len2 >10) {
			throw new IllegalArgumentException();
		}
		
		if(len2<9) {
			throw new IllegalArgumentException();
		}
		

		String str4 = str2.toString();
		return str4;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		//String arrOfStr3 = string.replaceAll(",|\\n", " ");
		String[] arrOfStr = string.split(" |,|\n");
		String[] arrOfStr1 = arrOfStr;
		
		int len = arrOfStr.length;
		int count = 0;
		
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i = 0; i<len; i++) {
			for(int j = 0; j<len; j++) {
				if(arrOfStr[i].equals(arrOfStr1[j])) {
						count++;
						//hm.put(arrOfStr[i], count);
				}
			}
			hm.put(arrOfStr[i], count);
			count = 0;
		}
		//System.out.println(hm);
		return hm;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T>{
		private List<T> sortedList;

		public int indexOf(T t) {
			
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList; 
				
			}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	
	
	public boolean isArmstrongNumber(int input) {
		
		int i =0; 
		int count = 0; 
		int sum = 0;
		int falseInput = input;
		int falseInputTwo = input; 
		
		
		while(falseInput !=0) {
			i++;
			falseInput = falseInput/10;
		}

		while(falseInputTwo != 0) {
			count = falseInputTwo%10;
			falseInputTwo = falseInputTwo/10;
			sum += Math.pow(count, i);
			
		}

		boolean result; 
		
		if(sum == input) {
			result = true; 
		}else {
			result =  false;
		}

		return result;
	}
	

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		string.toLowerCase();
		StringBuilder str = new StringBuilder(string);
		StringBuilder blank = new StringBuilder();

		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
				'n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int sum =0;
		int len = str.length();
		int alphaLen = alphabet.length;
		
		for(int i = 0; i<len; i++) {
			char[] alpha = alphabet;
			for(int j = 0; j< 26; j++) {
				if(str.charAt(i) == alpha[j]) {
					blank.append(alpha[j]); 
					alpha[j]= '\0';
					sum++;
				}
			}
		}
		
		boolean result;
		
		if(sum <26) {
			result = false;
		}else {
			result = true;
		}

		return result;
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		char[] ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
				'n','o','p','q','r','s','t','u','v','w','x','y','z'};

		public String rotate(String string) {
			
			StringBuilder str = new StringBuilder(string);
			StringBuilder blank = new StringBuilder();
			
			int len = string.length();
			int k = 0;
			int count = 0; 
			
			this.key = key; 
			
			for(int i = 0; i< len; i++) {
				if(count == 0) {
					for(int j= 0; j< 26; j++) {
						if(str.charAt(i) == alphabet[j]) {
							k = (j+key)%26;
							blank.append(alphabet[k]);
							count++;

						}
						if(str.charAt(i)==ALPHABET[j]) {
							k = (j+key)%26;
							blank.append(ALPHABET[k]);
							count++;
						}

					}
					if(count == 0) {
						blank.append(str.charAt(i));
					}
					count = 0;
				}else {
					count = 0;
				}
			}
			String str1 = blank.toString(); 
			return str1;
		}
	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			StringBuilder alpha = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
			StringBuilder revAlpha = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
			StringBuilder numeric = new StringBuilder("0123456789");
			
			StringBuilder str = new StringBuilder(string);
			
			revAlpha.reverse();
			
			StringBuilder empty = new StringBuilder();
			String strLower = str.toString();
			strLower = strLower.toLowerCase();
			int len = string.length(); 
			
			for(int i = 0; i< len; i++ ) { 
				for( int j = 0; j< 26; j++) {
					if(strLower.charAt(i) == alpha.charAt(j)) {
						empty.append(revAlpha.charAt(j));
					}
				}
				for(int l = 0; l<10; l++) {
					if(strLower.charAt(i)==numeric.charAt(l)) {
						empty.append(numeric.charAt(l));
					}
				}
			}

			if(len>5) {
			for(int i =5 ; i<len; i+=6) {
					empty.insert(i, " ");
			}
			}
			
			
			String str1 = empty.toString();
			String str2 = str1.trim();
			return str2;
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			String str = string.replaceAll(" ", "");

			StringBuilder alphas = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
			StringBuilder revAlphas = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
			StringBuilder numerics = new StringBuilder("0123456789");
			StringBuilder str2 = new StringBuilder(str);
			
			revAlphas.reverse();
			int lens = (string.replaceAll(" ","")).length(); 
			
			StringBuilder blank = new StringBuilder();
			
			for(int i = 0; i< lens; i++ ) { 
				for( int j = 0; j< 26; j++) {
					if(str2.charAt(i) == alphas.charAt(j)) {
						blank.append(revAlphas.charAt(j));
					}
				}
				for(int l = 0; l<10; l++) {
					if(str2.charAt(i)==numerics.charAt(l)) {

						blank.append(numerics.charAt(l));
					}
				}
			}
			
			String str3 = blank.toString();
			return str3;
		}
	}
}

	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 *
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 *
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 *
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
*/