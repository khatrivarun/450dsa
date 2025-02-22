// Problem Link:
// https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
// Given a Binary Tree with all unique values and two nodes value, n1 and n2.
// The task is to find the lowest common ancestor of the given two nodes. We may
// assume that either both n1 and n2 are present in the tree or none of them are
// present.
//
// Examples:
// Input: root = [1,2,3,4,5,6,7], n1 = 5 , n2 = 6
// Output: 1
//
// Input: root = [5, 2, N, 3, 4], n1 = 3 , n2 = 4
// Output: 2
//
// Input: root = [5, 2, N, 3, 4], n1 = 5 , n2 = 4
// Output: 5

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class ThirtyLCA {

  Node lca(Node root, int n1, int n2) {
    if (root == null)
      return null;

    // Step 1: If one of the nodes has been
    // reached for which we are finding LCA
    if (root.data == n1 || root.data == n2)
      return root;

    // Step 2: Check if the subtrees have
    // the required nodes in question
    Node checkLeftSubTree = lca(root.left, n1, n2);
    Node checkRightSubTree = lca(root.right, n1, n2);

    // If both subtrees have the nodes in question,
    // the root is considered as a potential LCA
    if (checkLeftSubTree != null && checkRightSubTree != null)
      return root;

    // Else return the subtree which
    // has atleast one of the nodes
    else
      return checkLeftSubTree != null ? checkLeftSubTree : checkRightSubTree;
  }

}
