package programmers;

import java.util.*;

public class BruteForce {
    private int MinRect(int[][] sizes) {
        List<Integer> width = new ArrayList<>();
        List<Integer> height = new ArrayList<>();

        for(int[] rect : sizes) {
            int w = rect[0];
            int h = rect[1];

            if(w > h) {
                width.add(w);
                height.add(h);
            } else {
                width.add(h);
                height.add(w);
            }
        }
        return Collections.max(width) * Collections.max(height);
    }

    private int[] MockExam(int[] answers) {
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int ans1 = 0, ans2 = 0, ans3 = 0;

        for(int i=0;i<answers.length;i++) {
            if(answers[i] == stu1[i % stu1.length]) ans1++;
            if(answers[i] == stu2[i % stu2.length]) ans2++;
            if(answers[i] == stu3[i % stu3.length]) ans3++;
        }
        int max = Math.max(Math.max(ans1, ans2), ans3);
        StringBuffer str = new StringBuffer();
        if(max == ans1) str.append(ans1);
        if(max == ans2) str.append(ans2);
        if(max == ans3) str.append(ans3);

        return Arrays.stream(str.toString().split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
    }
}
