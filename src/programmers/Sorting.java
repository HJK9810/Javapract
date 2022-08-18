package programmers;

import java.util.*;

public class Sorting {
    private Integer[] IdxKNum(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands) {
            int[] splitAry = Arrays.copyOfRange(array, (command[0] - 1), command[1]);
            Arrays.sort(splitAry);
            answer.add(splitAry[command[2] - 1]);
        }

        return answer.toArray(new Integer[commands.length]);
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        Integer[] ans = sorting.IdxKNum(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.equals(ans, new Integer[]{5, 6, 3}));
    }
}
