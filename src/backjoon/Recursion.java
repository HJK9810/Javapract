package backjoon;

import java.io.*;

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

    public static void main(String[] args) throws IOException {
        Recursion recursion = new Recursion();

//        recursion.Pactorial(); // 팩토리얼
        recursion.Fibonacci(); // 피보나치 수5
    }
}
