package SWEA;

import java.io.*;
import java.util.Arrays;

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

    private void maxSum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++){
            int num = Integer.parseInt(input.readLine());
            int[][] grid = new int[100][100];

            for (int i = 0; i < grid.length; i++) {
                String[] inputAry = input.readLine().split(" ");
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = Integer.parseInt(inputAry[j]);
                }
            }

            int maxColSum = Integer.MIN_VALUE;
            int crossSum = 0;
            int reversedSum = 0;
            int[] rowSums = new int[100];

            for (int index = 0; index < grid.length; index++) {
                int colSum = 0;
                for (int col = 0; col < grid[index].length; col++) {
                    colSum += grid[index][col];
                    rowSums[col] += grid[index][col];
                }
                crossSum += grid[index][index];
                reversedSum += grid[99 - index][99 - index];
                maxColSum = Math.max(maxColSum, colSum);
            }
            int maxCross = Math.max(reversedSum, crossSum);
            int maxLine = Math.max(maxColSum, maxCross);

            for (int row = 0; row < rowSums.length; row++) {
                maxLine = Math.max(maxLine, rowSums[row]);
            }
            sb.append(String.format("#%d %d\n", test_case, maxLine));
        }
        System.out.println(sb);
    }

    public static void main(String args[]) throws IOException
    {
        SWBasic basic = new SWBasic();

//        basic.View_OneDay();
        basic.maxSum();
    }
}
