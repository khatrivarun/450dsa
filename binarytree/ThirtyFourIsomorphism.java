// Problem Link:
// https://www.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
// Given two Binary Trees. Check whether they are Isomorphic or not.
// Two trees are called isomorphic if one can be obtained from another by a
// series of flips, i.e. by swapping left and right children of several nodes.
// Any number of nodes at any level can have their children swapped. Two empty
// trees are isomorphic.
//
// Examples:
// Input: root1[] = [1, 2, 3, 4, 5, 7, 6, N, 7, 8], root2[] = [1, 3, 2, N, 6, 4,
// 5, 8, 7]
// Output: true
//
// Input: root1[] = [1, 2, 3, 4], root2[] = [1, 3, 2, 4]
// Output: false
//
// Input: root1[] = [1, 2, 3, 4], root2[] = [1, 3, 2, N, N, N, 4]
// Output: true

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class ThirtyFourIsomorphism {

  boolean isIsomorphic(Node root1, Node root2) {

    // Step 1: Check if they are both null
    // at the same time else return false
    if (root1 == null && root2 == null)
      return true;
    if (root1 == null || root2 == null)
      return false;

    // Step 2: Check if node data
    // matches else return false
    if (root1.data != root2.data)
      return false;

    // Step 3: recursively check if left subtrees and right subtrees are isomorphic
    // or are they swapped out and isomorphic in that sense
    return ((isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
        (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left)));
  }

}
