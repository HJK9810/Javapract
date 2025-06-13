package backjoon;

import java.io.*;
import java.util.*;

public class Recursion {
    // 팩토리얼
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

    // 피보나치 수5
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

    // 재귀가 뭐에요
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

    // 재귀의 귀재
    private static int countRecur;

    private static int recursion(String s, int l, int r) {
        countRecur++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    private static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    private void RecurRecur() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        final int SIZE = Integer.parseInt(input.readLine());

        for (int i = 0; i < SIZE; i++) {
            countRecur = 0;
            int result = isPalindrome(input.readLine());
            output.write(result + " " + countRecur + "\n");
        }
        output.flush();
        output.close();
    }

    // 알고리즘 수업
    private static int count = 0;
    private static int result = -1;

    private static void merge_sort(int[] ary, int left, int right, int forC) {
        if (left < right) {
            int mid =  (right + left) / 2;
            merge_sort(ary, left, mid, forC);
            merge_sort(ary, left, mid, forC);
            merge_sort(ary, mid + 1, right, forC);
            merge(ary, left, mid, right, forC);
        }
    }

    private static void merge(int[] ary, int left, int mid, int right, int forC) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, t = 0;

        while (i <= mid && j <= right) {
            if (ary[i] <= ary[j]) {
                temp[t++] = ary[i++];
            } else {
                temp[t++] = ary[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = ary[i++];
        }
        while (j <= right) {
            temp[t++] = ary[j++];
        }

        for (int idx = 0; idx < temp.length; idx++) {
            ary[left + idx] = temp[idx];
            count++;
            if (count == forC) {
                result = temp[idx];
            }
        }
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

        merge_sort(numbers, 0, SIZE - 1, forCount);
        System.out.println(result);
    }

    static StringBuffer sb = new StringBuffer();

    private void stars(int x, int y, int num) {
        if ((x / num) % 3 == 1 && (y / num) % 3 == 1) {
            sb.append(" ");
        } else {
            if (num / 3 == 0) sb.append("*");
            else stars(x, y, num / 3);
        }
    }

    private void DrawStart() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                stars(i, j, SIZE);
            }
            sb.append("\n");
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(sb.toString());
        output.flush();
        output.close();
    }

    static StringBuffer root = new StringBuffer();

    private void move(int start, int end) {
        root.append(start + " " + end + "\n");
    }

    private void honoi(int num, int start, int end, int via) {
        if (num == 1) move(start, end);
        else {
            honoi(num - 1, start, via, end);
            move(start, end);
            honoi(num - 1, via, end, start);
        }
    }

    private void HonoiTower() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());

        int count = (int) Math.pow(2, SIZE) - 1;
        honoi(SIZE, 1, 3, 2);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(count + "\n" + root.toString());
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Recursion recursion = new Recursion();

//        recursion.Pactorial(); // 팩토리얼
//        recursion.Fibonacci(); // 피보나치 수5
//        recursion.Recurs();
//        recursion.RecurRecur(); // 재귀의 귀재
        recursion.AlgorismClass(); // 알고리즘 수업
//        recursion.DrawStart(); // 별찍기-10
//        recursion.HonoiTower(); // 하노이의탑
    }
}
