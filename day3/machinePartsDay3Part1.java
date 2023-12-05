package day3;

/**
 * machinePartsDay3Part1
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class machinePartsDay3Part1 {

  // make a matrix to check adjacency
  // matrix of characters? // will need a function to turn the characters back
  // into numbers
  // if a symbol below
  public static void main(String[] args) {
    File inFile = new File("./day3/input.txt");
    Scanner reader = null;
    try {
      reader = new Scanner(inFile);
    } catch (Exception e) {
      System.out.println("Null Reader!");
      // TODO: handle exception
    }

    System.out.println(sumOfPartNums(reader));
  }

  public static int sumOfPartNums(Scanner reader) {
    int sum = 0;
    // make the matrix
    char[][] matrix = new char[140][140];
    for (int i = 0; i < 140; i++) {
      matrix[i] = reader.nextLine().toCharArray();
      for (int j = 0; j < 140; j++) {
        if (Character.isDigit(matrix[i][j])) {
          sum += evaluateNum(matrix, i, j);
        }
      }
    }
    return sum;
  }

  public static int evaluateNum(char[][] matrix, int i, int j) {
    int value = 0;
    int start = j;
    String numString = "";
    while (Character.isDigit(matrix[i][j])) {
      numString += matrix[i][j];
      j++;
    }
    int num = Integer.valueOf(numString);
    int numLength = j - start;
    if (isAPart(matrix, i, start, numLength))
      return value;
  }

  public static boolean isAPart(char[][] matrix, int row, int startingColOfNum, int length) {

  }
}