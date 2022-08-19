package programmers.extra;

import java.util.*;

public class SWCode {
    private int Budget(int[] d, int budget) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        Arrays.sort(d);
        for(int i = d.length ; i > 0;i--) {
            stack.push(d[i - 1]);
        }

        while (!stack.isEmpty() && budget >= stack.peek()) {
            int poped = stack.pop();

            if (budget - poped < 0) continue;
            else budget -= poped;

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SWCode swCode = new SWCode();

        System.out.println(swCode.Budget(new int[]{1,3,2,5,4}, 9));
        System.out.println(swCode.Budget(new int[]{2,2,3,3}, 10));
    }
}
