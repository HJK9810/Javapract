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
        String number = NUM;
        int count = 0;
        String[] nums;
        input.close();

//        do while 시도
        do {
            nums = number.split("");
            int sum = Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
            if(sum<10) number = nums[1]+""+sum;
            else number = nums[1] + String.valueOf(sum).split("")[1];
            count++;
        } while (!number.equals(NUM));

//        while (!number.equals(NUM)) {
//            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
//            number = nums[1] + sum;
//            nums = number.split("");
//            count++;
//        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
//        Plus4();
        CiclePlus();
    }
}
