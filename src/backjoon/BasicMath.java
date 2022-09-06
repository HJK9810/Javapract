package backjoon;

import java.io.*;
import java.math.BigInteger;

public class BasicMath {
    private void BreakEventPoint() throws IOException { // 손익분기점
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

    private void HoneyBeeHouse() throws IOException { // 벌집
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

    private void SnailUp() throws IOException { // 달팽이는 올라가고싶다
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int A = Integer.parseInt(data[0]); // 낮에 올라가는 거리
        int B = Integer.parseInt(data[1]); // 밤에 떨어지는 거리
        int V = Integer.parseInt(data[2]); // 나무길이
        int days = (int) Math.ceil((V - B) / (double) (A - B));
        System.out.println(days);
    }

    private void ACMHotel() throws IOException { // ACM 호텔
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < SIZE; i++) {
            String[] data = input.readLine().split(" ");
            int lay = Integer.parseInt(data[2]) % Integer.parseInt(data[0]);
            int cow = Integer.parseInt(data[2]) / Integer.parseInt(data[0]);

            if (lay == 0) lay = Integer.parseInt(data[0]);

            answer.append(lay + String.format("%02d", (cow + 1)) + "\n");
        }

        System.out.println(answer.toString());
    }

    private void CheckPeople() throws IOException { // 부녀회장이 될테야

    }

    private void SugarDeliv() throws IOException { // 설탕배달
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int gram = Integer.parseInt(input.readLine());
        int ans = 0;

        while (gram >= 0) {
            if (gram % 5 == 0) {
                ans += (gram / 5);
                System.out.println(ans);
                return;
            }
            gram -= 3;
            ans++;
        }

        System.out.println(-1);
    }

    private void BigIntPlus() throws IOException { // 큰 수 A + B
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
//        basicMath.ACMHotel();
//        basicMath.SugarDeliv();
//        basicMath.BigIntPlus();
    }
}
