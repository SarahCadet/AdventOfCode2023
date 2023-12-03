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
    try {

    } catch (Exception e) {
      System.out.println("Null Reader!");
      // TODO: handle exception
    }
    System.out.println(sumOfPartNums());
  }

  public static int sumOfPartNums() {
    int sum = 0;
    return sum;
  }
}