// Problem Link: https://www.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1
// Given a Binary Search Tree that contains unique positive integer values greater than 0.
// The task is find if the BST contains a dead end. Here Dead End means a leaf node, at
// which no other integer can be inserted.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class NineteenDeadEnd {
  // Step 1: Build a HashMap to keep track of leaves and List of all nodes
  public static void inOrderTraversal(Node node, List<Integer> nodesList, HashMap<Integer, Boolean> nodesCache) {
    if (node == null)
      return;

    inOrderTraversal(node.left, nodesList, nodesCache);

    nodesList.add(node.data);
    if (node.left == null && node.right == null)
      nodesCache.put(node.data, true);
    else
      nodesCache.put(node.data, false);

    inOrderTraversal(node.right, nodesList, nodesCache);
  }

  // Step 2: Check if leave nodes have
  // +1 and -1 of their values for the
  // dead end condition
  public static boolean isDeadEnd(Node root) {
    List<Integer> nodesList = new ArrayList<>();
    HashMap<Integer, Boolean> nodesCache = new HashMap<>();
    nodesCache.put(0, false);

    inOrderTraversal(root, nodesList, nodesCache);

    for (int i = 0; i < nodesList.size(); i++) {
      int value = nodesList.get(i);

      if (nodesCache.get(value) && nodesCache.containsKey(value - 1) && nodesCache.containsKey(value + 1))
        return true;
    }

    return false;
  }
}
