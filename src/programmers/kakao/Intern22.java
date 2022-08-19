package programmers.kakao;

import java.util.*;

public class Intern22 {
    private String personality(String[] survey, int[] choices) {
        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        int[] points = {1, 2, 3};
        HashMap<String, Integer> checks = new HashMap<>();
        for(String type : types) {
            checks.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String[] type = survey[i].split("");
            if(choices[i] < 4) {
                checks.put(type[0], checks.get(type[0]) + points[3 - choices[i]]);
            } else if(choices[i] > 4) {
                checks.put(type[1], checks.get(type[1]) + points[choices[i] - 5]);
            }
        }
        StringBuffer answer = new StringBuffer();
        if(checks.get("R") >= checks.get("T")) answer.append("R");
        else answer.append("T");
        if(checks.get("C") >= checks.get("F")) answer.append("C");
        else answer.append("F");
        if(checks.get("J") >= checks.get("M")) answer.append("J");
        else answer.append("M");
        if(checks.get("A") >= checks.get("N")) answer.append("A");
        else answer.append("N");

        return answer.toString();
    }

    public static void main(String[] args) {
        Intern22 intern22 = new Intern22();

        System.out.println(intern22.personality(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(intern22.personality(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
