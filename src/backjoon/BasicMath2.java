package backjoon;

import java.io.*;
import java.util.*;

public class BasicMath2 {
    private void Decimal() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        String[] nums = input.readLine().split(" ");
        int count = 0;

        for (String str : nums) {
            int num = Integer.parseInt(str);
            boolean check = false;
            if (num == 1) continue;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    check = true;
                    break;
                }
            }
            if (!check) count++;
        }

        System.out.println(count);
    }

    private void Decimal2() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(input.readLine());
        int end = Integer.parseInt(input.readLine());

        // 에라토스테네스의 체
        boolean[] primeList = new boolean[end + 1];
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;

        // 2부터  ~ i*i <= n  각각의 배수들을 지워가기
        for (int i = 2; (i * i) <= end; i++) {
            if (primeList[i]) {
                for (int j = i * i; j <= end; j += i) primeList[j] = false;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (primeList[i]) {
                sum += i;
                if (min > i) min = i;
            }
        }

        if (sum == 0) System.out.println(-1);
        else System.out.println(sum + "\n" + min);
    }

    private void Decimal3() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        // 에라토스테네스의 체
        boolean[] primeList = new boolean[end + 1];
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;

        // 2부터  ~ i*i <= n  각각의 배수들을 지워가기
        for (int i = 2; (i * i) <= end; i++) {
            if (primeList[i]) {
                for (int j = i * i; j <= end; j += i) primeList[j] = false;
            }
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = start; i <= end; i++) {
            if (primeList[i]) output.write(i + "\n");
        }
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        BasicMath2 basicMath2 = new BasicMath2();

//        basicMath2.Decimal(); // 소수 찾기
//        basicMath2.Decimal2(); // 소수
        basicMath2.Decimal3(); // 소수 구하기
    }
}
