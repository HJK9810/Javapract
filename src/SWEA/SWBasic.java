package SWEA;

import java.io.*;

public class SWBasic {
    private void View_OneDay() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int SIZE = Integer.parseInt(input.readLine());
            String[] inputAry = input.readLine().split(" ");
            int[] heights = new int[SIZE];
            int count = 0;

            for(int index = 0; index < SIZE; index++) {
                heights[index] = Integer.parseInt(inputAry[index]);
            }

            for (int idx = 2; idx < SIZE - 2; idx++) {
                int now = heights[idx];
                if (heights[idx - 2] < now && heights[idx - 1] < now && heights[idx + 1] < now && heights[idx + 2] < now) {
                    int max = Math.max(Math.max(heights[idx - 2], heights[idx - 1]), Math.max(heights[idx + 1], heights[idx + 2]));
                    count += (now - max);
                }
            }

            sb.append(String.format("#%d %d\n", test_case, count));
        }
        System.out.println(sb);
    }

    public static void main(String args[]) throws Exception
    {
        SWBasic basic = new SWBasic();

        basic.View_OneDay();
    }
}
