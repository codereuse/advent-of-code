import java.io.*;
import java.util.*;

class Advent2 {
  public static void main(String args[]) {
    File input = new File("advent2.txt");
    try {
      Scanner sc = new Scanner(input).useDelimiter(",");
      ArrayList<Integer> codes = new ArrayList<Integer>();
      while (sc.hasNextInt()) {
        int code = sc.nextInt();
        codes.add(code);
      }
      sc.close();
      codes.set(1, 12);
      codes.set(2, 2);
      System.out.println(calculateCode(codes));
    } catch (FileNotFoundException e) {
    }
  }

  static int calculateCode(ArrayList<Integer> codes) {
    int n = codes.size();
    int i = 0;
    while (i < n - 3) {
      int operation = codes.get(i);
      int pos1 = codes.get(i + 1);
      int pos2 = codes.get(i + 2);
      int pos3 = codes.get(i + 3);
      if (operation == 1) {
        codes.set(pos3, codes.get(pos1) + codes.get(pos2));
      } else if (operation == 2) {
        codes.set(pos3, codes.get(pos1) * codes.get(pos2));
      } else {
        break;
      }
      i += 4;
    }
    System.out.println(codes.toString());
    return codes.get(0);
  }
}
