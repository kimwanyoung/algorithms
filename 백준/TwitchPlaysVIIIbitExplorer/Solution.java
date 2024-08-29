package 백준.TwitchPlaysVIIIbitExplorer;

import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, S;
    static String id;
    static final int[] row = {-1, 1, 0, 0};
    static final int[] col = {0, 0, -1, 1};
    static final char[] alpha = {'U', 'D', 'L', 'R'};

    static class Location {
        int x, y;
        String move;

        Location(int x, int y) {
            this(x, y, "");
        }

        Location(int x, int y, String move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    static int ans = Integer.MAX_VALUE;
    static Map<Character, List<Location>> charLocations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String rowString = br.readLine().split(" ")[0];
            for (int j = 0; j < M; j++) {
                char ch = rowString.charAt(j);
                charLocations.computeIfAbsent(ch, k -> new ArrayList<>()).add(new Location(i, j));
            }
        }

        id = br.readLine().split(" ")[0];

        int[] characterCounts = countCharacterOccurrences(id);

        ans = calculateMinCount(characterCounts);

        String resultMoves = calculateResultMoves();

        System.out.println(ans + " " + resultMoves.length());
        System.out.println(resultMoves);
    }

    private static int[] countCharacterOccurrences(String id) {
        int[] characterCounts = new int[27];
        for (char c : id.toCharArray()) {
            characterCounts[c - 'a']++;
        }
        return characterCounts;
    }

    private static int calculateMinCount(int[] characterCounts) {
        int minPathCount = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            if (characterCounts[i] > 0) {
                char character = (char) ('a' + i);
                if (!charLocations.containsKey(character)) {
                    return 0;
                }
                minPathCount = Math.min(minPathCount, charLocations.get(character).size() / characterCounts[i]);
            }
        }
        return minPathCount;
    }

    private static String calculateResultMoves() {
        StringBuilder moves = new StringBuilder();
        Location start = new Location(0, 0);

        for (int i = 0; i < ans; i++) {
            for (char c : id.toCharArray()) {
                Location end = charLocations.get(c).remove(0);
                moves.append(bfs(start, end)).append("P");
                start = end;
            }
        }

        moves.append(bfs(start, new Location(N - 1, M - 1)));
        return moves.toString();
    }

    private static String bfs(Location start, Location end) {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Location(start.x, start.y, ""));
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Location cur = queue.poll();
            if (cur.x == end.x && cur.y == end.y) return cur.move;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + row[i];
                int ny = cur.y + col[i];
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Location(nx, ny, cur.move + alpha[i]));
                }
            }
        }

        return "";
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
