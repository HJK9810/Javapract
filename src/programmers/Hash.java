package programmers;

import java.util.*;

public class Hash {
    private int PoketMon(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) set.add(num);
        int count = set.size();

        return nums.length / 2 <= count ? nums.length / 2 : count;
    }

    public static void main(String[] args) {

    }
}
