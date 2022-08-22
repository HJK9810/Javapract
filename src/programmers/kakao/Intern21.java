package programmers.kakao;

public class Intern21 {
    private int EngChangNum(String s) {
        String[] Nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < Nums.length; i++) {
            s = s.replaceAll(Nums[i], (i + ""));
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Intern21 intern21 = new Intern21();

        System.out.println(intern21.EngChangNum("one4seveneight"));
        System.out.println(intern21.EngChangNum("23four5six7"));
        System.out.println(intern21.EngChangNum("2three45sixseven"));
        System.out.println(intern21.EngChangNum("123"));
    }
}
