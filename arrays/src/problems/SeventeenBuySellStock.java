package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/buy-stock-2/1
 * Given an array prices[] of length n, representing the prices of the stocks on different days.
 * The task is to find the maximum profit possible by buying and selling the stocks on different
 * days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. 
 * If it is not possible to make a profit then return 0.
 *
 * Examples:
 * Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
 * Output: 8
 *
 * Input: prices[] = [7, 6, 4, 3, 1]
 * Output: 0
 *
 * Input: prices[] = [1, 3, 6, 9, 11]
 * Output: 10
 */

public class SeventeenBuySellStock {

  /*
   * Actual method provided for solution
   */
  public int maximumProfit(int prices[]) {

    int minimumPrice = prices[0];
    int profit = 0;

    /*
     * Thinking process: This is a greedy problem.
     * So to tackle this, what we can do is to calculate
     * minimum price till i and maximum profit till i
     *
     * This helps in maintaining the order of buying
     * first and selling second.
     */
    for (int i = 1; i < prices.length; i++) {
      minimumPrice = Math.min(minimumPrice, prices[i]);
      profit = Math.max(profit, prices[i] - minimumPrice);
    }

    return profit;

  }

  public static void main(String[] args) {

    SeventeenBuySellStock seventeenBuySellStock = new SeventeenBuySellStock();

    System.out.println(seventeenBuySellStock.maximumProfit(new int[] { 7, 10, 1, 3, 6, 9, 2 }));
    System.out.println(seventeenBuySellStock.maximumProfit(new int[] { 7, 6, 4, 3, 1 }));
    System.out.println(seventeenBuySellStock.maximumProfit(new int[] { 1, 3, 6, 9, 11 }));

  }

}
