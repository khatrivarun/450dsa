/*
 * Problem Link: https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
 * You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.
 *
 * Input: s1 = "abcd", s2 = "cdab"
 * Output: true
 *
 * Input: s1 = "aab", s2 = "aba"
 * Output: true
 *
 * Input: s1 = "abcd", s2 = "acbd"
 * Output: false
 */

public class FourRotation {

  public static boolean areRotations(String s1, String s2) {

    // If we append s1 with s1, s2 is bound to be present in between
    return new StringBuilder(s1).append(s1).toString().lastIndexOf(s2) >= 0;

  }

  public static void main(String[] args) {

    System.out.println(FourRotation.areRotations("abcd", "cdab"));
    System.out.println(FourRotation.areRotations("aab", "aba"));
    System.out.println(FourRotation.areRotations("abcd", "acbd"));

  }

}
