package backjoon;

import java.io.*;
import java.util.*;

public class BasicString {
    public static void checkAscii() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write((int) input.readLine().charAt(0) + "\n");
        output.flush();
        output.close();
    }

    public static void NumsSum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int Num = Integer.parseInt(input.readLine());
        String[] number = input.readLine().split("");
        int sum = 0;

        for (int i = 0; i < Num; i++) {
            sum += Integer.parseInt(number[i]);
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(sum + "\n");
        output.flush();
        output.close();
    }

    public static void CountManyChar() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] str = input.readLine().toUpperCase().split("");
        ArrayList<String> alph = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        for (String ch : str) {
            int idx = alph.indexOf(ch);
            if (idx != -1) {
                count.set(idx, count.get(idx) + 1);
            } else {
                alph.add(ch);
                count.add(1);
            }
        }

        int maxCount = Collections.max(count);
        int check = 0;
        int idx = -1;

        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) == maxCount) {
                check += 1;
                idx = i;
            }
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        if (check != 1) output.write("?\n");
        else output.write(alph.get(idx) + "\n");
        output.flush();
        output.close();
    }

    public static void checkAlph() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String alph = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder index = new StringBuilder();

        for (int i = 0; i < alph.length(); i++) {
            index.append(String.format("%d ", str.indexOf(alph.charAt(i))));
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(index.toString());
        output.flush();
        output.close();
    }

    public static void repeatStr() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int textCase = Integer.parseInt(input.readLine());
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < textCase; i++) {
            String[] line = input.readLine().split(" ");
            int repeatNum = Integer.parseInt(line[0]);
            for (String alph : line[1].split("")) {
                str.append(alph.repeat(repeatNum));
            }
            str.append("\n");
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(str.toString());
        output.flush();
        output.close();
    }

    public static int numReverse(int num) {
        int result = 0;
        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    public static void comparReverNum() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split(" ");

        int num1 = numReverse(Integer.parseInt(numbers[0]));
        int num2 = numReverse(Integer.parseInt(numbers[1]));

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        if (num1 > num2) output.write(num1 + "\n");
        else output.write(num2 + "\n");

        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//		checkAlph();
//        repeatStr();
        comparReverNum();
    }
}