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
        String NUM = input.readLine();
//        입력값이 한자릿수일 경우
        if (Integer.parseInt(NUM) < 10) NUM = "0" + NUM;
        String number = NUM;
        int count = 0;
        String[] nums;
        input.close();

//        do while 시도
        do {
            nums = number.split("");
            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
//            합이 두자리수 이상일 경우(한자릿수+한자릿수는 두자릿수 이상을 안넘어감)
            if (sum < 10) number = nums[1] + "" + sum;
            else number = nums[1] + String.valueOf(sum).split("")[1];
            count++;
        } while (!number.equals(NUM));

        System.out.println(count);
    }

    public static void untilEOF() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        String line;

        while((line = input.readLine()) != null) {
            int num1 = line.charAt(0) - '0';
            int num2 = line.charAt(2) - '0';
            int sum = num1 + num2;
            str.append(sum ).append("\n");
        }
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(String.valueOf(str));
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//        Plus4();
//        CiclePlus();
        untilEOF();
    }
}
