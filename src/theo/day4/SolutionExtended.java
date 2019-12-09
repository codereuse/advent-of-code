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
    System.out.println(isValidPassword(122233));
  }

  public static boolean isValidPassword(int password) {
    int[] digits = new int[10];
    boolean adjacent = false;

    int previousDigit = password % 10;
    digits[previousDigit] += 1;

    while (password > 0) {
      password /= 10;
      int currentDigit = password % 10;
      // System.out.println("Previous: " + previousDigit);
      // System.out.println("Current: " + currentDigit);
      digits[currentDigit] += 1;

      if (currentDigit > previousDigit) {
        return false;
      }
      previousDigit = currentDigit;
    }

    for (int i = 0; i < 10; ++i) {
      if (digits[i] == 2) adjacent = true;
    }

    return adjacent;
  }
}
