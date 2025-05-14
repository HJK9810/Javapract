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

    public static void main(String[] args) throws IOException {
        Second second = new Second();

        second.PrintQeue();
    }
}
