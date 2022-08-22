package programmers.kakao;

import java.util.*;

public class Blind22 {
    private int[] Report(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> checks = new HashMap<>();
        HashMap<String, HashSet<String>> forReport = new HashMap<>();
        for(String name : id_list) {
            HashSet<String> set1 = new HashSet<>();
            checks.put(name, set1);

            HashSet<String> set2 = new HashSet<>();
            forReport.put(name, set2);
        }

        for(String line : report) {
            String[] names = line.split(" ");
            HashSet<String> set = checks.get(names[1]);
            set.add(names[0]);
            checks.put(names[1], set);

            HashSet<String> set2 = forReport.get(names[0]);
            set2.add(names[1]);
            forReport.put(names[0], set2);
        }
        StringBuffer sb = new StringBuffer();
        for(String key : checks.keySet()) {
            if (checks.get(key).size() >= k) sb.append(key + " ");
        }

        int[] answer = new int[id_list.length];
        for(String key : forReport.keySet()) {
            String[] names = sb.toString().split(" ");
            int idx = Arrays.asList(id_list).indexOf(key);
            for(String name : names) {
                if(forReport.get(key).contains(name)) answer[idx]++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Blind22 blind22 = new Blind22();

        System.out.println(blind22.Report(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));
        System.out.println(blind22.Report(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
    }
}
