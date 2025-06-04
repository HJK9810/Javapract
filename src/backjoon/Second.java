package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Second {
    private void PrintQeue() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        final int SIZE = Integer.parseInt(input.readLine());

        for (int i = 0; i < SIZE; i++) {
            String[] line = input.readLine().split(" ");
            int listSize = Integer.parseInt(line[0]);
            int wantIdx = Integer.parseInt(line[1]);
            int count = 1;

            String[] inputList = input.readLine().split(" ");
            Queue<Integer> queue = new LinkedList<Integer>();
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int idx = 0; idx < listSize; idx++) {
                queue.add(Integer.parseInt(inputList[idx]));
                pQueue.add(Integer.parseInt(inputList[idx]));
            }

            while (!queue.isEmpty()) {
                int value = queue.poll();

                if (value == pQueue.peek()) {
                    if (wantIdx == 0) {
                        output.write(count + "\n");
                        break;
                    } else {
                        pQueue.poll();
                        count++;
                        wantIdx--;
                    }
                } else {
                    queue.add(value);
                    wantIdx = wantIdx == 0 ? pQueue.size() - 1 : wantIdx - 1;
                }
            }
        }

        output.flush();
        output.close();
    }

    private void TilingN() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(input.readLine());
        int[] dp = new int[number + 2];

        dp[0] = 1;
        dp[1] = 1;

        for (int idx = 2; idx <= number; idx++) {
            dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 10007;
        }

        System.out.println(dp[number]);
    }

    private void CutLANCable() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int need_cable = Integer.parseInt(line[1]);
        int[] cables = new int[SIZE];

        long right = 0;
        for (int i = 0; i < SIZE; i++) {
            cables[i] = Integer.parseInt(input.readLine());
            if (cables[i] > right) right = cables[i];
        }

        if (right <= 0) {
            System.out.println(0);
            return;
        }

        long left = 1;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (int cable : cables) {
                count += cable / mid;
            }

            if (count >= need_cable) {
                result = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.println(result);
    }

    private void Parentheses() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        final int SIZE = Integer.parseInt(input.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < SIZE; i++) {
            String[] line = input.readLine().split("");
            Boolean isNo = false;

            for (int idx = 0; idx < line.length; idx++) {
                if (line[idx].equals("(")) stack.push(idx);
                else if (stack.isEmpty()) {
                    output.write("NO\n");
                    isNo = true;
                    break;
                } else stack.pop();
            }
            if (stack.isEmpty() && !isNo) output.write("YES\n");
            else if (!isNo) output.write("NO\n");
            stack.clear();
        }
        output.flush();
        output.close();
    }

    private void JosephusQuestion() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int number = Integer.parseInt(line[1]);

        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        for (int num = 0; num < SIZE; num++) {
            queue.offer(num + 1);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                sb.append(queue.peek());
                break;
            }

            if (count == number) {
                sb.append(queue.poll()).append(", ");
                count = 1;
            } else {
                queue.offer(queue.poll());
                count++;
            }
        }

        System.out.println(sb + ">");
    }

    public static void main(String[] args) throws IOException {
        Second second = new Second();

//        second.PrintQeue();
//        second.TilingN();
//        second.CutLANCable();
//        second.Parentheses();
        second.JosephusQuestion();
    }
}
