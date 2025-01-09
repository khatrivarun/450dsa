/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent
 * -mobile-numeric-keypad-sequence0547/1
 * Given a sentence in the form of a string in uppercase, convert it into its
 * equivalent mobile numeric keypad sequence. Please note there might be spaces
 * in between the words in a sentence and we can print spaces by pressing 0.
 *
 * Examples:
 * S = "GFG"
 * Output: 43334
 *
 * S = "HEY U"
 * Output: 4433999088
 */

public class NineteenPhone {

  String printSequence(String S) {
    StringBuilder resultBuilder = new StringBuilder();

    String[] dictionary = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666",
        "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

    // ... pretty self explanatory
    for (int i = 0; i < S.length(); i++) {
      Character letter = S.charAt(i);

      if (letter == ' ') {
        resultBuilder.append("0");
      } else {
        int index = letter - 'A';
        resultBuilder.append(dictionary[index]);
      }
    }

    return resultBuilder.toString();
  }

}
