package 백준.l1로2만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  static class Node {
    int n;
    List<Integer> history;

    public Node(int n, List<Integer> history) {
      this.n = n;
      this.history = history;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    bfs(n);
  }

  static void bfs(int n) {
    Queue<Node> queue = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];

    List<Integer> history = new ArrayList<>();
    history.add(n);
    queue.offer(new Node(n, history));
    visited[n] = true;
    while(!queue.isEmpty()) {
      Node current = queue.poll();
      if(current.n == 1) {
        System.out.println(current.history.size() - 1);
        for(int i = 0; i < current.history.size(); i++) {
          System.out.print(current.history.get(i) + " ");
        }
        return;
      }
      
      if(current.n % 2 == 0) {
        List<Integer> nextHistory = new ArrayList<>(current.history);
        nextHistory.add(current.n / 2);
        queue.offer(new Node(current.n / 2, nextHistory));
        visited[current.n / 2] = true;
      }

      if(current.n % 3 == 0) {
        List<Integer> nextHistory = new ArrayList<>(current.history);
        nextHistory.add(current.n / 3);
        queue.offer(new Node(current.n / 3, nextHistory));
        visited[current.n / 3] = true;
      }

      if(!visited[current.n - 1]) {
        List<Integer> nextHistory = new ArrayList<>(current.history);
        nextHistory.add(current.n - 1);
        queue.offer(new Node(current.n - 1, nextHistory));
        visited[current.n - 1] = true;
      }
    }
  }
}
