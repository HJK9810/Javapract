package backjoon;

import java.io.*;

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

    public static void main(String[] args) throws IOException {
        BasicMath2 basicMath2 = new BasicMath2();

        // 소수 찾기
        basicMath2.Decimal();
    }
}
