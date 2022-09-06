package backjoon;

import java.io.*;
import java.math.BigInteger;

public class BasicMath {
    private void BreakEventPoint() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int A = Integer.parseInt(data[0]); // 고정비용
        int B = Integer.parseInt(data[1]); // 가변비용
        int C = Integer.parseInt(data[2]); //가격
        double profit = C - B;

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        if (profit <= 0) output.write("-1");
        else output.write((int) (A / profit + 1) + "");

        output.flush();
        output.close();
    }

    private void HoneyBeeHouse() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int number = Integer.parseInt(input.readLine());
        int count = 1;

        if (number == 1) System.out.println(1);
        else {
            int range = 2;
            while (range <= number) {
                range += (count * 6);
                count++;
            }

            System.out.println(count);
        }
    }

    private void SnailUp() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int A = Integer.parseInt(data[0]); // 낮에 올라가는 거리
        int B = Integer.parseInt(data[1]); // 밤에 떨어지는 거리
        int V = Integer.parseInt(data[2]); // 나무길이
        int days = (int) Math.ceil((V - B) / (double) (A - B));
        System.out.println(days);
    }

    private void SugarDeliv() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int gram = Integer.parseInt(input.readLine());
        int min = Integer.MAX_VALUE;

        if (gram < 5 && gram % 3 != 0) System.out.println(-1);
        else {
            for (int i = 0; i < gram / 5 + 1; i++) {
                int n = gram - 5 * i;
                if (n < 0) break;
                if (n % 3 == 0) {
                    min = Math.min(min, (n / 3 + i));
                }
            }

            System.out.println(min);
        }
    }

    private void BigIntPlus() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        BigInteger num1 = new BigInteger(data[0]);
        BigInteger num2 = new BigInteger(data[0]);

        System.out.println(num1.add(num2));
    }

    public static void main(String[] args) throws IOException {
        BasicMath basicMath = new BasicMath();

//        basicMath.BreakEventPoint();
//        basicMath.HoneyBeeHouse();
//        basicMath.SnailUp();
        basicMath.SugarDeliv();
//        basicMath.BigIntPlus();
    }
}
