import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) {
    File input = new File("");
    try {
      Scanner sc = new Scanner(input);
      while (sc.hasNext()) {
        int i = sc.nextInt();
      }
      sc.close();
    } catch (FileNotFoundException e) {
    }
  }
}
