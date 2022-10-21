package backjoon;

import java.io.*;

public class CumulateSum {
    private void SectionSum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] leng = input.readLine().split(" ");
        String[] numbers = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(leng[1]);
        int[] nums = new int[Integer.parseInt(leng[0]) + 1];

        nums[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i] + Integer.parseInt(numbers[i]);
        }

        for (int i = 0; i < SIZE; i++) {
            String[] section = input.readLine().split(" ");

            output.write(nums[Integer.parseInt(section[1])] - nums[Integer.parseInt(section[0]) - 1] + "\n");
        }

        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        CumulateSum cumulateSum = new CumulateSum();

        cumulateSum.SectionSum(); // 구간합 구하기4
    }
}
