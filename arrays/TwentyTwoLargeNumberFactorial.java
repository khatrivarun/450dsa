
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
 *
 * Given an integer n, find its factorial. Return a list of integers denoting
 * the digits
 * that make up the factorial of n.
 *
 * Examples:
 * Input: n = 5
 * Output: [1, 2, 0]
 *
 * Input: n = 10
 * Output: [3, 6, 2, 8, 8, 0, 0]
 *
 * Input: n = 1
 * Output: [1]
 */

public class TwentyTwoLargeNumberFactorial {

  // The only issue for this problem was
  // that the factorials were massive
  // for long to work, hence switching to
  // BigInteger solved the issue.
  public static BigInteger calculateFactorial(int n) {

    if (n == 0 || n == 1)
      return BigInteger.ONE;

    return BigInteger.valueOf(n).multiply(calculateFactorial(n - 1));
  }

  // Actual method given for solution
  public static ArrayList<Integer> factorial(int n) {
    ArrayList<Integer> result = new ArrayList<>();

    BigInteger factorial = calculateFactorial(n);

    // Just convert the factorial to a character array
    // and push numerical values in the array
    for (char character : factorial.toString().toCharArray()) {
      result.add(character - '0');
    }

    return result;
  }

}
