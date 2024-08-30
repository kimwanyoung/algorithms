package 백준.에리_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

        Integer[] sharedCards = new Integer[n];
        Integer[] myCards = new Integer[n];

        initializeCards(sharedCards, br.readLine());
        initializeCards(myCards, br.readLine());

        removeMaxCard(sharedCards, myCards, k);

        int answer = getMaxResult(sharedCards, myCards);
        System.out.println(answer);
    }

    static void initializeCards(Integer[] cards, String stringCards) {
        String[] splited = stringCards.split(" ");
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(splited[i]);
        }
    }

    static void removeMaxCard(Integer[] sharedCards, Integer[] myCards, int k) {
        int currentMax = sharedCards[0] * myCards[0];
        int currentIdx = 0;

        for(int t = 0; t < k; t++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(myCards[j] != null && sharedCards[i] * myCards[j] >= currentMax) {
                        currentMax = sharedCards[i] * myCards[j];
                        currentIdx = j;
                    }
                }
            }

            myCards[currentIdx] = null;

            int tmp = 0;
            while(myCards[tmp] == null) tmp++;

            currentMax = sharedCards[0] * myCards[tmp];
            currentIdx = tmp;
        }
    }

    static int getMaxResult(Integer[] sharedCards, Integer[] myCards) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(myCards[j] != null){
                    answer = Math.max(sharedCards[i] * myCards[j], answer);
                }
            }
        }
        return answer;
    }
}