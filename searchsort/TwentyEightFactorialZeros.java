/*
 * Problem Link: https://www.geeksforgeeks.org/problems/smallest-factorial-number5929/1
 * Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.
 *
 * Examples:
 * Input: n = 5
 * Output: 5
 *
 * Input: n = 6
 * Output: 25
 */

public class TwentyEightFactorialZeros {

  int findNum(int n) {
    int number = 1;
    int zeroesCount = 0;

    // Idea is to keep on increasing
    // number until we reach required
    // number of zeroes.
    while (true) {
      int tempNumber = number;

      while (tempNumber % 5 == 0) {
        zeroesCount += 1;
        tempNumber /= 5;
      }

      if (zeroesCount >= n) {
        return number;
      }

      number += 1;
    }
  }

}
