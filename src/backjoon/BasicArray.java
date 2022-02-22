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

    public static void main(String[] args) throws IOException {
        MinAndMax();
    }
}
