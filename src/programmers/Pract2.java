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

    private int[] pacto;

    private void pactorial(int n) {
        pacto[0] = 1;
        for (int i = 1; i <= n; i++) {
            pacto[i] = pacto[i - 1] * i;
        }
    }

    private int[] LineSol(int n, long k) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        pacto = new int[n + 1];
        pactorial(n);
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        for (int i = n - 1; i > 0; i--) {
            int number = (int) (k / pacto[i]);
            int remainder = (int) (k % pacto[i]);
            answer.add(nums.get(number));
            nums.remove(number);

            if (remainder == 1) {
                for (int num : nums) answer.add(num);
                break;
            } else if (remainder == 0) {
                for (int j = nums.size() - 1; j >= 0; j--) {
                    answer.add(nums.get(j));
                }
                break;
            } else {
                k = remainder;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    // level2 연습문제
    public static void main(String[] args) {
        Pract2 pract2 = new Pract2();

        // 2 x n 타일링
//        System.out.println(pract2.Nx2Tiling(4));
//        System.out.println(pract2.Nx2Tiling(4) == 5);

        // 하노이의 탑
//        System.out.println(Arrays.toString(pract2.TowerOfHanoi(2)));

        // 줄세우기
        System.out.println(Arrays.toString(pract2.LineSol(3, 5)));
    }
}
