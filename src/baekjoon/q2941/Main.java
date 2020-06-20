package baekjoon.q2941;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {

  private static String input;

  public void solution() {
    List<String> croatianAlphabets = Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

    try (Scanner sc = new Scanner(System.in)) {
      input = sc.nextLine();
    }

    croatianAlphabets.forEach(alphabet -> {
      input = input.replaceAll(alphabet, "*");
    });

    System.out.println(input.length());
  }
}

public class Main {

  public static void main(String[] args) {
    new Solution().solution();
  }
}
