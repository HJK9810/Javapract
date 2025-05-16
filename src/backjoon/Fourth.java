package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        int base = Integer.parseInt(inputvalue[0]);
        int pow = Integer.parseInt(inputvalue[1]);
        int divider = Integer.parseInt(inputvalue[2]);

        int multiple = base % divider;

        for (int num = 0; num < pow; num++) {
            multiple *= base;
            multiple %= divider;
        }
        System.out.println(multiple % divider);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

//        fourth.fixAtoB();
//        fourth.CommonBag();
        fourth.MutlipleAndDeciminal();
    }
}
