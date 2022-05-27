package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BasicFunc {
	public static int d(int n) {
		int sum = n;
		while (n >= 1) {
			sum = sum + n % 10;
			n /= 10;
		}

		return sum;
	}
	
	public static void SelfNum() throws IOException {
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		Boolean[] ary = new Boolean[10000];
		Arrays.fill(ary, false);
		StringBuffer str = new StringBuffer();

		for (int i = 0; i < ary.length; i++) {
			if (!ary[i]) {
				str.append((i + 1) + "\n");
			}
			int result = d(i + 1);
			if (result > 10000) continue;
			ary[result - 1] = true;
		}

		output.write(str.toString());
		output.flush();
		output.close();
	}

	public static boolean checkHanSu(int num) {
		if(num < 10) return true;
		
		ArrayList<Integer> nums = new ArrayList<>();
		HashSet<Integer> d = new HashSet<Integer>();
		
		while(num >= 1) {
			nums.add(num % 10);
			num /= 10;
		}
		
		for(int i=0;i<nums.size();i++) {
			if(i!=nums.size()-1) {
				d.add(nums.get(i+1) - nums.get(i));
			}
		}
		
		return d.size() == 1 ? true : false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		final int number = Integer.parseInt(input.readLine());
		int answer = 0;
		
		for(int i=1; i <= number;i++) {
			if(checkHanSu(i)) answer += 1;
		}
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		output.write(answer + "\n");
		output.flush();
		output.close();
	}
}
