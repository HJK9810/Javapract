package programmers.kakao;

import java.util.*;

public class Blind22 {
    private int[] Report(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> checks = new HashMap<>();
        for(String name : id_list) {
            HashSet<String> set = new HashSet<>();
            checks.put(name, set);
        }

        for(String line : report) {
            String[] names = line.split(" ");
            HashSet<String> set = checks.get(names[1]);
            set.add(names[0]);
            checks.put(names[1], set);
        }
        int[] answer = new int[id_list.length];
        int idx = 0;
        for(String key : checks.keySet()) {
            answer[idx] = checks.get(key).size();
        }
        return answer;
    }

    public static void main(String[] args) {
        Blind22 blind22 = new Blind22();

        System.out.println(blind22.Report(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));
        System.out.println(blind22.Report(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
    }
}
