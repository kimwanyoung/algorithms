package 이론.최단경로.다익스트라;

import java.util.*;

public class Dijkstra {

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        List<Node>[] graph = new ArrayList[11];
        int[] distance = new int[10];

        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.offer(new Node(1, 0));
        distance[1] = 0;
        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(distance[current.v] < current.cost) continue;

            for(Node next : graph[current.v]) {
                int nextCost = current.cost + next.cost;
                if(nextCost < distance[next.v]) {
                    distance[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
    }
}
