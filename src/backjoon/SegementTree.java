package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SegementTree {
    private long[] tree;

    private void update(int index, long diff, int node, int start, int end) {
        if (index < start || end < index) return;

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            if (index <= mid) update(index, diff, 2 * node, start, mid);
            else update(index, diff, 2 * node + 1, mid + 1, end);
        }
    }

    private void update2(int index, long value, int node, int start, int end) {
        if (index < start || end < index) return;
        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid) update2(index, value, 2 * node, start, mid);
        else update2(index, value, 2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] * tree[2 * node + 1];
    }

    private void init(int node, int start, int end, long[] initial) {
        if (start == end) {
            tree[node] = initial[start];
            return;
        }

        int mid = (start + end) / 2;
        init(2 * node, start, mid, initial);
        init(2 * node + 1, mid + 1, end, initial);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private void init2(int node, int start, int end, long[] initial) {
        if (start == end) {
            tree[node] = initial[start];
            return;
        }

        int mid = (start + end) / 2;
        init2(2 * node, start, mid, initial);
        init2(2 * node + 1, mid + 1, end, initial);
        tree[node] = tree[2 * node] * tree[2 * node + 1];
    }

    private long query(int left, int right, int node, int start, int end) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(left, right, 2 * node, start, mid) + query(left, right, 2 * node + 1, mid + 1, end);
    }

    private long multiQuery(int left, int right, int node, int start, int end) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return multiQuery(left, right, 2 * node, start, mid) * multiQuery(left, right, 2 * node + 1, mid + 1, end);
    }

    private void IntervalSum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int updateSize = Integer.parseInt(line[1]);
        final int sumSize = Integer.parseInt(line[2]);

        tree = new long[4 * SIZE];

        long[] initial = new long[SIZE];
        for (int index = 0; index < SIZE; index++) {
            initial[index] = Long.parseLong(input.readLine());
        }
        init(1, 0, SIZE - 1, initial);

        for (int count = 0; count < updateSize + sumSize; count++) {
            String[] order = input.readLine().split(" ");

            String op = order[0];
            int start = Integer.parseInt(order[1]) - 1;
            if (op.equals("1")) {
                long diff = Long.parseLong(order[2]) - initial[start];
                initial[start] = Long.parseLong(order[2]);
                update(start, diff, 1, 0, SIZE - 1);
            } else {
                long sum = query(start, Integer.parseInt(order[2]) - 1, 1, 0, SIZE - 1);
                output.write(sum + "\n");
            }
        }

        output.flush();
        output.close();
    }

    private void IntervalMulti() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int updateSize = Integer.parseInt(line[1]);
        final int sumSize = Integer.parseInt(line[2]);

        tree = new long[4 * SIZE];

        long[] initial = new long[SIZE];
        for (int index = 0; index < SIZE; index++) {
            initial[index] = Long.parseLong(input.readLine());
        }
        init2(1, 0, SIZE - 1, initial);

        for (int count = 0; count < updateSize + sumSize; count++) {
            String[] order = input.readLine().split(" ");

            String op = order[0];
            int start = Integer.parseInt(order[1]) - 1;

            if (op.equals("1")) {
                initial[start] = Long.parseLong(order[2]);
                update2(start, initial[start], 1, 0, SIZE - 1);
            } else {
                long multi = multiQuery(start, Integer.parseInt(order[2]) - 1, 1, 0, SIZE - 1);
                output.write(multi + "\n");
            }
        }

        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException  {
        SegementTree segementTree = new SegementTree();

//        segementTree.IntervalSum();
        segementTree.IntervalMulti();
    }
}
