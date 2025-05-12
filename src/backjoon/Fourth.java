package backjoon;

import java.io.*;
import java.util.Arrays;
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

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

//        fourth.changedOne();
    }
}
