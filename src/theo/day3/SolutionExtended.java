import java.awt.Point;
import java.io.*;
import java.util.*;

class SolutionExtended {
  public static void main(String args[]) {
    File input = new File("input.txt");
    try {
      Scanner sc = new Scanner(input);
      List<String> firstWireCoordinates = Arrays.asList(sc.nextLine().split(","));
      List<String> secondWireCoordinates = Arrays.asList(sc.nextLine().split(","));
      calculateMinManhattanDistance(
          drawFirstCable(firstWireCoordinates), drawFirstCable(secondWireCoordinates));
      sc.close();
    } catch (FileNotFoundException e) {
    }
  }

  public static void calculateMinManhattanDistance(
      HashMap<Point, Integer> firstPath, HashMap<Point, Integer> secondPath) {
    int result = Integer.MAX_VALUE;
    for (Map.Entry<Point, Integer> entry : secondPath.entrySet()) {
      if (firstPath.containsKey(entry.getKey())) {
        int s2 = entry.getValue();
        int s1 = firstPath.get(entry.getKey());
        if (s1 + s2 < result) {
          result = s1 + s2;
        }
      }
    }
    System.out.println(result);
  }

  public static HashMap<Point, Integer> drawFirstCable(List<String> input) {
    HashMap<Point, Integer> map = new HashMap<Point, Integer>();
    int x = 0;
    int y = 0;
    int cnt = 0;
    for (String s : input) {
      Character direction = s.charAt(0);
      int steps = Integer.parseInt(s.substring(1));
      for (int i = 1; i <= steps; ++i) {
        if (direction == 'R') {
          x += 1;
          map.put(new Point(x, y), ++cnt);
        } else if (direction == 'D') {
          y -= 1;
          map.put(new Point(x, y), ++cnt);
        } else if (direction == 'L') {
          x -= 1;
          map.put(new Point(x, y), ++cnt);
        } else if (direction == 'U') {
          y += 1;
          map.put(new Point(x, y), ++cnt);
        }
      }
    }
    return map;
  }
}
