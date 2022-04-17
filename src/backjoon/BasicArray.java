package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

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

    public static void CountNums() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(input.readLine());
        int B = Integer.parseInt(input.readLine());
        int C = Integer.parseInt(input.readLine());
        int sum = A * B * C;

        int[] numCount = new int[10];
        String[] ary = (sum + "").split("");

        for (String num : ary) {
            numCount[Integer.parseInt(num)] += 1;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num : numCount) {
            output.write(num + "\n");
        }
        output.flush();
        output.close();
    }

    public static void Averg() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        String[] grades = input.readLine().split(" ");
        Arrays.sort(grades);
        float sum = 0;
        float max = Integer.parseInt(grades[SIZE - 1]);

        for (String grade : grades) {
            float intgrade = Integer.parseInt(grade);
            float now = (intgrade / max) * 100;
            sum = sum + now;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write((sum / SIZE) + "\n");
        output.flush();
        output.close();
    }

    public static void OverAverg() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        double[] printPercent = new double[SIZE];

        for (int i = 0; i < SIZE; i++) {
            String[] ary = input.readLine().split(" ");
            int member = Integer.parseInt(ary[0]);
            int sum = 0;
            int pass = 0;

            for (int j = 1; j < member + 1; j++) {
                sum += Integer.parseInt(ary[j]);
            }
            double averg = (double) sum / member;

            for (int j = 1; j < member + 1; j++) {
                if (Integer.parseInt(ary[j]) > averg) pass += 1;
            }

            double percent = ((double) pass / member) * 100;
            printPercent[i] = percent;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (double percent : printPercent) {
            output.write(String.format("%.3f", percent) + "%\n");
        }
        output.flush();
        output.close();
    }

    public static void QuizAns() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        int[] sum = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            String[] ans = input.readLine().split("");
            int grade = 0;
            for (String yans : ans) {
                if (yans.equals("O")) {
                    grade += 1;
                    sum[i] += grade;
                } else grade = 0;
            }
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < SIZE; i++) {
            output.write(sum[i] + "\n");
        }
        output.flush();
        output.close();
    }

    public static void RestVal() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> restVal = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(input.readLine());
            restVal.add(number % 42);
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(restVal.size() + "\n");
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//        MinAndMax();
//        Max();
//        CountNums();
//        Averg();
        OverAverg();
//        QuizAns();
//        RestVal();
    }
}
