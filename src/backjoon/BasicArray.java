package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

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
        float[] record = new float[SIZE];
        float max = 0;
        float avg = 0;

        for(int i = 0; i < grades.length; i++) {
            record[i] = Float.parseFloat(grades[i]);
            if(record[i] > max) max = record[i];
        }

        for (float grade : record) {
            avg += (grade / max * 100) / SIZE;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(avg + "");
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

    private static void FindNums() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        String[] nums = input.readLine().split(" ");
        final String FIND = input.readLine();
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            if (Objects.equals(FIND, nums[i])) {
                count++;
            }
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(count + "");
        output.flush();
        output.close();
    }

    private static void InputBall() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = input.readLine().split(" ");
        final int BOX_SIZE = Integer.parseInt(nums[0]);
        final int COUNTS = Integer.parseInt(nums[1]);

        int[] boxes = new int[BOX_SIZE];

        for (int count = 0; count < COUNTS; count++) {
            String[] values = input.readLine().split(" ");
            int start = Integer.parseInt(values[0]) - 1;
            int end = Integer.parseInt(values[1]);
            int box = Integer.parseInt(values[2]);

            for (int idx = start; idx < end; idx++) {
                boxes[idx] = box;
            }
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int box: boxes) {
            output.write(box + " ");
        }
        output.flush();
        output.close();
    }

    private static void ChangeBall() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = input.readLine().split(" ");
        final int BOX_SIZE = Integer.parseInt(nums[0]);
        final int SIZE = Integer.parseInt(nums[1]);
        int[] boxes = new int[BOX_SIZE];

        for (int count = 0; count < BOX_SIZE; count++) {
            boxes[count] = count + 1;
        }

        for (int index = 0; index < SIZE; index++) {
            String[] values = input.readLine().split(" ");
            int first = Integer.parseInt(values[0]) - 1;
            int second = Integer.parseInt(values[1]) - 1;

            int changed = boxes[first];
            boxes[first] = boxes[second];
            boxes[second] = changed;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int box: boxes) {
            output.write(box + " ");
        }
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//        MinAndMax();
//        Max();
//        CountNums();
//        Averg();
//        OverAverg();
//        QuizAns();
//        RestVal();
//        FindNums();
//        InputBall();
        ChangeBall();
    }
}
