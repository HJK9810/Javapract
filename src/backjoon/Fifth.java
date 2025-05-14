package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fifth {
    private void polygonArea() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        final int SIZE = Integer.parseInt(input.readLine());
        int[][] polygon = new int[SIZE][2];
        long sum = 0;

        for (int i = 0; i < SIZE; i++) {
            String[] polygonStr = input.readLine().split(" ");
            polygon[i][0] = Integer.parseInt(polygonStr[0]);
            polygon[i][1] = Integer.parseInt(polygonStr[1]);
        }

        for (int idx = 0; idx < SIZE; idx++) {
            int x1 = polygon[idx][0];
            int y1 = polygon[idx][1];
            int x2 = polygon[(idx + 1) % SIZE][0];
            int y2 = polygon[(idx + 1) % SIZE][1];

            sum += ((long) x1 * y2 - (long) x2 * y1);
        }
        System.out.println(String.format("%.1f", Math.abs(sum / 2.0)));
    }

    public static void main(String[] args) throws IOException {
        Fifth fifth = new Fifth();

        fifth.polygonArea();
    }
}
