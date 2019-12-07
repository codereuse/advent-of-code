class Solution {
  public static void main(String args[]) {
    int start = 156218;
    int end = 652527;
    int cnt = 0;

    for (int i = start; i <= end; ++i) {
      if (isValidPassword(i)) {
        cnt++;
      }
    }
    System.out.println(cnt);
    // System.out.println(isValidPassword(123789));
  }

  public static boolean isValidPassword(int password) {
    int previosDigit = password % 10;
    boolean adjacent = false;
    while (password > 0) {
      password /= 10;
      int currentDigit = password % 10;
      if (currentDigit > previosDigit) {
        return false;
      } else if (currentDigit == previosDigit) {
        adjacent = true;
      }
      previosDigit = currentDigit;
    }

    return adjacent;
  }
}
