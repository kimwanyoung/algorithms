package 백준.숫자야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class NumberBaseballInfo {
        int strike, ball;
        String number;
        public NumberBaseballInfo(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    private static boolean[] numberUseStatus = new boolean[10];
    private static List<NumberBaseballInfo> numberBaseballInfos = new ArrayList<>();
    private static int availavleResultCount = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int questionCounts = Integer.parseInt(br.readLine());
        for(int i = 0; i < questionCounts; i++) {
            String[] readLine = br.readLine().split(" ");
            String number = readLine[0];
            int strike = Integer.parseInt(readLine[1]);
            int ball = Integer.parseInt(readLine[2]);
            numberBaseballInfos.add(new NumberBaseballInfo(number, strike, ball));
        }

        checkAllAvailableNumbers("", 0);
        System.out.println(availavleResultCount);
    }

    private static void checkAllAvailableNumbers(String number, int size) {
        if(size == 3) {
            checkNumberBaseballRules(number);
            return;
        }

        for(int i = 1; i < 10; i++) {
            if(!numberUseStatus[i]) {
                numberUseStatus[i] = true;
                checkAllAvailableNumbers(number + i, size + 1);
                numberUseStatus[i] = false;
            }
        }
    }

    private static void checkNumberBaseballRules(String number) {
        for(NumberBaseballInfo info : numberBaseballInfos) {
            int strike = 0;
            int ball = 0;

            for(int i = 0; i < 3; i++) {
                if(isStrike(number, info, i)) {
                    strike++;
                } else if(isBall(number, info, i)) {
                    ball++;
                }
            }

            if(isCandidateNumber(strike, ball, info)) {
                return;
            }
        }

        availavleResultCount++;
    }

    private static boolean isStrike(String number, NumberBaseballInfo info, int index) {
        return number.charAt(index) == info.number.charAt(index);
    }

    private static boolean isBall(String number, NumberBaseballInfo info, int index) {
        return info.number.contains(String.valueOf(number.charAt(index)));
    }

    private static boolean isCandidateNumber(int strike, int ball, NumberBaseballInfo info) {
        return strike != info.strike || ball != info.ball;
    }
}
