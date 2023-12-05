package day3;

import java.util.Arrays;
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
    for (int i = 0; i < matrix.length; i++) {
      matrix[i] = reader.nextLine().toCharArray();
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (Character.isDigit(matrix[i][j])) {
          int start = j;
          String numString = "";
          while (j < matrix[0].length && Character.isDigit(matrix[i][j])) {
            numString += matrix[i][j];
            j++;
          }
          int num = Integer.valueOf(numString);
          int numLength = j - start;
          sum += evaluateNum(matrix, i, start, num, numLength);
        }
      }
    }
    return sum;
  }

  public static int evaluateNum(char[][] matrix, int i, int start, int num, int numLength) {
    int value = 0;
    if (isAPart(matrix, i, start, numLength)) {
      value = num;
    }
    return value;
  }

  public static boolean isAPart(char[][] matrix, int row, int startingColOfNum, int length) {
    boolean up = false, down = false, left = false, right = false, diag = false;
    if (row >= 1) {
      diag = checkLeft(matrix, row - 1, startingColOfNum, length);
      if (!diag) {
        diag = checkRight(matrix, row - 1, startingColOfNum, length);
      }
      up = checkUp(matrix, row, startingColOfNum, length);
    }
    if (row < matrix.length - 1) {
      if (!diag) {
        diag = checkLeft(matrix, row + 1, startingColOfNum, length);
      }
      if (!diag) {
        diag = checkRight(matrix, row + 1, startingColOfNum, length);
      }
      down = checkDown(matrix, row, startingColOfNum, length);
    }
    if (startingColOfNum + length < matrix[0].length) {
      right = checkRight(matrix, row, startingColOfNum, length);
    }
    if (startingColOfNum > 0) {
      left = checkLeft(matrix, row, startingColOfNum, length);
    }
    return up || down || left || right || diag;
  }

  public static boolean checkUp(char[][] matrix, int row, int startingColOfNum, int length) {
    int upperbound = startingColOfNum + length;
    for (int i = startingColOfNum; i < upperbound; i++) {
      if (isASymbol(matrix[row - 1][i])) {
        return true;
      }
    }
    return false;
  }

  public static boolean checkDown(char[][] matrix, int row, int startingColOfNum, int length) {
    int upperbound = startingColOfNum + length;
    for (int i = startingColOfNum; i < upperbound; i++) {
      if (isASymbol(matrix[row + 1][i])) {
        return true;
      }
    }
    return false;
  }

  public static boolean checkRight(char[][] matrix, int row, int startingColOfNum, int length) {
    if (startingColOfNum + length >= matrix[0].length) {
      return false;
    }
    return isASymbol(matrix[row][startingColOfNum + length]);
  }

  public static boolean checkLeft(char[][] matrix, int row, int startingColOfNum, int length) {
    if (startingColOfNum == 0) {
      return false;
    }
    return isASymbol(matrix[row][startingColOfNum - 1]);
  }

  public static boolean isASymbol(char c) {
    return !Character.isDigit(c) && c != '.';
  }
}