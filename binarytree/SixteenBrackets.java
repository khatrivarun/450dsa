// Problem Link: https://www.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1
// Construct a binary tree from a string consisting of parenthesis and integers. The whole input represents a binary tree.
// It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the roots value and a
// pair of parenthesis contains a child binary tree with the same structure. Always start to construct the left child node
// of the parent first if it exists. The integer values will be less than or equal to 10^5.
//
// Examples:
// Input: "1(2)(3)"
// Output: 2 1 3
//
// Input: "4(2(3)(1))(6(5))"
// Output: 3 2 1 4 5 6

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

public class SixteenBrackets {

  public static Node preOrderBuildtree(String codeWord, int[] counter) {
    // Case 1: If the character is a closing bracket
    // then the child node will be null
    if (codeWord.charAt(counter[0]) == ')')
      return null;

    // Case 2: If the character is a number
    // iterate and generate the whole number
    // and build the node from that number
    int number = 0;
    while (counter[0] < codeWord.length() && codeWord.charAt(counter[0]) != '(' && codeWord.charAt(counter[0]) != ')') {
      number *= 10;
      number += codeWord.charAt(counter[0]) - '0';

      counter[0] += 1;
    }

    Node root = new Node(number);

    // Case 3: If the node has children when it encounters open brackets
    // build the left tree if it exists
    if (counter[0] < codeWord.length() && codeWord.charAt(counter[0]) == '(') {
      counter[0] += 1;
      root.left = preOrderBuildtree(codeWord, counter);
      counter[0] += 1;
    }

    // Case 4: same 3 but for right tree if it exists
    if (counter[0] < codeWord.length() && codeWord.charAt(counter[0]) == '(') {
      counter[0] += 1;
      root.right = preOrderBuildtree(codeWord, counter);
      counter[0] += 1;
    }

    return root;
  }

  public static Node treeFromString(String s) {
    return preOrderBuildtree(s, new int[] { 0 });
  }

}
