package programmers;

import java.util.*;

public class StackQuere {
    private Integer[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) answer.add(arr[i]);
        }

        return answer.toArray(new Integer[answer.size()]);
    }

    public static void main(String[] args) {

    }
}
