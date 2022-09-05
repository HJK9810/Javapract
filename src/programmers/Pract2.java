package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pract2 {
    private static int[] dp;

    private static int fibo(int num) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }

        return dp[num];
    }

    private int Nx2Tiling(int n) {
        dp = new int[n + 1];
        return fibo(n);
    }

    List<int[]> moves = new ArrayList<>();

    private void hanoi(int n, int from, int by, int to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, by);
        moves.add(new int[]{from, to});
        hanoi(n - 1, by, from, to);
    }

    private int[][] TowerOfHanoi(int n) {
        hanoi(n, 1, 2, 3);
        return moves.toArray(new int[moves.size()][2]);
    }


    // level2 연습문제
    public static void main(String[] args) {
        Pract2 pract2 = new Pract2();

        // 2 x n 타일링
//        System.out.println(pract2.Nx2Tiling(4));
//        System.out.println(pract2.Nx2Tiling(4) == 5);

        // 하노이의 탑
        System.out.println(Arrays.toString(pract2.TowerOfHanoi(2)));
    }
}
