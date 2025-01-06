/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/split-the-binary-string-into-
 * substrings-with-equal-number-of-0s-and-1s/1
 * Given binary string str of length N. The task is to find the maximum count of
 * consecutive substrings str can be divided into such that all the substrings
 * are balanced i.e. they have an equal number of 0s and 1s. If it is not
 * possible to split str satisfying the conditions then return -1.
 */

public class ElevenBinaryString {

  public static int maxSubStr(String str) {
    int result = 0, countZero = 0, countOne = 0;

    // Idea is to increment result
    // only when counts of both 0 and 1 are equal
    for (int i = 0; i < str.length(); i++) {

      if (Integer.parseInt(str.substring(i, i + 1)) == 0) {
        countZero += 1;
      } else {
        countOne += 1;
      }

      if (countZero == countOne) {
        countZero = 0;
        countOne = 0;
        result += 1;
      }
    }

    // And return count if zeroes and ones still match
    return (result == 0 || countZero != countOne) ? -1 : result;
  }

}
