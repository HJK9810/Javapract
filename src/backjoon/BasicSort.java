package backjoon;

import java.io.*;
import java.util.*;

public class BasicSort {
    private void Sorting() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        List<Integer> sort = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            sort.add(Integer.parseInt(input.readLine()));
        }

        Collections.sort(sort);

        for (int num : sort) {
            System.out.println(num);
        }
    }


    public static void main(String[] args) throws IOException {
        BasicSort basicSort = new BasicSort();

        // 수 정렬하기
        basicSort.Sorting();
    }
}
