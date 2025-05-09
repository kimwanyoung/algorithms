package 백준.nm과k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m, k;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int max = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, 0, 0);
  
    System.out.println(max);
  }

  static void dfs(int y, int x, int depth, int sum) {
    if(depth == k) {
      max = Math.max(max, sum);
      return;
    }

    for(int i = y; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(!visited[i][j]) {
          if(check(i, j)){
            visited[i][j] = true;
            dfs(i, j, depth + 1, sum + arr[i][j]);
            visited[i][j] = false;
          }
        }
      }
    }
  }

  static boolean check(int y, int x) {
    for(int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
        if(visited[ny][nx]) {
          return false;
        }
      }
    }
    return true;
  }
}
