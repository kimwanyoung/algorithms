package 프로그래머스.서버증설횟수;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static class Server{
		int time;

		public Server(int time) {
			this.time = time;
		}
	}
	public static int solution(int[] players, int m, int k) {
		Queue<Server> servers = new LinkedList<>();
		int count = 0;
		for(int i = 0; i < players.length; i++) {
			Queue<Server> temp = new LinkedList<>();
			while (!servers.isEmpty()) {
				Server server = servers.poll();
				if (i - server.time < k) {
					temp.offer(server);
				}
			}
			servers = temp;

			if (players[i] >= servers.size() * m) {
				int needed = players[i] / m - servers.size();
				for (int j = 0; j < needed; j++) {
					servers.offer(new Server(i));
				}
				count += needed;
			}
		}
		return count;
	}
}