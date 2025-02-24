// Problem Link: https://www.geeksforgeeks.org/problems/leaf-at-same-level/1
// Given a binary tree with n nodes, determine whether all the leaf nodes are at
// the same level or not. Return true if all leaf nodes are at the same level,
// and false otherwise.
//
// Examples:
// Input: root = [1, 2, 3]
// Output: true
//
// Input: root = [10, 20, 30, 10, 15, N, N]
// Output: false
//
// Input: root = [3, 2, 1]
// Output: true

import java.lang.invoke.LambdaMetafactory;

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class TwentyTwoLeafLevel {

  int leafLevel = -1;

  // Check if leaf level is -1, if it is, set it
  // and if leaf level is set, check against it
  boolean checkLeavesLevel(Node root, int level) {
    if (root == null)
      return true;

    if (root.left == null && root.right == null) {
      if (leafLevel == -1) {
        leafLevel = level;
        return true;
      }

      return (level == leafLevel);
    }

    return checkLeavesLevel(root.left, level + 1) && checkLeavesLevel(root.right, level + 1);
  }

  boolean check(Node root) {
    return checkLeavesLevel(root, 0);
  }

}
