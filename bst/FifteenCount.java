// Problem Link: https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
// Given a Binary Search Tree (BST) and a range l-h (inclusive), your task is to return the number
// of nodes in the BST whose value lie in the given range.
//
// Examples:
// Input: root[] = [10, 5, 50, 1, N, 40, 100], l = 5, h = 45
// Output: 3
//
// Input: root[] = [10, 5, 50, 1, N, 40, 100], l = 10, h = 100
// Output: 4
//
// Input: root[] = [1, 2, 3], l = 23, h = 95
// Output: 0

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class FifteenCount {

  // If the node falls in the range
  // calculate from both left and right subtree
  //
  // otherwise check from values to either
  // go left subtree or right subtree
  int getCount(Node root, int l, int h) {
    if (root == null)
      return 0;

    if (root.data >= l && root.data <= h)
      return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
    else if (root.data < l)
      return getCount(root.right, l, h);
    else
      return getCount(root.left, l, h);
  }
}
