package programmers.kakao;

import java.util.*;

public class Intern20 {
    private String PushKeyPad(int[] numbers, String hand) {
        HashMap<String, int[]> keySets = new HashMap<>();
        keySets.put("1", new int[]{0, 3});
        keySets.put("2", new int[]{1, 3});
        keySets.put("3", new int[]{2, 3});
        keySets.put("4", new int[]{0, 2});
        keySets.put("5", new int[]{1, 2});
        keySets.put("6", new int[]{2, 2});
        keySets.put("7", new int[]{0, 1});
        keySets.put("8", new int[]{1, 1});
        keySets.put("9", new int[]{2, 1});
        keySets.put("0", new int[]{1, 0});
        keySets.put("*", new int[]{0, 0});
        keySets.put("#", new int[]{2, 0});

        List<String> ans = new ArrayList<>();
        String pushR = "#";
        String pushL = "*";
        int plenR = 0;
        int plenL = 0;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                pushL = num + "";
                ans.add("L");
            } else if (num == 3 || num == 6 || num == 9) {
                pushR = num + "";
                ans.add("R");
            } else {
                plenR = Math.abs(keySets.get(num + "")[0] - keySets.get(pushR)[0]) + Math.abs(keySets.get(num + "")[1] - keySets.get(pushR)[1]);
                plenL = Math.abs(keySets.get(num + "")[0] - keySets.get(pushL)[0]) + Math.abs(keySets.get(num + "")[1] - keySets.get(pushL)[1]);

                if (plenL == plenR) {
                    if (hand.equals("right")) {
                        pushR = num + "";
                        ans.add("R");
                    } else {
                        pushL = num + "";
                        ans.add("L");
                    }
                } else if (plenL < plenR) {
                    pushL = num + "";
                    ans.add("L");
                } else {
                    pushR = num + "";
                    ans.add("R");
                }
            }
        }

        return String.join("", ans);
    }

    public static void main(String[] args) {
        Intern20 intern20 = new Intern20();

        // 키패드 누르기
        System.out.println(intern20.PushKeyPad(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(intern20.PushKeyPad(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right").equals("LRLLLRLLRRL"));
        System.out.println(intern20.PushKeyPad(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left").equals("LRLLRRLLLRR"));
        System.out.println(intern20.PushKeyPad(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right").equals("LLRLLRLLRL"));
    }
}
