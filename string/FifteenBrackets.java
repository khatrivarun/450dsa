/*
 * Problem Link: https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
 * You are given a string s representing an expression containing various types 
 * of brackets: {}, (), and []. Your task is to determine whether the brackets
 * n the expression are balanced. A balanced expression is one where every
 * every opening bracket has a corresponding closing bracket in the correct
 * order.
 *
 * Examples:
 * Input: s = "{([])}"
 * Output: true
 *
 * Input: s = "()"
 * Output: true
 *
 * Input: s = "([]"
 * Output: false
 */

import java.util.Stack;

public class FifteenBrackets {

  static boolean isParenthesisBalanced(String s) {

    Stack<Character> stack = new Stack<>();

    // Idea is simple, if its an opening bracket
    // push it on stack and if its a closing bracket
    // pop the stack and check if the brackets match
    // provided the stack is not empty
    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);

      if (character == '{' || character == '(' || character == '[') {
        stack.push(character);
      } else {
        if (stack.isEmpty())
          return false;
        Character poppedBracket = stack.pop();

        if (poppedBracket == '(') {
          if (character != ')') {
            return false;
          }
        } else if (poppedBracket == '[') {
          if (character != ']') {
            return false;
          }
        } else {
          if (character != '}') {
            return false;
          }
        }
      }
    }

    return stack.isEmpty();

  }

}
