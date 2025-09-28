import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private int answer;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        dfs(1, n, 0, new ArrayList<>(), q, ans);
        return answer;
    }

    private void dfs(int start, int n, int count, List<Integer> current, int[][] q, int[] ans) {
        if (count == 5) {
            checkAns(current, q, ans);
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            dfs(i + 1, n, count + 1, current, q, ans);
            current.remove(current.size() - 1);
        }
    }

    private void checkAns(List<Integer> current, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>(current);

        for (int i = 0; i < ans.length; i++) {
            int[] code = q[i];
            int count = 0;

            for (int c : code) {
                if (set.contains(c)) {
                    count++;
                }
            }

            if (count != ans[i]) {
                return; 
            }
        }  
        answer++;
    }
}