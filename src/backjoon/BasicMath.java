package backjoon;

import java.io.*;

public class BasicMath {
    private void BreakEventPoint() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int A = Integer.parseInt(data[0]); // 고정비용
        int B = Integer.parseInt(data[1]); // 가변비용
        int C = Integer.parseInt(data[2]); //가격
        double profit = C - B;


        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        if (profit < 0 || A == 0) output.write("-1");
        else {
            double cal = A / profit;

            if (cal > (int) cal) output.write(Math.ceil(cal) + "");
            else output.write(((int) cal + 1) + "");
        }

        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        BasicMath basicMath = new BasicMath();

        basicMath.BreakEventPoint();
    }
}
