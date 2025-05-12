package backjoon;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Fourth {
    private void checkOne(int base, int count, Set<Integer> list) {
        if (base == 1) {
            list.add(count);
            return;
        }

        if (base % 3 == 0) {
            checkOne(base / 3, count + 1, list);
        }
        if (base % 2 == 0) {
            checkOne(base / 2, count + 1, list);
        }
        checkOne(base - 1, count + 1, list);
    }

    private void changedOne() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(input.readLine());
        Set<Integer> list = new HashSet<>();

        checkOne(number, 0, list);
        int min = Collections.min(list);

        System.out.println(min);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

        fourth.changedOne();
    }
}
