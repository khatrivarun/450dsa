/*
 * Problem Link: https://www.geeksforgeeks.org/problems/transform-string5648/1
 * Given two strings A and B. Find the minimum number of steps required to 
 * transform string A into string B. The only allowed operation for the 
 * transformation is selecting a character from string A and inserting it 
 * in the beginning of string A.
 *
 * Examples:
 * Input:
 * A = "abd"
 * B = "bad"
 * Output: 1
 *
 * Input:
 * A = "GeeksForGeeks"
 * B = "ForGeeksGeeks"
 * Output: 3
 */

import java.util.HashMap;

public class FourtyTransformString {

  // Couldn't solve this one
  // Algorithm for this implementation:
  // https://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/
  int transform(String A, String B) {
    int result = 0;
    HashMap<Character, Integer> frequencies = new HashMap<>();

    // if strings do not match in length
    // return -1;
    if (A.length() != B.length()) {
      return -1;
    }

    // Count frequencies of characters in first string
    for (int i = 0; i < A.length(); i++)
      frequencies.put(A.charAt(i), frequencies.getOrDefault(A.charAt(i), 0) + 1);

    // Decrement characters when going through
    // second string
    for (int i = 0; i < B.length(); i++) {
      if (frequencies.containsKey(B.charAt(i)))
        frequencies.put(B.charAt(i), frequencies.get(B.charAt(i)) - 1);
    }

    // if all frequencies are not equal to 0
    // return -1
    for (HashMap.Entry<Character, Integer> entry : frequencies.entrySet()) {
      if (entry.getValue() != 0)
        return -1;
    }

    int Apointer = A.length() - 1, Bpointer = B.length() - 1;

    // loop from the end of both strings
    // if A[a] and B[b] dont match, increment
    // result value and decrement a pointer
    //
    // else decrement both a and b pointers
    while (Apointer >= 0 && Bpointer >= 0) {

      if (A.charAt(Apointer) == B.charAt(Bpointer)) {
        Apointer -= 1;
        Bpointer -= 1;
      } else {
        Apointer -= 1;
        result += 1;
      }

    }
    return result;
  }

}
