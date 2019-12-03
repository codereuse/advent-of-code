import java.awt.Point;
import java.io.*;
import java.util.*;

class Solution {
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
        Point p = entry.getKey();
        int manhattanDistance = (int) Math.abs(p.getX() - 0) + (int) Math.abs(p.getY() - 0);
        if (manhattanDistance < result) {
          result = manhattanDistance;
        }
      }
    }
    System.out.println(result);
  }

  public static HashMap<Point, Integer> drawFirstCable(List<String> input) {
    HashMap<Point, Integer> map = new HashMap<Point, Integer>();
    int x = 0;
    int y = 0;
    for (String s : input) {
      Character direction = s.charAt(0);
      int steps = Integer.parseInt(s.substring(1));
      for (int i = 1; i <= steps; ++i) {
        if (direction == 'R') {
          x += 1;
          map.put(new Point(x, y), 1);
        } else if (direction == 'D') {
          y -= 1;
          map.put(new Point(x, y), 1);
        } else if (direction == 'L') {
          x -= 1;
          map.put(new Point(x, y), 1);
        } else if (direction == 'U') {
          y += 1;
          map.put(new Point(x, y), 1);
        }
      }
    }
    return map;
  }
}
