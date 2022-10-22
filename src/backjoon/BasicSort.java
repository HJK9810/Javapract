package backjoon;

import java.io.*;
import java.util.*;
import java.util.zip.CheckedOutputStream;

public class BasicSort {
    private void Sorting() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        List<Integer> sort = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            sort.add(Integer.parseInt(input.readLine()));
        }

        Collections.sort(sort);

        for (int num : sort) {
            System.out.println(num);
        }
    }

    private void Sorting2() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        List<Integer> sort = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            sort.add(Integer.parseInt(input.readLine()));
        }

        Collections.sort(sort);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num : sort) {
            output.write(num + "\n");
        }
        output.flush();
        output.close();
    }

    private void Sorting3() throws IOException { // 카운팅정렬
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        int[] sort = new int[SIZE];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < SIZE; i++) {
            int num = Integer.parseInt(input.readLine());
            sort[i] = num;
            if (num > max) max = num;
        }

        // 1. 인덱스에 해당하는 값이 얼마나 들었는지 체크
        int[] counting = new int[max + 1];
        for (int i = 0; i < SIZE; i++) {
            counting[sort[i]] += 1;
        }

        // 2. 카운팅 베열 누적합으로 전환.
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 3. 해당하는 위치에 배열
        int[] result = new int[SIZE];
        for (int i = SIZE - 1; i >= 0; i--) {
            int idx = sort[i];
            counting[idx] -= 1;
            result[counting[idx]] = idx;
        }


        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num : result) {
            output.write(num + "\n");
        }
        output.flush();
        output.close();
    }

    private void Cutline() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        final int SIZE = Integer.parseInt(line[0]);
        final int cut = Integer.parseInt(line[1]);
        String[] grades = input.readLine().split(" ");
        int[] sort = new int[SIZE];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < SIZE; i++) {
            int num = Integer.parseInt(grades[i]);
            sort[i] = num;
            if (num > max) max = num;
        }

        // 카운팅정렬
        int[] counting = new int[max + 1];
        for (int i = 0; i < SIZE; i++) {
            counting[sort[i]] += 1;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        int[] result = new int[SIZE];
        for (int i = SIZE - 1; i >= 0; i--) {
            int idx = sort[i];
            counting[idx] -= 1;
            result[counting[idx]] = idx;
        }


        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(result[cut - 1]);
        output.flush();
        output.close();
    }

    private void statistics() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        int[] nums = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            nums[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(nums);
        int mid = nums[SIZE / 2];

        HashMap<Integer, Integer> counts = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += nums[i];
            if (!counts.containsKey(nums[i])) counts.put(nums[i], 1);
            else counts.put(nums[i], counts.get(nums[i]) + 1);
        }
        int aver = (int) (((double) sum / SIZE) * 10) / 10;
        int max = Integer.MIN_VALUE;
        for (int num : counts.keySet()) {
            if (max < counts.get(num)) max = counts.get(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : counts.keySet()) {
            if (counts.get(num) == max) {
                list.add(num);
            }
        }
        Collections.sort(list);
        int count = 0;
        if (list.size() == 1) count = list.get(0);
        else count = list.get(1);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(aver + "\n" + mid + "\n" + count + "\n" + (nums[SIZE - 1] - nums[0]));
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        BasicSort basicSort = new BasicSort();

//        basicSort.Sorting(); // 수 정렬하기
//        basicSort.Sorting3(); // 수 정렬하기3 - 카운팅정렬
//        basicSort.Cutline(); // 커트라인
        basicSort.statistics(); // 통계학
    }
}
