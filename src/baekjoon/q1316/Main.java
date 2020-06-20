package baekjoon.q1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

  private Boolean isGroupWord(String word) {
    Map<Character, Integer> groupWordMap = new HashMap<>();

    for (int currentIndex = 0; currentIndex < word.length(); currentIndex++) {
      Integer previousIndex = groupWordMap.get(word.charAt(currentIndex));
      Character currentCharacter = word.charAt(currentIndex);

      if (Objects.isNull(previousIndex) || currentIndex == previousIndex + 1) {
        groupWordMap.put(currentCharacter, currentIndex);
      } else {
        return false;
      }
    }

    return true;
  }

  public void solution(int inputCount, List<String> inputStringArray) {
    System.out.println(inputStringArray.stream().filter(this::isGroupWord).count());
  }
}

public class Main {

  private static final List<String> inputStringArray = new ArrayList<>();
  private static int inputCount;

  private static void doInput() throws IOException {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
      inputCount = Integer.parseInt(in.readLine());
      for (int i = 0; i < inputCount; i++) {
        inputStringArray.add(in.readLine());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    doInput();
    new Solution().solution(inputCount, inputStringArray);
  }
}
