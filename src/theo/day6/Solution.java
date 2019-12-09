import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
  public static void main(String args[]) {
    File input = new File("");
    try {
      Scanner sc = new Scanner(input);
      while (sc.hasNextLine()) {
        List<String> nodes = Arrays.asList(sc.nextLine().split(")"));
      }
      sc.close();
    } catch (FileNotFoundException e) {
    }
  }

  private class Node {
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
  }
}
