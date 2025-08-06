package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LazyPropagation {
    private long[] tree;
    private long[] lazy;

    private void init(int node, int start, int end, long[] initial) {
        if (start == end) {
            tree[node] = initial[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid, initial);
        init(node * 2 + 1, mid + 1, end, initial);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private void propagate(int node, int start, int end) {
        if (lazy[node] == 0) return;

        tree[node] += (end - start + 1) * lazy[node];

        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }

    private void update(long value, int node, int start, int end, int left, int right) {
        propagate(node, start, end);
        if (right < start || end < left) return;

        if (left <= start && end <= right) {
            lazy[node] += value;
            propagate(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        update(value, node * 2, start, mid, left, right);
        update(value, node * 2 + 1, mid + 1, end, left, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private long query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

    private void LazySegment() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int questSize = Integer.parseInt(line[1]) + Integer.parseInt(line[2]);

        tree = new long[SIZE * 4];
        lazy = new long[SIZE * 4];

        long[] initial = new long[SIZE];
        for (int idx = 0; idx < SIZE; idx++) {
            initial[idx] = Long.parseLong(input.readLine());
        }
        init(1, 0, SIZE - 1, initial);

        for (int count = 0; count < questSize; count++) {
            String[] order = input.readLine().split(" ");
            int command = Integer.parseInt(order[0]);
            int left = Integer.parseInt(order[1]);
            int right = Integer.parseInt(order[2]);

            if (command == 1) {
                long value = Long.parseLong(order[3]);
                update(value, 1, 0, SIZE - 1, left, right);
            } else {
                long sum = query(1, 0, SIZE - 1, left, right);
                output.write(sum + " ");
                output.newLine();
            }
        }
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        LazyPropagation lazyPropagation = new LazyPropagation();

        lazyPropagation.LazySegment();
    }
}
