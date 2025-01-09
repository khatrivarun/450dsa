/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/count-the-reversals0401/1
 * Given a string S consisting of only opening and closing curly brackets '{'
 * and '}', find out the minimum number of reversals required to convert the
 * string into a balanced expression.
 * A reversal means changing '{' to '}' or vice-versa.
 *
 * Examples:
 * S = "}{{}}{{{"
 * Output: 3
 *
 * S = "{{}{{{}{{}}{{"
 * Output: -1
 */

public class TwentyBracketReversals {

  int countRev(String s) {

    if (s.length() % 2 == 1)
      return -1;

    int leftBrackets = 0, rightBrackets = 0;

    // checking balanced brackets
    // without stack
    //
    // but number of left and right brackets
    // are important since they determine
    // reversals
    for (int i = 0; i < s.length(); i++) {
      String bracket = s.substring(i, i + 1);

      if (bracket.equals("{")) {
        leftBrackets += 1;
      } else if (leftBrackets > 0) {
        leftBrackets -= 1;
      } else {
        rightBrackets += 1;
      }
    }

    // either reverse left or right
    return (leftBrackets + 1) / 2 + (rightBrackets + 1) / 2;
  }
}
