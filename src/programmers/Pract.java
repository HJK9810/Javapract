package programmers;

public class Pract {
    private long[] SequenceXd(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Long.valueOf(x) * (i + 1);
        }
        return answer;
    }

    private int CollatzSearch(long num) {
        int count = 0;

        while (num != 1) {
            if (count == 500) {
                count = -1;
                break;
            } else {
                num = (num % 2 == 0) ? num / 2 : (num * 3 + 1);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Pract pract = new Pract();

        // 콜라츠 추측
        System.out.println(pract.CollatzSearch(6));
        System.out.println(pract.CollatzSearch(16));
        System.out.println(pract.CollatzSearch(626331));
        System.out.println(pract.CollatzSearch(1));
    }
}
