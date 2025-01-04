/*
 * Problem Link: https://www.geeksforgeeks.org/problems/unoccupied-computers-1646661078/1
 * A cafe has N computers. Several customers come to the cafe to use these computers.
 * A customer will be serviced only if there is any unoccupied computer at the moment
 * the customer visits the cafe. If there is no unoccupied computer, the customer 
 * leaves the cafe. 
 *
 * You are given an integer N representing the number of computers in the cafe and a
 * sequence of uppercase letters S. Every letter in S occurs exactly two times.
 * The first occurrence denotes the arrival of a customer and the second 
 * occurrence denotes the departure of the same customer if he gets allocated the 
 * computer. 
 *
 * You have to find the number of customers that walked away without using a computer.
 *
 * Examples:
 * Input: N = 3 S = GACCBDDBAGEE
 * Output: 1
 *
 * Input: N = 1 S = ABCBAC
 * Output: 2
 */

import java.util.HashMap;

public class ThirtyNineComputers {

  public static int solve(int n, String s) {

    HashMap<String, Boolean> cache = new HashMap<>();
    int allowed = n, result = 0;

    // Idea here is to push person
    // and whether they got a computer
    // assigned on first occurence in cache
    //
    // on second occurence, check cache
    // if they got a computer assigned and
    // update result accordingly.
    for (int i = 0; i < s.length(); i++) {
      String person = s.substring(i, i + 1);

      if (cache.containsKey(person)) {
        if (cache.remove(person))
          allowed += 1;
        else
          result += 1;
      } else {
        cache.put(person, allowed > 0);
        if (allowed > 0)
          allowed -= 1;
      }
    }

    return result;

  }

}
