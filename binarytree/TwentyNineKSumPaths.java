// Problem Link: https://www.geeksforgeeks.org/problems/k-sum-paths/1
// Given a binary tree and an integer k, determine the number of downward-only paths
// where the sum of the node values in the path equals k. A path can start and end
// at any node within the tree but must always move downward (from parent to child).

import java.util.HashMap;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class TwentyNineKSumPaths {

  // Cumulative sum approach here, only difference, recurse and run it for left
  // and right subtrees and return the resultant count
  public int runSumK(Node node, int sum, int k, HashMap<Integer, Integer> cumulativeSums) {

    if (node == null)
      return 0;

    int result = 0;

    sum += node.data;

    if (sum == k)
      result += 1;

    result += cumulativeSums.getOrDefault(sum - k, 0);
    cumulativeSums.put(sum, cumulativeSums.getOrDefault(sum, 0) + 1);

    result += runSumK(node.left, sum, k, cumulativeSums);
    result += runSumK(node.right, sum, k, cumulativeSums);

    cumulativeSums.put(sum, cumulativeSums.getOrDefault(sum, 0) - 1);

    return result;

  }

  public int sumK(Node root, int k) {
    HashMap<Integer, Integer> cumulativeSums = new HashMap<>();

    int result = runSumK(root, 0, k, cumulativeSums);

    return result;
  }

}
