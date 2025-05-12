package backjoon;

import java.io.*;

public class Fourth {
    private void changedOne() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(input.readLine());
        int[] count = new int[number + 1];

        count[1] = 0;
        for (int idx = 2; idx <= number; idx++) {
            count[idx] = count[idx - 1] + 1;
            if (idx % 2 == 0) count[idx] = Math.min(count[idx], count[idx / 2] + 1);
            if (idx % 3 == 0) count[idx] = Math.min(count[idx], count[idx / 3] + 1);
        }

        System.out.println(count[number]);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

        fourth.changedOne();
    }
}
