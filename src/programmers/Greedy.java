package programmers;

import java.util.Arrays;
import java.util.List;

public class Greedy {
    private int Uniform(int n, int[] lost, int[] reserve) {
        int[] stus = new int[n + 2];
        Arrays.fill(stus, 1);
        stus[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int r = 0, l = 3;
            int finalI = i;
            if (Arrays.stream(lost).anyMatch(s -> s == finalI)) {
                stus[i] = 0;
                l = 1;
            }
            if (Arrays.stream(reserve).anyMatch(s -> s == finalI)) {
                stus[i] = 0;
                r = 1;
            }

            if (r == l) stus[i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (stus[i] == 0 && stus[i - 1] == 2) {
                stus[i - 1] = 1;
                stus[i] = 1;
            } else if (stus[i] == 0 && stus[i + 1] == 2) {
                stus[i + 1] = 1;
                stus[i] = 1;
            }
        }
        stus[n + 1] = 0;

        return (int) Arrays.stream(stus).filter(el -> el > 0).count();
    }

    public static void main(String[] args) {

    }
}
