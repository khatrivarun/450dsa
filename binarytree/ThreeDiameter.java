// Problem Link: https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
// Given a binary tree, the diameter (also known as the width) is defined as the
// number of edges on the longest path between two leaf nodes in the tree.
// This path may or may not pass through the root. Your task is to find the
// diameter of the tree.
//
// Examples:
// Input: root[] = [1, 2, 3]
// Output: 2
//
// Input: root[] = [5, 8, 6, 3, 7, 9]
// Output: 4

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

public class ThreeDiameter {

  int diameter = 0;

  // Diameter can be counted as maximum path
  // between leaf nodes so we recursively
  // calculate path lengths and check if its
  // the max
  int maximumPathBetweenLeafNodes(Node node) {
    if (node == null)
      return 0;

    int leftPath = maximumPathBetweenLeafNodes(node.left);
    int rightPath = maximumPathBetweenLeafNodes(node.right);

    diameter = Math.max(diameter, leftPath + rightPath);

    return 1 + Math.max(leftPath, rightPath);
  }

  int diameter(Node root) {
    maximumPathBetweenLeafNodes(root);

    return diameter;
  }

}
