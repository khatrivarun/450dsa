// Problem Link: https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
// Given a Binary Search Tree. Your task is to complete the function which will return
// the kth largest element without doing any modification in the Binary Search Tree.

import java.util.LinkedList;
import java.util.List;

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class ElevenKthLargest {

  // Construct a reverse sorted list out of the tree
  public void inOrderTraversal(Node node, List<Integer> list) {
    if (node == null)
      return;

    inOrderTraversal(node.right, list);

    list.add(node.data);

    inOrderTraversal(node.left, list);
  }

  // Now that we have a sorted list
  // return the Kth element
  public int kthLargest(Node root, int k) {

    List<Integer> inorderTraversal = new LinkedList<>();

    inOrderTraversal(root, inorderTraversal);

    if (k > inorderTraversal.size())
      return -1;
    else
      return inorderTraversal.get(k - 1);

  }

}
