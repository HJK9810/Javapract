package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking {
    private static StringBuilder sb = new StringBuilder();

    private void permutation(int[] arr, int[] out, int depth, int r) {
        if (depth == r) {
            for (int num : out) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            out[depth] = arr[i];
            permutation(arr, out, depth + 1, r);
        }
    }

    private void NandM3() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int depth = Integer.parseInt(line[1]);

        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = i + 1;
        }

        permutation(numbers, new int[depth], 0, depth);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BackTracking backtraking = new BackTracking();

        backtraking.NandM3();
    }
}
