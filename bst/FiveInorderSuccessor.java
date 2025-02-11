// Problem Link: https://www.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
// Given a Binary Tree, complete the function to populate the next pointer for all nodes.
// The next pointer for every node should point to the Inorder successor of the node.
//
// Note: The node having no in-order successor will be pointed to -1. You don't have to add -1 explicitly, the driver code will take care of this.

class Node {
  int data;
  Node left;
  Node right;
  Node next;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class FiveInorderSuccessor {

  Node nextNode = null;

  // Since inorder traversal produces an
  // increasing order of access, reversing
  // or completing right subtree and then
  // left subtree will reverse the order
  // of access
  //
  // After traversing in reverse order
  // we can keep a track of the next element
  // initially null and set the next element
  // as we visit the nodes.
  public void inorderSuccessorLinkage(Node node) {

    if (node == null)
      return;

    inorderSuccessorLinkage(node.right);

    node.next = nextNode;
    nextNode = node;

    inorderSuccessorLinkage(node.left);

  }

  public void populateNext(Node root) {
    inorderSuccessorLinkage(root);
  }

}
