import java.io.*;
import java.util.*;

class Solution {
  public static void main(String args[]) {
    File input = new File("input.txt");
    try {
      Scanner sc = new Scanner(input).useDelimiter(",");
      ArrayList<Integer> codes = new ArrayList<Integer>();
      while (sc.hasNextInt()) {
        int code = sc.nextInt();
        codes.add(code);
      }
      sc.close();
      codes.set(codes.get(1), 1);
      runDiagnostic(codes);
    } catch (FileNotFoundException e) {
    }
  }

  static void runDiagnostic(ArrayList<Integer> codes) {
    int n = codes.size();
    int i = 2;
    while (i < n) {
      int op = codes.get(i);
      // System.out.println(op);
      if (op == 1) {
        int pos1 = codes.get(i + 1);
        // System.out.println("Pos1: " + pos1);
        int pos2 = codes.get(i + 2);
        // System.out.println("Pos2: " + pos2);
        int pos3 = codes.get(i + 3);
        // System.out.println("Pos3: " + pos3);
        // System.out.println("s1: " + codes.get(pos1));
        // System.out.println("s2: " + codes.get(pos2));
        codes.set(pos3, codes.get(pos1) + codes.get(pos2));
        i += 4;
      } else if (op == 2) {
        int pos1 = codes.get(i + 1);
        int pos2 = codes.get(i + 2);
        int pos3 = codes.get(i + 3);
        codes.set(pos3, codes.get(pos1) * codes.get(pos2));
        i += 4;
      } else if (op == 3) {
        i += 2;
      } else if (op == 4) {
        System.out.println("Output: " + codes.get(codes.get(i + 1)));
        i += 2;
      } else if (op == 99) {
        break;
      } else {
        // decideOp(op);
        if (op % 100 == 1) {
          op /= 100;
          int mod1 = op % 10;
          op /= 10;
          int mod2 = op % 10;
          int s1 = (mod1 == 1) ? codes.get(i + 1) : codes.get(codes.get(i + 1));
          int s2 = (mod2 == 1) ? codes.get(i + 2) : codes.get(codes.get(i + 2));
          int pos = codes.get(i + 3);
          codes.set(pos, s1 + s2);
          i += 4;
        } else if (op % 100 == 2) {
          op /= 100;
          int mod1 = op % 10;
          op /= 10;
          int mod2 = op % 10;
          int s1 = (mod1 == 1) ? codes.get(i + 1) : codes.get(codes.get(i + 1));
          int s2 = (mod2 == 1) ? codes.get(i + 2) : codes.get(codes.get(i + 2));
          int pos = codes.get(i + 3);
          codes.set(pos, s1 * s2);
          i += 4;
        } else if (op % 100 == 3) {
          i += 2;
        } else if (op % 100 == 4) {
          op /= 100;
          int output = (op == 1) ? codes.get(i + 1) : codes.get(codes.get(i + 1));
          System.out.println("Output: " + output);
          i += 2;
        } else if (op % 100 == 99) {
          break;
        } else {
          System.out.println("Aici nu ar trebui ajuns. Pozitia: " + i + ". Codul: " + op);
          break;
        }
      }
    }
  }

  static void decideOp(int code) {
    System.out.println("Code: " + code % 100);
  }
}
