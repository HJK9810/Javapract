package programmers;

import java.util.*;

public class Hash {
    private int PoketMon(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        int count = set.size();

        return nums.length / 2 <= count ? nums.length / 2 : count;
    }

    private String NotComplete(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if (!participant[i].equals(completion[i])) return participant[i];
        }
        return "";
    }

    public static void main(String[] args) {
        Hash hash = new Hash();
    }
}
