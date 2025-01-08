/*
 * Problem Link: https://www.geeksforgeeks.org/problems/arithmetic-number2815/1
 * Given three integers 'a' denotes the first term of an arithmetic sequence,
 * 'c' denotes the common difference of an arithmetic sequence and an integer
 * 'b'. you need to tell whether 'b' exists in the arithmetic sequence or not.
 * Return 1 if b is present in the sequence. Otherwise, returns 0.
 *
 * Examples:
 * Input: a = 1, b = 3, c = 2
 * Output: true
 *
 * Input: a = 1, b = 2, c = 3
 * Output: false
 *
 * Input: a = 1, b = 2, c = 4
 * Output: false
 */

public class TwentySevenAP {

  static int inSequence(int a, int b, int c) {

    int firstTerm = a, commonDifference = c, toCheck = b;
    int difference = toCheck - firstTerm;

    // Honestly, forgot maths
    // so got the algorithm from
    // https://www.geeksforgeeks.org/check-whether-the-number-exists-in-arithmetic-sequence-or-not/
    // and implemented code for it
    if (difference == 0)
      return 1;
    if (difference < 0) {

      if (commonDifference >= 0)
        return 0;
      if (difference % commonDifference == 0)
        return 1;

    } else {
      if (commonDifference <= 0)
        return 0;
      if (difference % commonDifference == 0)
        return 1;
    }
    return 0;

  }

}
