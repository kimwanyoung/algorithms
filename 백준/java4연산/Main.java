package 백준.java4연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	enum Operator {
		PLUS("+")  {
			@Override
			public Long operate(Long a, Long b) {
				return a + b;
			}
		},
		MINUS("-")  {
			@Override
			public Long operate(Long a, Long b) {
				return a - b;
			}
		},
		MUL("*") {
			@Override
			public Long operate(Long a, Long b) {
				return a * b;
			}
		},
		DIV("/") {
			@Override
			public Long operate(Long a, Long b) {
				if(a == 0) return a;
				return a / b;
			}
		};

		public String operator;
		public abstract Long operate(Long a, Long b);

		Operator(String operator) {
			this.operator = operator;
		}

		public static Operator of(String operator) {
			for(Operator op : Operator.values()) {
				if(operator.equals(op.operator)) {
					return op;
				}
			}
			return null;
		}
	}

	static class OperatorHistory {
		Long value;
		List<String> history;

		public OperatorHistory(Long value, List<String> history) {
			this.value = value;
			this.history = history;
		}
	}

	private static String[] operators = new String[]{"*", "+", "-", "/"};
	private static Long t;
	private static List<String> result;
	public static void main(String[] args) throws IOException {
		// - s를 t로 바꾸는 최소 연산 횟수
		// - 연산은 +, -, *, / 4가지
		// 1. s, t입력 받아서 저장
		// 2. bfs수행 OperatorHistory객체 생성 => int value, List<String> history
		// 3. poll()된 객체의 value == t return history;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long s = Long.parseLong(st.nextToken());
		t = Long.parseLong(st.nextToken());

		if(s.equals(t)) {
			System.out.println(0);
			return;
		}

		bfs(s);

		StringBuilder sb = new StringBuilder();
		for (String operator : result) {
			sb.append(operator);
		}

		System.out.println(sb);
	}

	public static void bfs(Long s) {
		Queue<OperatorHistory> q = new LinkedList<>();
		Set<Long> visited = new HashSet<>();

		q.offer(new OperatorHistory(s, new ArrayList<>()));
		visited.add(s);
		while(!q.isEmpty()) {
			OperatorHistory operatorHistory = q.poll();
			Long currentValue = operatorHistory.value;
			if(t.equals(currentValue)) {
				result = operatorHistory.history;
				return;
			}
			for(int i = 0; i < 4; i++) {
				Operator operator = Operator.of(operators[i]);
				Long operatedValue = operator.operate(currentValue, currentValue);
				if(operatedValue > 10e9 || visited.contains(operatedValue)){
					continue;
				}

				List<String> copyHistory = new ArrayList<>(operatorHistory.history);
				copyHistory.add(operators[i]);
				q.offer(new OperatorHistory(operatedValue, copyHistory));
				visited.add(operatedValue);
			}
		}

		result = new ArrayList<>();
		result.add("-1");
	}
}
