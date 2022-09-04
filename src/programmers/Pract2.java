package programmers;

public class Pract2 {
    private static int[] dp;

    private static int fibo(int num) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }

    private int Nx2Tiling(int n) {
        dp = new int[n + 1];
        return fibo(n) % 1000000007;
    }


    // level2 연습문제
    public static void main(String[] args) {
        Pract2 pract2 = new Pract2();

        // 2 x n 타일링
        System.out.println(pract2.Nx2Tiling(4));
        System.out.println(pract2.Nx2Tiling(4) == 5);
    }
}
