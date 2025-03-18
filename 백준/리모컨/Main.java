package 백준.리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 모든 가능한 채널의 수 탐색
		// 현재 채널이 고장난 번호를 포함하고 있지 않다면, 목표 수에서 현재 채널을 빼고 -100을 해준다(왜냐하면 시작 채널이 100이기 때문)
		// 고장난 채널을 포함한다면, 다음 채널 탐색
		// 최종 가장 작은 수 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int channel = Integer.parseInt(br.readLine());
		int brokenCount = Integer.parseInt(br.readLine());
		boolean[] brokenButton = new boolean[10];

		if(brokenCount != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < brokenCount; i++) {
				brokenButton[Integer.parseInt(st.nextToken())] = true;
			}
		}

		if(channel == 100) {
			System.out.println(0);
			return;
		}

		int result = Math.abs(100 - channel);
		for(int i = 0; i < 999_999; i++) {
			boolean isBroken = false;
			String currentChannel = String.valueOf(i);
			for(int j = 0; j < currentChannel.length(); j++) {
				if(brokenButton[currentChannel.charAt(j) - '0']) {
					isBroken = true;
					break;
				}
			}
			if(!isBroken) {
				result = Math.min(currentChannel.length() + Math.abs(channel - i), result);
			}
		}

		System.out.println(result);
	}
}
