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

    public static void main(String[] args) throws IOException {
        Plus4();
    }
}