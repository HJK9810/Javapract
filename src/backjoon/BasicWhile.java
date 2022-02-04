package backjoon;

import java.io.*;
import java.util.ArrayList;

public class BasicWhile {
    public static void Plus4() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> printSum = new ArrayList<>();
        String[] nums = {"1", "1"};

        while (!nums[0].equals("0") && !nums[1].equals("0")) {
            String s = input.readLine();
            nums = s.split(" ");
            if (nums[0].equals("0") && nums[1].equals("0")) break;

            printSum.add(String.valueOf(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])));
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String sum : printSum) {
            output.write(sum + "\n");
        }
        output.flush();
        output.close();
    }

    public static void CiclePlus() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final String NUM = input.readLine();
        String number = "";
        int count = 0;
        input.close();

        while (!number.equals(NUM)) {
            String[] nums = NUM.split("");
            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            number = nums[1] + sum;
            count++;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(count);
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//        Plus4();
        CiclePlus();
    }
}
