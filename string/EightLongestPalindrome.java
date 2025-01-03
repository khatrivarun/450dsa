/*
 * Problem Link: https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 * Given a string s, your task is to find the longest palindromic substring within s.
 * Note: If there are multiple palindromes with the same length, return the first
 * occurrence of the longest palindromic substring from left to right.
 *
 * Examples:
 * Input: s = "aaaabbaa"
 * Output: "aabbaa"
 *
 * Input: s = "abc"
 * Output: "a"
 *
 * Input: s = "abacdfgdcaba"
 * Output: "aba"
 */

public class EightLongestPalindrome {

  static boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }

  static String longestPalindrome(String s) {
    // Minimum possible palindrome
    String result = s.substring(0, 1);
    int maxLength = 1;

    // Idea is to build 2 strings of even and odd
    // lengths with 2 pointers, start and end,
    // and we will gradually increase those pointers
    // while checking if the resultant string is
    // palindrome or not
    //
    // While looping, we treat i as the mid element
    // for the potential palindrome string
    for (int i = 0; i < s.length() - 1; i++) {

      // odd string
      int startOdd = i;
      int endOdd = i;

      while (startOdd >= 0 && endOdd < s.length()) {
        String subString = s.substring(startOdd, endOdd + 1);
        int subStringLength = subString.length();

        if (isPalindrome(subString)) {
          if (subStringLength > maxLength) {
            maxLength = subStringLength;
            result = subString;
          }
        }

        startOdd -= 1;
        endOdd += 1;
      }

      // even string
      int startEven = i;
      int endEven = i + 1;
      while (startEven >= 0 && endEven < s.length()) {
        String subString = s.substring(startEven, endEven + 1);
        int subStringLength = subString.length();

        if (isPalindrome(subString)) {
          if (subStringLength > maxLength) {
            maxLength = subStringLength;
            result = subString;
          }
        }

        startEven -= 1;
        endEven += 1;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(EightLongestPalindrome.longestPalindrome("aaaabbaa"));
    System.out.println(EightLongestPalindrome.longestPalindrome("abc"));
    System.out.println(EightLongestPalindrome.longestPalindrome("abacdfgdcaba"));
  }

}
