package 백준.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    static final String LEFT_SQUARE_BRACKET = "[";
    static final String RIGHT_SQUARE_BRACKET = "]";
    static final String LEFT_PARENTHESES = "(";
    static final String RIGHT_PARENTHESES = ")";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] brackets = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int answer = 0;
        int temp = 1;
        boolean flag = false;
        for(int i = 0; i < brackets.length; i++) {
            String current = brackets[i];

            if(current.equals(LEFT_PARENTHESES)) {
                stack.push(current);
                temp *= 2;
            }
            if(current.equals(LEFT_SQUARE_BRACKET)) {
                stack.push(current);
                temp *= 3;
            }
            if(current.equals(RIGHT_PARENTHESES)) {
                if(stack.isEmpty() || !stack.peek().equals(LEFT_PARENTHESES)) {
                    flag = true;
                    break;
                }
                if(brackets[i - 1].equals(LEFT_PARENTHESES)) answer += temp;
                stack.pop();
                temp /= 2;
            }
            if(current.equals(RIGHT_SQUARE_BRACKET)) {
                if(stack.isEmpty() || !stack.peek().equals(LEFT_SQUARE_BRACKET)) {
                    flag = true;
                    break;
                }
                if(brackets[i - 1].equals(LEFT_SQUARE_BRACKET)) answer += temp;
                stack.pop();
                temp /= 3;
            }
        }

        if(flag || !stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);
    }
}
