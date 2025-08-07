package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SegmentTreeBasic {
    private long[] tree;
    private long[] initial;

    private int initIndex(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return start;
        }

        int mid = (start + end) / 2;
        int left = initIndex(node * 2, start, mid);
        int right = initIndex(node * 2 + 1, mid + 1, end);

        if (initial[left] == initial[right]) tree[node] = Math.min(left, right);
        else tree[node] = initial[left] < initial[right] ? left : right;
        return (int) tree[node];
    }

    private int updateIndex(int index, int value, int node, int start, int end) {
        if (index < start || end < index) return (int) tree[node];
        if (start == end) {
            tree[node] = index;
            return index;
        }

        int mid = (start + end) / 2;
        int left = updateIndex(index, value, node * 2, start, mid);
        int right = updateIndex(index, value, node * 2 + 1, mid + 1, end);

        if (initial[left] == initial[right]) tree[node] = Math.min(left, right);
        else tree[node] = initial[left] < initial[right] ? left : right;
        return (int) tree[node];
    }

    private void SequenceAndQuery() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int SIZE = Integer.parseInt(input.readLine());
        initial = new long[SIZE];

        String[] ary = input.readLine().split(" ");
        for (int idx = 0; idx < SIZE; idx++) {
            initial[idx] = Long.parseLong(ary[idx]);
        }

        tree = new long[SIZE * 4];
        initIndex(1, 0, SIZE - 1);

        final int questSize = Integer.parseInt(input.readLine());
        for (int count = 0; count < questSize; count++) {
            String[] line = input.readLine().split(" ");
            String order = line[0];

            if (order.equals("1")) {
                int index = Integer.parseInt(line[1]) - 1;
                int value = Integer.parseInt(line[2]);
                initial[index] = value;
                updateIndex(index, value, 1, 0, SIZE - 1);
            } else {
                sb.append(tree[1] + 1).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        SegmentTreeBasic basic = new SegmentTreeBasic();

        basic.SequenceAndQuery();
    }
}
