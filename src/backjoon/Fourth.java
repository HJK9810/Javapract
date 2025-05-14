package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fourth {
    private void fixAtoB() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] inputvalue = input.readLine().split(" ");
        int first = Integer.parseInt(inputvalue[0]);
        int second = Integer.parseInt(inputvalue[1]);
        int count = 0;
        boolean isImpossibleValue = false;

        while (first < second) {
            if (second % 2 == 0) {
                second /= 2;
                count++;
            } else {
                if (second % 10 != 1) {
                    isImpossibleValue = true;
                    break;
                }
                second /= 10;
                count++;
            }

            if (first > second) {
                isImpossibleValue = true;
                break;
            }
        }

        System.out.println(isImpossibleValue ? -1 : count + 1);
    }

    public static void main(String[] args) throws IOException {
        Fourth fourth = new Fourth();

        fourth.fixAtoB();
    }
}
