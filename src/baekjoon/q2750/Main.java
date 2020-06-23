package baekjoon.q2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

  public void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, start, mid, end);
    }
  }

  public void merge(int[] arr, int start, int mid, int end) {
    int leftIndex = start;
    int rightIndex = mid + 1;
    int tempIndex = start;
    int[] temp = new int[arr.length];

    while (leftIndex <= mid && rightIndex <= end) {
      temp[tempIndex++] = (arr[leftIndex] < arr[rightIndex])
          ? arr[leftIndex++]
          : arr[rightIndex++];
    }

    while (leftIndex <= mid) {
      temp[tempIndex++] = arr[leftIndex++];
    }
    while (rightIndex <= end) {
      temp[tempIndex++] = arr[rightIndex++];
    }

    if (tempIndex - start >= 0) {
      System.arraycopy(temp, start, arr, start, tempIndex - start);
    }
  }

  public void solution(int inputCount, int[] inputArray) {
    mergeSort(inputArray, 0, inputArray.length - 1);
    Arrays.stream(inputArray).forEach(i -> System.out.print(i + " "));
  }
}

public class Main {

  private static int[] inputArray;
  private static int inputCount;

  private static void doInput() throws IOException {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
      inputCount = Integer.parseInt(in.readLine());
      inputArray = new int[inputCount];

      for (int i = 0; i < inputCount; i++) {
        inputArray[i] = Integer.parseInt(in.readLine());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    doInput();
    new Solution().solution(inputCount, inputArray);
  }
}
