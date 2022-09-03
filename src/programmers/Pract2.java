package programmers;

public class Pract2 {
    private static int[] pact;

    private static int pactorial(int num) {
        pact[0] = 1;
        for (int i = 1; i <= num; i++) {
            pact[i] = pact[i - 1] * i;
        }
        return pact[num];
    }

    private int Nx2Tiling(int n) {
        int answer = 0;
        int countTwo = n / 2;
        int countOne = 0;
        int add = 0;
        pact = new int[n + 1];
        pactorial(n);

        if (n % 2 == 1) {
            n -= 1;
            countTwo = n / 2;
            answer += (countTwo + 1);
            add = 1;
        } else answer += 2;

        int i = 1;
        while (countTwo != 1) {
            countTwo = n / 2 - i;
            countOne = i * 2 + add;
            answer += (pact[countOne + countTwo] / (pact[countOne] * pact[countTwo]));
            i++;
        }

        return answer;
    }


    // level2 연습문제
    public static void main(String[] args) {
        Pract2 pract2 = new Pract2();

        // 2 x n 타일링
        System.out.println(pract2.Nx2Tiling(4));
        System.out.println(pract2.Nx2Tiling(4) == 5);
    }
}
