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

    public static void main(String[] args) throws IOException {
        Recursion recursion = new Recursion();

        recursion.Pactorial(); // 팩토리얼
    }
}
