package src.theo.day6;
import java.io.*;
import java.util.*;

class Solution {
  static int result = 0;
  static HashMap<String, Node> map = new HashMap<>();
  public static void main(String args[]) {
    File input = new File("input.txt");
    try {
      Scanner sc = new Scanner(input);
      Node root = null;
      while (sc.hasNextLine()) {
        List<String> nodes = Arrays.asList(sc.nextLine().split("\\)"));
        String parentCode = nodes.get(0);
        String childCode = nodes.get(1);
        if (!map.containsKey(parentCode)) {
          Node node = new Node(parentCode);
          node.addChild(new Node(childCode));
          map.put(parentCode, node);
          if (parentCode.equalsIgnoreCase("COM")) {
            root = node;
          }
        } else {
          Node node = map.get(parentCode);
          node.addChild(new Node(childCode));
          map.put(parentCode, node);
        }
      }
      calculate(root, 0);
      System.out.println(result);
      sc.close();
    } catch (FileNotFoundException e) {
    }
  }

  private static void calculate(Node node, int level) {
    if (node.getChildren().size() == 0) {
      return;
    } else {
      level++;
      for (Node child : node.getChildren()) {
        result += level;
        if (map.containsKey(child.getData())) {
          calculate(map.get(child.getData()), level);
        }
      }
    }
  }

  private static class Node {
    private String data;
    private List<Node> children = new ArrayList<>();
    private Node parent = null;

    public Node(String data) {
      this.data = data;
    }

    public void addChild(Node child) {
      child.setParent(this);
      this.children.add(child);
    }

    private void setParent(Node parent) {
      this.parent = parent;
    }

    public List<Node> getChildren() {
      return this.children;
    }

    public String getData() {
      return this.data;
    }
  }
}
