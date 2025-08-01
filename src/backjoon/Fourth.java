package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fourth {
    private void fixAtoB() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] inputvalue = input.readLine().split(" ");
        int first = Integer.parseInt(inputvalue[0]);
        int second = Integer.parseInt(inputvalue[1]);
        int count = 0;
        boolean isImpossibleValue = false;

        while (first < second) {
            if (second % 2 == 0) {
                second /= 2;
                count++;
            } else {
                if (second % 10 != 1) {
                    isImpossibleValue = true;
                    break;
                }
                second /= 10;
                count++;
            }

            if (first > second) {
                isImpossibleValue = true;
                break;
            }
        }

        System.out.println(isImpossibleValue ? -1 : count + 1);
    }

    private void CommonBag() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] inputvalue = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(inputvalue[0]);
        final int amount = Integer.parseInt(inputvalue[1]);

        int[] weight = new int[SIZE];
        int[] values = new int[SIZE];
        int[] dp = new int[amount + 1];

        for (int i = 0; i < SIZE; i++) {
            String[] temp = input.readLine().split(" ");
            weight[i] = Integer.parseInt(temp[0]);
            values[i] = Integer.parseInt(temp[1]);
        }

        for (int index = 0; index < SIZE; index++) {
            for (int num = amount; num >= weight[index]; num--) {
                dp[num] = Math.max(dp[num], dp[num - weight[index]] + values[index]);
            }
        }
        System.out.println(dp[amount]);
    }

    private void MutlipleAndDeciminal() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] inputvalue = input.readLine().split(" ");
        long base = Integer.parseInt(inputvalue[0]);
        long pow = Integer.parseInt(inputvalue[1]);
        long divider = Integer.parseInt(inputvalue[2]);

        long multiple = 1;
        base %= divider;

        while (pow > 0) {
            if (pow % 2 == 1) multiple = (base * multiple) % divider;
            base = (base * base) % divider;
            pow /= 2;
        }
        System.out.println(multiple % divider);
    }

    private void IntegerTriangle() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int SIZE = Integer.parseInt(input.readLine());
        int[][] triangle = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            String[] temp = input.readLine().split(" ");
            for (int idx = 0; idx < temp.length; idx++) {
                triangle[i][idx] = Integer.parseInt(temp[idx]);
            }
        }

        for (int num = SIZE - 2; num >= 0; num--) {
            for (int index = 0; index <= num; index++) {
                triangle[num][index] += Math.max(triangle[num + 1][index], triangle[num + 1][index + 1]);
            }
        }
        System.out.println(triangle[0][0]);
    }

    private void PanelSum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] leng = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(leng[0]);
        final int count = Integer.parseInt(leng[1]);

        int[][] nums = new int[SIZE][SIZE + 1];
        for (int i = 0; i < SIZE; i++) {
            String[] line = input.readLine().split(" ");
            nums[i][0] = 0;
            for (int j = 0; j < SIZE; j++) {
                nums[i][j + 1] = nums[i][j] + Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < count; i++) {
            String[] position = input.readLine().split(" ");
            int y1 = Integer.parseInt(position[0]);
            int x1 = Integer.parseInt(position[1]);
            int y2 = Integer.parseInt(position[2]);
            int x2 = Integer.parseInt(position[3]);

            long sum = 0;
            for (int row = y1 - 1; row < y2; row++) {
                sum += (nums[row][x2] - nums[row][x1 - 1]);
            }
            output.write(sum + "\n");
        }
        output.flush();
        output.close();
    }

    private void insertNum(int[] base, int from, int depth, int SIZE, int amount, StringBuilder sb) throws IOException {
        if (depth == amount) {
            for (int i = 0; i < amount; i++) {
                sb.append(base[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int num = from; num <= SIZE; num++) {
            base[depth] = num;
            insertNum(base, from + 1, depth + 1, SIZE, amount, sb);
        }
    }

    private void NandM2() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int amount = Integer.parseInt(line[1]);

        int[] base = new int[amount];
        insertNum(base, 1, 0, SIZE, amount, sb);
        System.out.println(sb);
    }

    private long fib(long number, Map<Long, Long> memo) {
        final long base = 1000000007;

        if (number <= 1) return number;
        if (memo.containsKey(number)) return memo.get(number);

        long half = number % 2 == 0 ? number / 2 : (number + 1) / 2;
        long first = fib(half, memo);
        long second = fib(half - 1, memo);

        long result = number % 2 == 0
                ? (first * ((2 * second % base + first) % base)) % base
                : (first * first % base + second * second % base) % base;

        memo.put(number, result);
        return result;
    }

    private void Fibonacci6() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        final long SIZE = Long.parseLong(input.readLine());
        Map<Long, Long> memo = new HashMap<>();

        System.out.println(fib(SIZE, memo));
    }

    private void LongestSequence() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());

        int[] numbers = new int[SIZE];
        String[] line = input.readLine().split(" ");
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        List<Integer> list = new ArrayList<>();

        for (int num : numbers) {
            int index = Collections.binarySearch(list, num);
            if (index < 0) index = -(index + 1);

            if (index == list.size()) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }

        System.out.println(list.size());
    }

    private void LCS() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        final char[] first = input.readLine().toCharArray();
        final char[] second = input.readLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int firstIdx = 1; firstIdx <= first.length; firstIdx++) {
            for (int secondIdx = 1; secondIdx <= second.length; secondIdx++) {
                if (first[firstIdx - 1] == second[secondIdx - 1]) {
                    dp[firstIdx][secondIdx] = dp[firstIdx - 1][secondIdx - 1] + 1;
                } else {
                    dp[firstIdx][secondIdx] = Math.max(dp[firstIdx][secondIdx - 1], dp[firstIdx - 1][secondIdx]);
                }
            }
        }

        System.out.println(dp[first.length][second.length]);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

//        fourth.fixAtoB();
//        fourth.CommonBag();
//        fourth.MutlipleAndDeciminal();
//        fourth.IntegerTriangle();
//        fourth.PanelSum();
//        fourth.Fibonacci6();
//        fourth.LongestSequence();
        fourth.LCS();
    }
}
