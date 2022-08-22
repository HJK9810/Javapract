package programmers.kakao;

import java.util.*;

public class Blind18 {
    private String[] SecretMap(int n, int[] arr1, int[] arr2) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            StringBuffer sb = new StringBuffer();
            String chage = Integer.toString(arr1[i], 2);
            String num1 =  "0".repeat(n - chage.length()) + chage;
            chage = Integer.toString(arr2[i], 2);
            String num2 =  "0".repeat(n - chage.length()) + chage;

            for (int j = 0; j < n; j++) {
                if (num1.charAt(j) == '1' || num2.charAt(j) == '1') sb.append('#');
                else sb.append(' ');
            }
            answer.add(sb.toString());
        }

        return answer.toArray(new String[n]);
    }

    public static void main(String[] args) {
        Blind18 blind18 = new Blind18();

        System.out.println(Arrays.toString(blind18.SecretMap(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(blind18.SecretMap(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
    }
}
