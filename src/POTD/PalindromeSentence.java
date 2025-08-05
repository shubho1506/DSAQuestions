package POTD;

//Given a single string s, the task is to check if it is a palindrome sentence or not.
//A palindrome sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the same
// backward as forward after converting all uppercase letters to lowercase and removing all non-alphanumeric characters
// (including spaces and punctuation).
//Examples:
//Input: s = "Too hot to hoot"
//Output: true
//Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase,
//string s will become "toohottohoot" which is a palindrome.

//Input: s = "Abc 012..## 10cbA"
//Output: true
//Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase,
//string s will become "abc01210cba" which is a palindrome.

//Input: s = "ABC $. def01ASDF"
//Output: false
//Explanation: The processed string becomes "abcdef01asdf", which is not a palindrome.

public class PalindromeSentence {
    public static void main(String[] args) {
        System.out.println(isPalinSent("Abc 012..## 10cbA"));
    }

    public static boolean isPalinSent(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
