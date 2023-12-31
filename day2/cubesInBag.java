package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * The Elf would first like to know which games would have been possible 
 * if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?
 */
public class cubesInBag {
  public static void main(String[] args) {
    File input = new File("./day2/inputCubes.txt");
    Scanner inputFileReader = null;
    try {
      inputFileReader = new Scanner(input);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(sumOfValidGameIds(inputFileReader));
  }

  public static int sumOfValidGameIds(Scanner fR) {
    if (fR == null) {
      System.out.println("NULL File Reader !!!");
      return 0;
    }
    int sum = 0;
    while (fR.hasNextLine()) {
      String line = fR.nextLine();
      line = removeCommasAndColon(line);
      String[] lineSplit = line.split(" ");
      int id = Integer.valueOf(lineSplit[1]);
      // gotta check each round
      String[] rounds = line.split(";");
      boolean goodGame = true;
      for (String r : rounds) {
        if (!validRound(r)) {
          goodGame = false;
          break;
        }
      }
      if (goodGame) {
        sum += id;
      }
    }
    return sum;
  }

  public static String removeCommasAndColon(String line) {
    String result = "";
    for (char c : line.toCharArray()) {
      if (c != ',' && c != ':') {
        result += c;
      }
    }
    return result;
  }

  public static boolean validRound(String r) {
    HashMap<String, Integer> count = new HashMap<>();
    count.put("red", 0);
    count.put("blue", 0);
    count.put("green", 0);
    // string array; loop through for keywords and use that to add appropriate
    // values
    String[] lineSplit = r.split(" ");
    for (int i = 1; i < lineSplit.length; i++) {
      String amount = lineSplit[i - 1];
      switch (lineSplit[i]) {
        case "red":
          Integer curr1 = count.get("red");
          count.replace("red", curr1 + Integer.valueOf(amount));
          break;
        case "blue":
          Integer curr2 = count.get("blue");
          count.replace("blue", curr2 + Integer.valueOf(amount));
          break;
        case "green":
          Integer curr3 = count.get("green");
          count.replace("green", curr3 + Integer.valueOf(amount));
          break;
      }
    }

    return possible(count.get("red"), count.get("green"), count.get("blue"));
  }

  public static boolean possible(Integer i, Integer j, Integer k) {
    return i <= 12 && j <= 13 && k <= 14;
  }
}
