package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SegementTree {
    private long[] tree;
    private final long MOD = 1000000007;

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
        tree[node] = (tree[2 * node] * tree[2 * node + 1]) % MOD;
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
        tree[node] = (tree[2 * node] * tree[2 * node + 1]) % MOD;
    }

    private void minInit(int node, int start, int end, long[] initial) {
        if (start == end) {
            minTree[node] = initial[start];
            return;
        }

        int mid = (start + end) / 2;
        minInit(2 * node, start, mid, initial);
        minInit(2 * node + 1, mid + 1, end, initial);
        minTree[node] = Math.min(minTree[2 * node], minTree[2 * node + 1]);
    }

    private void maxInit(int node, int start, int end, long[] initial) {
        if (start == end) {
            maxTree[node] = initial[start];
            return;
        }

        int mid = (start + end) / 2;
        maxInit(2 * node, start, mid, initial);
        maxInit(2 * node + 1, mid + 1, end, initial);
        maxTree[node] = Math.max(maxTree[2 * node], maxTree[2 * node + 1]);
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
        return (multiQuery(left, right, 2 * node, start, mid) * multiQuery(left, right, 2 * node + 1, mid + 1, end)) % MOD;
    }

    private long minQuery(int left, int right, int node, int start, int end) {
        if (right < start || end < left) return Long.MAX_VALUE;
        if (left <= start && end <= right) return minTree[node];

        int mid = (start + end) / 2;
        long first = minQuery(left, right, 2 * node, start, mid);
        long second = minQuery(left, right, 2 * node + 1, mid + 1, end);

        return Math.min(first, second);
    }

    private long maxQuery(int left, int right, int node, int start, int end) {
        if (right < start || end < left) return Long.MIN_VALUE;
        if (left <= start && end <= right) return maxTree[node];

        int mid = (start + end) / 2;
        long first = maxQuery(left, right, 2 * node, start, mid);
        long second = maxQuery(left, right, 2 * node + 1, mid + 1, end);

        return Math.max(first, second);
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

    private void CalcMin() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int questSize = Integer.parseInt(line[1]);

        tree = new long[4 * SIZE];
        long[] initial = new long[SIZE];
        for (int index = 0; index < SIZE; index++) {
            initial[index] = Integer.parseInt(input.readLine());
        }
        minInit(1, 0, SIZE - 1, initial);

        for (int index = 0; index < questSize; index++) {
            String[] order = input.readLine().split(" ");
            int start = Integer.parseInt(order[0]) - 1;
            int end = Integer.parseInt(order[1]) - 1;

            long min = minQuery(start, end, 1, 0, SIZE - 1);
            output.write(min + "\n");
        }

        output.flush();
        output.close();
    }

    private long[] minTree;
    private long[] maxTree;
    private void CalcMinAndMax() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int questSize = Integer.parseInt(line[1]);

        minTree = new long[4 * SIZE];
        maxTree = new long[4 * SIZE];
        long[] initial = new long[SIZE];
        for (int index = 0; index < SIZE; index++) {
            initial[index] = Integer.parseInt(input.readLine());
        }
        minInit(1, 0, SIZE - 1, initial);
        maxInit(1, 0, SIZE - 1, initial);

        for (int index = 0; index < questSize; index++) {
            String[] order = input.readLine().split(" ");
            int start = Integer.parseInt(order[0]) - 1;
            int end = Integer.parseInt(order[1]) - 1;

            long min = minQuery(start, end, 1, 0, SIZE - 1);
            long max = maxQuery(start, end, 1, 0, SIZE - 1);
            output.write(min + " " + max + "\n");
        }

        output.flush();
        output.close();
    }

    private void CoffeeHouseSum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int questCount = Integer.parseInt(line[1]);

        tree = new long[4 * SIZE];
        long[] initial = new long[SIZE];
        String[] inputLine = input.readLine().split(" ");
        for (int index = 0; index < SIZE; index++) {
            initial[index] = Long.parseLong(inputLine[index]);
        }
        init(1, 0, SIZE - 1, initial);

        for (int count = 0; count < questCount; count++) {
            String[] order = input.readLine().split(" ");
            int first = Integer.parseInt(order[0]) - 1;
            int second = Integer.parseInt(order[1]) - 1;
            int index = Integer.parseInt(order[2]) - 1;
            long value = Long.parseLong(order[3]);

            long sum = query(Math.min(first, second), Math.max(first, second), 1, 0, SIZE - 1);
            output.write(sum + "\n");

            long diff = value - initial[index];
            initial[index] = value;
            update(index, diff, 1, 0, SIZE - 1);
        }

        output.flush();
        output.close();
    }

    private void IntervalSum7() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int questSize = Integer.parseInt(line[1]);

        tree = new long[4 * SIZE];
        long[] initial = new long[SIZE];

        for (int count = 0; count < questSize; count++) {
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

    public static void main(String[] args) throws IOException  {
        SegementTree segementTree = new SegementTree();

//        segementTree.IntervalSum();
//        segementTree.IntervalMulti();
//        segementTree.CalcMin();
//        segementTree.CalcMinAndMax();
//        segementTree.CoffeeHouseSum();
        segementTree.IntervalSum7();
    }
}
