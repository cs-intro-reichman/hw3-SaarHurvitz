/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		//System.out.println(preProcess("What? No way!!!y"));
		
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		
		String str = "cat";
		System.out.println(str.length());
		// Tests the randomAnagram function.
		//System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
	 	/*String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");*/
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		System.err.println(str1.length());
		str2 = preProcess(str2);
		System.err.println(str2.length());
		int count = 0;
		int j = 0;
		 for(int i = 0; i < str1.length(); i++){
			for(; j < str2.length(); j++){
				if(str1.charAt(i) != str2.charAt(j)){
					count++;
				}
			}
			if(count == j){
				return false;
			}
			count = 0;
			j = 0;
		 }
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "what no way"
	public static String preProcess(String str) {
		
		char c = ' ';
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			if("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(str.charAt(i)) != -1){
					c = Character.toLowerCase(str.charAt(i));
					sb.append(c);		

		}
		
	}
	return sb.toString();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

		StringBuilder sb = new StringBuilder();
		int count1 = 0;
		int count2 = 0;
		char c;
		int num = (int) (Math.random() * str.length());
		c = str.charAt(num);
		sb.append(c);
		String cString;

		while (sb.toString().length() != str.length()) {

			num = (int) (Math.random() * str.length());
			c = str.charAt(num);
			cString = "" + c;
			for(int i = 0; i < str.length(); i++){
				if(cString.indexOf(str.charAt(i)) != -1){
					count1++;
				}
			}
			for(int j = 0; j < sb.toString().length(); j++){
				if(cString.indexOf(sb.toString().charAt(j)) != -1){
					count2++;
				}
			}
			if(count1 != count2){
              sb.append(c);
			}
			count1 = 0;
			count2 = 0;
		}
			return sb.toString();	
	}
}
