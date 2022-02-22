package backjoon;

import java.io.*;
import java.util.Arrays;

public class BasicArray {
    public static void MinAndMax() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        String[] nums = input.readLine().split(" ");
        int[] numbers = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(numbers);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(numbers[0] + " " + numbers[SIZE - 1]);
        output.flush();
        output.close();
    }

    public static void Max() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        int max = -1;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(input.readLine());
        }

        for (int i = 0; i < 9; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(max + "\n" + (index + 1));
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//        MinAndMax();
        Max();
    }
}
