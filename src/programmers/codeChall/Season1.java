package programmers.codeChall;

import java.util.*;

public class Season1 {
    private int[] SumsArray(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> answer = new ArrayList(set);
        Collections.sort(answer);
        return Arrays.stream(answer.toArray(new Integer[answer.size()])).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
