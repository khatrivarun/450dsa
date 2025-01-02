/*
 * Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-string/1
 */

public class ZeroReverseString {

  public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }

}
