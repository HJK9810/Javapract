package programmers.DebMatch;

import java.util.*;

public class WebBack21 {
    private int checkwin(int num) {
        switch (num) {
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 6;
        }
    }

    private int[] CheckLottes(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        Arrays.sort(lottos);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zero = i + 1;
            else {
                int finalI = i;
                if (Arrays.stream(win_nums).anyMatch(s -> s == lottos[finalI])) count++;
            }
        }

        return new int[]{checkwin(count + zero), checkwin(count)};
    }

    public static void main(String[] args) {
        WebBack21 webBack21 = new WebBack21();

        System.out.println(webBack21.CheckLottes(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}).equals(new int[]{3, 5}));
        System.out.println(webBack21.CheckLottes(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}).equals(new int[]{1, 6}));
        System.out.println(webBack21.CheckLottes(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}).equals(new int[]{1, 1}));
    }
}
