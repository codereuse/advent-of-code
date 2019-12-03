import java.io.*;
import java.util.*;

public class Advent1 {

  public static void main(String[] args) {
    File input = new File("advent1.txt");
    try {
      Scanner sc = new Scanner(input);
      int totFuel = 0;
      while (sc.hasNext()) {
        int m = sc.nextInt();
        //System.out.println("Module mass: " + m);
        //System.out.println("Fuel for module: " + modFuel);
        totFuel += calculateFuel(m);
      }
      System.out.println("Fuel: " + totFuel);
      sc.close();
    } catch (FileNotFoundException e) {
    }
  }

  static int calculateFuel(int initFuel) {
    int totFuel = 0;
    while (initFuel > 0) {
      initFuel = (initFuel / 3) - 2;
      if (initFuel > 0) {
        totFuel += initFuel;
      }
    }
    return totFuel;
  }
}
