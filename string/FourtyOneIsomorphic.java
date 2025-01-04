/*
 * Problem Link: https://www.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1
 * Given two strings s1 and s2, check if these two strings are isomorphic to each other.
 *
 * If the characters in s1 can be changed to get s2, then two strings, s1 and s2, are
 * isomorphic. A character must be completely swapped out for another character while
 * maintaining the order of the characters. A character may map to itself, but no two
 * characters may map to the same character.
 *
 * Examples:
 * Input: s1 = "aab", s2 = "xxy"
 * Output: true
 *
 * Input: s1 = "aab", s2 = "xyz"
 * Output: false
 *
 * Input: s1 = "aac", s2 = "xyz"
 * Output: false
 */

import java.util.HashMap;

public class FourtyOneIsomorphic {

  // Couldn't do this one myself
  // code implementation for explanation given here:
  // https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
  public static boolean areIsomorphic(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    HashMap<String, Integer> mappingOne = new HashMap<>();
    HashMap<String, Integer> mappingTwo = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      String tokenOne = s1.substring(i, i + 1);
      String tokenTwo = s2.substring(i, i + 1);

      if (!mappingOne.containsKey(tokenOne)) {
        mappingOne.put(tokenOne, i);
      }

      if (!mappingTwo.containsKey(tokenTwo)) {
        mappingTwo.put(tokenTwo, i);
      }

      if (!mappingOne.get(tokenOne).equals(mappingTwo.get(tokenTwo))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(FourtyOneIsomorphic.areIsomorphic("aab", "xxy"));
    System.out.println(FourtyOneIsomorphic.areIsomorphic("aab", "xyz"));
    System.out.println(FourtyOneIsomorphic.areIsomorphic("aac", "xyz"));
  }

}
