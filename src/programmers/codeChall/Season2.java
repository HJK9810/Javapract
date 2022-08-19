package programmers.codeChall;

import java.util.*;

public class Season2 {
    private int AddDivisor(int left, int right) {
        int answer = 0;
        for (int num = left; num <= right; num++) {
            List<Integer> ary = new ArrayList<>();
            for (int i = 1; i < num + 1; i++) {
                if (num % i == 0) ary.add(i);
            }

            answer = ary.size() % 2 != 0 ? answer - num : answer + num;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
