package 백준.그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++) {
			if(wordChecker(br.readLine())) answer++;
		}
		System.out.println(answer);
	}

	private static boolean wordChecker(String word) {
		Map<Character, Boolean> wordMap = new HashMap<>();
		char prev = word.charAt(0);
		for (char letter : word.toCharArray()) {
			if(!wordMap.containsKey(letter)) {
				wordMap.put(letter, true);
				prev = letter;
			} else {
				if(prev != letter) {
					return false;
				}
			}
		}
		return true;
	}
}
