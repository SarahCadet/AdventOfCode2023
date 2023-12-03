import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * The Elf would first like to know which games would have been possible 
 * if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?
 */
public class cubesPart2 {
  public static void main(String[] args) {
    File input = new File("./day2/inputCubes.txt");
    Scanner inputFileReader = null;
    try {
      inputFileReader = new Scanner(input);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(sumOfPowers(inputFileReader));
  }

  public static int sumOfPowers(Scanner fR) {
    if (fR == null) {
      System.out.println("NULL File Reader !!!");
      return 0;
    }
    int sum = 0;
    while (fR.hasNextLine()) {
      String line = fR.nextLine();
      line = removeCommasSemiAndColon(line);
      System.out.println(line);
      sum += gamePower(line);

    }
    return sum;
  }

  public static String removeCommasSemiAndColon(String line) {
    String result = "";
    for (char c : line.toCharArray()) {
      if (c != ';' && c != ',' && c != ':') {
        result += c;
      }
    }
    return result;
  }

  public static int gamePower(String r) {
    HashMap<String, Integer> count = new HashMap<>();
    count.put("red", Integer.MIN_VALUE);
    count.put("blue", Integer.MIN_VALUE);
    count.put("green", Integer.MIN_VALUE);
    // string array; loop through for keywords and use that to add appropriate
    // values
    String[] lineSplit = r.split(" ");
    for (int i = 1; i < lineSplit.length; i++) {
      Integer amount = null;
      switch (lineSplit[i]) {
        case "red":
          amount = Integer.valueOf(lineSplit[i - 1]);
          Integer curr1 = count.get("red");
          if (amount > curr1) {
            count.replace("red", amount);
          }
          break;
        case "blue":
          amount = Integer.valueOf(lineSplit[i - 1]);
          Integer curr2 = count.get("blue");
          if (amount > curr2) {
            count.replace("blue", amount);
          }
          break;
        case "green":
          amount = Integer.valueOf(lineSplit[i - 1]);
          Integer curr3 = count.get("green");
          if (amount > curr3) {
            count.replace("green", amount);
          }
          break;
      }
    }
    int power = count.get("red") * count.get("blue") * count.get("green");
    System.out.println(power);
    return power;
  }
}
