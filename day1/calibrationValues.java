package day1;

public class calibrationValues {
  public static String[] wordNums = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

  public static void main(String[] args) {

  }

  public static int computeSum(String s) {
    int start = 0;
    int end = s.indexOf('\n');
    int sum = 0;
    while (end != -1) {
      sum += computeLine(start, end, s);
      start = end + 1;
      end = s.indexOf('\n', end + 1);
    }
    return sum;
  }

  public static int computeLine(int start, int end, String s) {
    String num = "";
    Integer firstNum = null;
    Integer lastNum = null;
    String temp = s.substring(start, end);
    char[] sArr = temp.toCharArray();
    boolean firstFound = false;
    int i = 0;
    for (char c : sArr) {
      if (isDigit(i, temp)) {
        String digit = "";
        if (Character.isDigit(c)) {
          digit += c;
        } else {
          digit += getNumFromWord(temp, i);
        }
        if (!firstFound) {
          firstNum = Integer.valueOf("" + digit);
          firstFound = true;
        }
        lastNum = Integer.valueOf("" + digit);
      }
      i++;
    }
    int result = Integer.valueOf(num + firstNum + lastNum);
    System.out.println(result);
    return result;
  }

  public static boolean isDigit(int i, String s) {
    String temp = s.substring(i);
    if (Character.isDigit(temp.charAt(0)))
      return true;
    else {
      for (String num : wordNums) {
        if (temp.startsWith(num)) {
          return true;
        }
      }
    }
    return false;
  }

  public static int getNumFromWord(String s, int i) {
    String temp = s.substring(i);
    String num = "";
    for (String n : wordNums) {
      if (temp.startsWith(n))
        num = n;
    }
    switch (num) {
      case "one":
        return 1;
      case "two":
        return 2;
      case "three":
        return 3;
      case "four":
        return 4;
      case "five":
        return 5;
      case "six":
        return 6;
      case "seven":
        return 7;
      case "eight":
        return 8;
      case "nine":
        return 9;
      default:
        System.out.println("HELP!" + num);
        return 0;
    }
  }
}
