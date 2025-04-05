package 프로그래머스.무인도여행;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Solution {

	static class IslandInfo{
		int y, x, sum;

		public IslandInfo(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	int[] dy = {0, 0, -1, 1};
	int[] dx = {1, -1, 0, 0};
	public int[] solution(String[] maps) {
		// bfs
		// 1. 모든 칸 순회하면서 bfs수행
		//  1-1. 현재 칸이 X라면 다음 칸으로 넘어가기
		//  1-2. 현재 칸이 이미 방문된 칸이라면 넘어가기
		// 2. bfs수행이 끝났다면 누적 합 반환
		// 3. 모든 합 오름차순 정렬 후 반환
		// 4. 만약 결과 배열이 비어있다면 [-1] 반환
		List<Integer> answers = new ArrayList<>();

		String[][] splitMaps = new String[maps.length][maps[0].length()];
		for(int i = 0; i < maps.length; i++) {
			String[] splited = maps[i].split("");
			for(int j = 0; j < splited.length; j++) {
				splitMaps[i][j] = splited[j];
			}
		}

		boolean[][] visited = new boolean[splitMaps.length][splitMaps[0].length];
		for(int i = 0; i < splitMaps.length; i++) {
			for(int j = 0; j < splitMaps[0].length; j++) {
				if(Objects.equals(splitMaps[i][j], "X") || visited[i][j]) continue;
				answers.add(bfs(i, j, splitMaps, visited));
			}
		}

		answers.sort(Comparator.naturalOrder());
		int[] answerArr = new int[answers.size()];
		for(int i = 0; i < answers.size(); i++) {
			answerArr[i] = answers.get(i);
		}

		if(answerArr.length == 0) return new int[]{-1};
		return answerArr;
	}

	int bfs(int y, int x, String[][] maps, boolean[][] visited) {
		Queue<IslandInfo> q = new LinkedList<>();

		int sum = Integer.parseInt(maps[y][x]);
		q.offer(new IslandInfo(y, x));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			IslandInfo current = q.poll();

			for(int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if(ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length || visited[ny][nx] || Objects.equals(
					maps[ny][nx], "X")) continue;

				q.offer(new IslandInfo(ny, nx));
				visited[ny][nx] = true;
				sum += (current.sum + Integer.parseInt(maps[ny][nx]));
			}
		}

		return sum;
	}
}
