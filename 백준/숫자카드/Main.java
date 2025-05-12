package 백준.숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  static int[] cards;
  static int[] userCards;
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      cards = new int[n];
      for(int i = 0; i < n; i++) {
          cards[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(cards);
      int m = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      userCards = new int[m];
      for(int i = 0; i < m; i++) {
          userCards[i] = Integer.parseInt(st.nextToken());
      }

      for(int i = 0; i < m; i++) {
          if(binarySearch(userCards[i])) {
              System.out.print(1 + " ");
          } else {
              System.out.print(0 + " ");
          }
      }
  }

  static boolean binarySearch(int target) {
      int left = 0;
      int right = cards.length - 1;

      while(left <= right) {
          int mid = (left + right) / 2;
          if(cards[mid] == target) {
              return true;
          } else if(cards[mid] < target) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return false;
  }
}
