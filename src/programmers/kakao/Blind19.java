package programmers.kakao;

import java.util.*;

public class Blind19 {
    private int[] FailureRate(int N, int[] stages) {
        int[] set = new int[N];
        double[] pass = new double[N];

        for (int i = 0; i < N; i++) {
            int finalI = i + 1;
            double up = (double) Arrays.stream(stages).filter(el -> el == finalI).count();
            int base = (int) Arrays.stream(stages).filter(el -> el >= finalI).count();

            set[i] = i + 1;
            pass[i] = base == 0 ? 0 : up / base;
        }

        for(int i = 0; i < N ; i++) {
            double maxValue = pass[0];
            int maxIndex = 0;

            for(int j = 0; j < N; j++) {
                if(maxValue < pass[j]) {
                    maxIndex = j;
                    maxValue = pass[j];
                }
            }
            pass[maxIndex] = -1;
            set[i] = maxIndex + 1;
        }

        return set;
    }

    public static void main(String[] args) {
        Blind19 blind19 = new Blind19();

        System.out.println(Arrays.toString(blind19.FailureRate(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(blind19.FailureRate(4, new int[]{4, 4, 4, 4, 4})));
    }
}
