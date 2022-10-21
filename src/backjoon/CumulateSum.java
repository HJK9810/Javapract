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

    private void Sequence() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] leng = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(leng[0]);
        final int section = Integer.parseInt(leng[1]);
        String[] numbers = input.readLine().split(" ");

        int[] numsSum = new int[SIZE + 1];
        numsSum[0] = 0;
        for (int i = 0; i < numsSum.length - 1; i++) {
            numsSum[i + 1] = numsSum[i] + Integer.parseInt(numbers[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < SIZE - section + 2; i++) {
            int sum = numsSum[i + section - 1] - numsSum[i - 1];
            if (sum > max) max = sum;
        }
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(max + "\n");
        output.flush();
        output.close();
    }

    private void Interaction() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        final String str = input.readLine();
        final int SIZE = Integer.parseInt(input.readLine());

        for (int i = 0; i < SIZE; i++) {
            String[] line = input.readLine().split(" ");
            String alph = line[0];
            int start = Integer.parseInt(line[1]);
            int end = Integer.parseInt(line[2]);
            String basic = str.length() - 1 == end ? str.substring(start) : str.substring(start, end + 1);

            String minus = basic.replaceAll(alph, "");
            output.write(end - start + 1 - minus.length() + "\n");
        }

        output.flush();
        output.close();
    }

    private void Reaminder() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] leng = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(leng[0]);
        final int value = Integer.parseInt(leng[1]);
        String[] numbers = input.readLine().split(" ");

        int[] nums = new int[SIZE + 1];

        nums[0] = 0;
        for (int i = 0; i < SIZE; i++) {
            nums[i + 1] = (nums[i] + Integer.parseInt(numbers[i])) % value;
        }

        int count = 0;
        for (int i = SIZE; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if ((nums[i] - nums[j - 1]) % value == 0) count++;
            }
        }
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(count + "\n");
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        CumulateSum cumulateSum = new CumulateSum();

//        cumulateSum.SectionSum(); // 구간합 구하기4
//        cumulateSum.Sequence(); // 수열
//        cumulateSum.Interaction(); // 인간-컴퓨터 상호작용
        cumulateSum.Reaminder(); // 나머지의 합
    }
}
