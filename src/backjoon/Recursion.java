package backjoon;

import java.io.*;
import java.util.*;

public class Recursion {
    private static int pact(int n) {
        if (n > 1) return n * pact(n - 1);
        else return 1;
    }

    private void Pactorial() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(pact(Integer.parseInt(input.readLine())) + "\n");
        output.flush();
        output.close();
    }

    private static int Fibo(int n) {
        if (n > 1) return Fibo(n - 1) + Fibo(n - 2);
        else if (n == 1) return 1;
        else return 0;
    }

    private void Fibonacci() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(Fibo(Integer.parseInt(input.readLine())) + "\n");
        output.flush();
        output.close();
    }

    static String underbar = "";

    private static void strRE(int n) throws IOException {
        String line = underbar;
        StringBuffer sb = new StringBuffer();

        if (n == 0) {
            System.out.println(line + "\"재귀함수가 뭔가요?\"");
            System.out.println(line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(line + "라고 답변하였지.");
            return;
        }
        System.out.println(line + "\"재귀함수가 뭔가요?\"");
        System.out.println(line + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        underbar += "____";
        strRE(n - 1);
        System.out.println(line + "라고 답변하였지.");
    }

    private void Recurs() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        strRE(num);
    }

    private static int[] merge_sort(int[] ary, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(ary, p, q);
            merge_sort(ary, q + 1, r);
            merge(ary, p, q, r);
        }

        return ary;
    }

    private static int[] merge(int[] ary, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 1;
        int[] temp = new int[ary.length];

        while (i < q && j < r) {
            if (ary[i] <= ary[j]) {
                temp[t++] = ary[i++];
                temp[t] = ary[i];
                t++;
                i++;
            } else {
                temp[t++] = ary[j++];
                temp[t] = ary[j];
                t++;
                j++;
            }
        }

        while (i < q) temp[t++] = ary[i++];

        while (j < r) temp[t++] = ary[j++];

        i = p;
        t = 1;
        while (i < r) ary[i++] = temp[t++];

        return ary;
    }

    private void AlgorismClass() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int forCount = Integer.parseInt(line[1]);

        String[] ary = input.readLine().split(" ");
        int[] numbers = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Integer.parseInt(ary[i]);
        }

        merge_sort(numbers, 0, SIZE - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public static void main(String[] args) throws IOException {
        Recursion recursion = new Recursion();

//        recursion.Pactorial(); // 팩토리얼
//        recursion.Fibonacci(); // 피보나치 수5
//        recursion.Recurs();
        recursion.AlgorismClass(); // 알고리즘 수업
    }
}
