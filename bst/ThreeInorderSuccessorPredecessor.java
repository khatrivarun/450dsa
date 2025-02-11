// Problem Link: https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
// You are given root node of the BST and an integer key. You need to find
// the in-order successor and predecessor of the given key. If either
// predecessor or successor is not found, then set it to NULL.
//
// Examples:
// Input: root[] = [8, 1, 9, N, 4, N, 10, 3, N, N, N] key = 8
// Output: 4 9
//
// Input: root[] = [10, 2, 11, 1, 5, N, N, N, N, 3, 6, N, 4, N, N] key = 11
// Output: 10 -1
//
// Input: root[] = [2, 1, 3] key = 3
// Output: 2 -1

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

public class ThreeInorderSuccessorPredecessor {

  // We will be using inorder traversal for this problem
  // where in when we visit a node, we will check if the node
  // is greater or smaller than the key, if its greater, check that
  // with the current successor and update accordingly
  //
  // if its smaller, update the predecessor
  public static void findPreSuc(Node node, Node[] pre, Node[] suc, int key) {

    if (node == null)
      return;

    findPreSuc(node.left, pre, suc, key);

    if (node.data > key) {
      if (suc[0] == null || (suc[0] != null && suc[0].data > node.data)) {
        suc[0] = node;
      }
    } else if (node.data < key) {
      pre[0] = node;
    }

    findPreSuc(node.right, pre, suc, key);

  }

}
