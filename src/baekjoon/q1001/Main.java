package baekjoon.q1001;

import java.util.Scanner;

class Solution {

  public void solution() {
    try (Scanner sc = new Scanner(System.in)) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(a - b);
    }
  }
}

public class Main {

  public static void main(String[] args) {
    new Solution().solution();
  }
}
