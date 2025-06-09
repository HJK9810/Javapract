package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Third2 {
    private int count;

    private void permutation(int depth, int targetSum, int currentSum) {
        int[] base = {1, 2, 3};

        if (currentSum > targetSum) return;
        if (currentSum == targetSum) {
            count += 1;
            return;
        }

        for (int num : base) {
            permutation(depth + 1, targetSum, currentSum + num);
        }
    }

    private void Add123() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        final int SIZE = Integer.parseInt(input.readLine());

        for (int i = 0; i < SIZE; i++) {
            final int number = Integer.parseInt(input.readLine());
            count = 0;

            permutation(0, number, 0);
            output.write(count + "\n");
        }

        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Third2 third2 = new Third2();

        third2.Add123();
    }
}
