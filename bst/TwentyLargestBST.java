// Problem Link: https://www.geeksforgeeks.org/problems/largest-bst/1
// You're given a binary tree. Your task is to find the size of the largest
// subtree within this binary tree that also satisfies the properties of a
// Binary Search Tree (BST). The size of a subtree is defined as the number of
// nodes it contains.
// Note: A subtree of the binary tree is considered a BST if for every node in
// that subtree, the left child is less than the node, and the right child is
// greater than the node, without any duplicate values in the subtree.
//
// Examples:
// Input: root = [5, 2, 4, 1, 3]
// Output: 3
//
// Input: root = [6, 7, 3, N, 2, 2, 4]
// Output: 3

public class TwentyLargestBST {

  // Couldn't figure this one out at all
  static Property calculateLargestBST(Node node) {
    if (node == null)
      return new Property(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

    // First we will check if there's any subtrees where the BST
    // property is getting fullfilled. While checking for the
    // BST property, we are also keeping track of the size of BST
    // (if it exists)
    Property leftSubtreeProperty = calculateLargestBST(node.left);
    Property rightSubtreeProperty = calculateLargestBST(node.right);

    // The BST property: The current node should be bigger than the max
    // of the left subtree and should be smaller than right subtree's
    // minimum value.
    if (node.data > leftSubtreeProperty.maximumNodeValue && node.data < rightSubtreeProperty.minimumNodeValue) {
      return new Property(Math.min(node.data, leftSubtreeProperty.minimumNodeValue),
          Math.max(node.data, rightSubtreeProperty.maximumNodeValue),
          1 + leftSubtreeProperty.maxSize + rightSubtreeProperty.maxSize);
    }

    return new Property(Integer.MIN_VALUE, Integer.MAX_VALUE,
        Math.max(leftSubtreeProperty.maxSize, rightSubtreeProperty.maxSize));
  }

  static int largestBst(Node root) {
    return calculateLargestBST(root).maxSize;
  }

}

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

class Property {
  int minimumNodeValue, maximumNodeValue, maxSize;

  public Property(int minimumNodeValue, int maximumNodeValue, int maxSize) {
    this.minimumNodeValue = minimumNodeValue;
    this.maximumNodeValue = maximumNodeValue;
    this.maxSize = maxSize;
  }
}
