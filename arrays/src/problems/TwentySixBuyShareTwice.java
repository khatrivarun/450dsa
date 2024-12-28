package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1
 * In daily share trading, a buyer buys shares in the morning and sells them on the same day.
 * If the trader is allowed to make at most 2 transactions in a day, the second
 * transaction can only start after the first one is complete (buy->sell->buy->sell).
 * The stock prices throughout the day are represented in the form of an array of prices.
 *
 * Given an array price of size n, find out the maximum profit that a share trader could have made.
 *
 * Examples:
 * Input:
 * n = 6
 * prices[] = {10,22,5,75,65,80}
 * Output: 87
 *
 * Input:
 * n = 7
 * prices[] = {2,30,15,10,8,25,80}
 * Output: 100
 *
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(n)
 */

public class TwentySixBuyShareTwice {

  // Actual method provided for solution
  public static int maxProfit(int n, int[] price) {

    int[] profits = new int[price.length];

    int maximum = price[price.length - 1];

    // First we will calculate while traversing the array in reverse,
    // maximum profits and maximum prices and store the profits
    // in a separate array.
    //
    // This will be our second transaction profits
    for (int i = price.length - 2; i >= 0; i--) {
      maximum = Math.max(maximum, price[i]);

      profits[i] = Math.max(profits[i + 1], maximum - price[i]);
    }

    int minimum = price[0];
    int result = Integer.MIN_VALUE;

    // Second, we will calculate profit as how we did it
    // for single transactions but this time we will also
    // consider profits from the profits array.
    for (int i = 1; i < price.length; i++) {
      minimum = Math.min(minimum, price[i]);

      result = Math.max(result, (price[i] - minimum) + profits[i]);

    }

    return result;

  }

  public static void main(String[] args) {

    int arr1[] = { 10, 22, 5, 75, 65, 80 };
    System.out.println(TwentySixBuyShareTwice.maxProfit(6, arr1));

    int arr2[] = { 2, 30, 15, 10, 8, 25, 80 };
    System.out.println(TwentySixBuyShareTwice.maxProfit(7, arr2));

  }

}
