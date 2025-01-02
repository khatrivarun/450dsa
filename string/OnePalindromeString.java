/*
 * Problem Link: https://www.geeksforgeeks.org/problems/palindrome-string0817/1
 */

public class OnePalindromeString {

  boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }

}
