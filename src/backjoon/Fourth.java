package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

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

        int maxValue = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] keys = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            String[] value = input.readLine().split(" ");
            map.put(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
            keys[i] = Integer.parseInt(value[0]);
        }

        Arrays.sort(keys);
        for (int idx = SIZE - 1; idx >= 0; idx--) {
            int key = keys[idx];
            int value = map.get(key);

            if (amount < key) continue;

            int need = amount - key;
            if (need < keys[0]) {
                maxValue = Math.max(maxValue, value);
                continue;
            }

            int index = 0;
            while (index < SIZE && need >= keys[index]) {
                index++;
            }
            maxValue = Math.max(maxValue, value + (index == 0 ? 0 : map.get(keys[index - 1])));
        }

        System.out.println(maxValue);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

//        fourth.fixAtoB();
        fourth.CommonBag();
    }
}
