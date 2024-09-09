package 이론.최단경로.다익스트라;

public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {
                {INF, INF, INF, INF, INF, INF},
                {INF, 0, 1, 5, INF, INF},
                {INF, 7, 0, 2, 2, INF},
                {INF, 2, INF, 0, INF, 6},
                {INF, INF, 2, INF, 0, INF},
                {INF, INF, INF, 1, INF, 0},
        };

        for(int k = 1; k <= n; k++) {
            for(int a = 1; a <= n; a++) {
                for(int b = 1; b <= n; b++) {
                    int cost = graph[a][k] + graph[k][b];
                    graph[a][b] = Math.min(graph[a][b], cost);
                }
            }
        }
    }
}
