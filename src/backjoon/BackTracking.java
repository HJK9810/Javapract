package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackTracking {
    private static boolean[] visited;
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

    private void combination(int[] base, int[] out, int depth, int r) {
        if (depth == r) {
            for (int num : out) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int num = 0; num < base.length; num++) {
            if (!visited[num]) {
                visited[num] = true;
                out[depth] = base[num];
                combination(base, out, depth + 1, r);
                visited[num] = false;
            }
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

    private void NandM5() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int depth = Integer.parseInt(line[1]);

        int[] base = new int[SIZE];
        String[] strBase = input.readLine().split(" ");

        for (int i = 0; i < SIZE; i++) {
            base[i] = Integer.parseInt(strBase[i]);
        }
        Arrays.sort(base);

        visited = new boolean[SIZE];
        combination(base, new int[depth], 0, depth);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BackTracking backtraking = new BackTracking();

        backtraking.NandM3();
    }
}
