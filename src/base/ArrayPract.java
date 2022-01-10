package base;

import java.util.Arrays;

public class ArrayPract {
    public static void MaxMinCehck() {
        int[] ary = new int[] {90, 80, 20, 60, 70};
        Arrays.sort(ary);
        System.out.printf("최솟값은 %d입니다.\n", ary[0]);
        System.out.printf("최댓값은 %d입니다.\n", ary[ary.length-1]);
    }
    public static void main(String[] args) {
        MaxMinCehck();
    }
}
