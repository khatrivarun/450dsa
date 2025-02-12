// Problem Link: https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1
// Given a Binary Search Tree and a node value x. Delete the node with the
// given value x from the BST. If no node with value x exists, then do not
// make any change. Return the root of the BST after deleting the node with
// value x.
//
// Examples:
// Input: root = [2, 1, 3] x = 12
// Output: 1 2 3
//
// Input: root = [1, N, 2, N, 8, 5, 11, 4, 7, 9, 12] x = 11
// Output: 1 2 4 5 7 8 9 12
//
// Input: root = [2, 1, 3] x = 3
// Output: 1 2

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class OneDeletion {

  public static Node deleteNode(Node root, int X) {

    if (root == null)
      return root;

    // Traverse till the node
    // using the BST property
    if (root.data < X)
      root.right = deleteNode(root.right, X);
    else if (root.data > X)
      root.left = deleteNode(root.left, X);
    else {

      // Case 1: If no left subtree
      // return right subtree
      if (root.left == null)
        return root.right;

      // Case 2: If no right subtree
      // return left subtree
      if (root.right == null)
        return root.left;

      // If no child, replace with inorder
      // successor and delete the successor
      Node inorderSuccessor = fetchInorderSucessor(root);
      root.data = inorderSuccessor.data;
      root.right = deleteNode(root.right, inorderSuccessor.data);
    }

    return root;

  }

  public static Node fetchInorderSucessor(Node node) {
    node = node.right;

    while (node != null && node.left != null)
      node = node.left;

    return node;
  }

}
