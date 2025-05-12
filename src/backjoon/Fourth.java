package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Fourth {
    private void changedOne() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(input.readLine());
        int[] count = new int[number + 1];

        count[1] = 0;
        for (int idx = 2; idx <= number; idx++) {
            count[idx] = count[idx - 1] + 1;
            if (idx % 2 == 0) count[idx] = Math.min(count[idx], count[idx / 2] + 1);
            if (idx % 3 == 0) count[idx] = Math.min(count[idx], count[idx / 3] + 1);
        }

        System.out.println(count[number]);
    }

    private void makeSet() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int SIZE = Integer.parseInt(input.readLine());
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> base = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        for (int i = 0; i < SIZE; i++) {
            String[] order = input.readLine().split(" ");
            int value = order.length > 1 ? Integer.parseInt(order[1]) : 0;
            switch (order[0]) {
                case "add":
                    if (!queue.contains(value)) queue.add(value);
                    break;
                case "remove":
                    queue.remove(value);
                    break;
                case "check":
                    output.write(queue.contains(value) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if (queue.contains(value)) queue.remove(value);
                    else queue.add(value);
                    break;
                case "all":
                    queue.clear();
                    queue.addAll(base);
                    break;
                case "empty":
                    queue.clear();
                    break;
                default:
                    break;
            }
        }
        output.flush();
        output.close();
    }

    private void fibonacciFuc() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int SIZE = Integer.parseInt(input.readLine());

        for (int i = 0; i < SIZE; i++) {
            int number = Integer.parseInt(input.readLine());

            if (number < 2) {
                output.write(number == 0 ? "1 0\n" : "0 1\n");
                continue;
            }

            int[][] fibonacci = new int[number + 1][2];

            fibonacci[0] = new int[]{1, 0};
            fibonacci[1] = new int[]{0, 1};
            for (int num = 2; num <= number; num++) {
                fibonacci[num] = new int[]{
                        fibonacci[num - 1][0] + fibonacci[num - 2][0], fibonacci[num - 1][1] + fibonacci[num - 2][1]
                };
            }
            output.write(String.format("%d %d\n", fibonacci[number][0], fibonacci[number][1]));
        }
        output.flush();
        output.close();
    }

    private void ATM() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int SIZE = Integer.parseInt(input.readLine());
        String[] nums = input.readLine().split(" ");
        Arrays.sort(nums, Comparator.comparingInt(Integer::parseInt));
        int sum = 0;
        int forAdd = 0;

        for (int idx = 0; idx < SIZE; idx++) {
            sum += (forAdd + Integer.parseInt(nums[idx]));
            forAdd += Integer.parseInt(nums[idx]);
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

//        fourth.changedOne();
//        fourth.fibonacciFuc();
        fourth.ATM();
    }
}
