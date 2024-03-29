package programmers;

import java.util.*;

public class Pract {
    private long[] SequenceXd(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Long.valueOf(x) * (i + 1);
        }
        return answer;
    }

    private int CollatzSearch(long num) {
        int count = 0;

        while (num != 1) {
            if (count == 500) {
                count = -1;
                break;
            } else {
                num = (num % 2 == 0) ? num / 2 : (num * 3 + 1);
                count++;
            }
        }
        return count;
    }

    private int[] DelMinNum(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (min > num) min = num;
        }

        int finalMin = min;
        int[] answer = Arrays.stream(arr).filter(el -> el != finalMin).toArray();

        return answer;
    }

    private int[] ReverseNum(long n) {
        List<String> forReverse = Arrays.asList(Long.toString(n).split(""));
        Collections.reverse(forReverse);
        return Arrays.stream(forReverse.toArray(Long.toString(n).split(""))).mapToInt(Integer::parseInt).toArray();
    }

    private String ChangeStrangeWord(String s) {
        String[] answer = s.split("");
        int cnt = 0;

        for (int i = 0; i < answer.length; i++) {
            cnt = answer[i].equals(" ") ? 0 : cnt + 1;
            answer[i] = cnt % 2 == 1 ? answer[i].toUpperCase() : answer[i].toLowerCase();
        }

        return String.join("", answer);
    }

    private boolean CheckPandY(String s) {
        s = s.toLowerCase();
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            char alph = s.charAt(i);
            if (alph == 'p') p++;
            else if (alph == 'y') y++;
        }

        return p == y ? true : false;
    }

    private int CheckDecimal(int n) {
        boolean ary[] = new boolean[n + 1];
        int answer = 0;
        Arrays.fill(ary, true);
        ary[0] = ary[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (ary[i]) {
                for (int j = i * i; j <= n; j += i) {
                    ary[j] = false;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (ary[i]) answer++;
        }
        return answer;
    }

    private String[] mySortRule(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        String[] answer = new String[strings.length];

        for (String word : strings) {
            list.add(word.charAt(n) + word);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    private String FindKim(String[] seoul) {
        List<String> names = new ArrayList<>(Arrays.asList(seoul));
        return "김서방은 " + names.indexOf("Kim") + "에 있다";
    }

    private String CaesarCode(String s, int n) {
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                char alph = s.charAt(i);
                int ascii = (int) alph + n;

                if (alph == Character.toLowerCase(alph) && ascii > (int) 'z') {
                    ascii = (ascii - (int) 'z' - 1) + (int) 'a';
                } else if (alph == Character.toUpperCase(alph) && ascii > (int) 'Z') {
                    ascii = (ascii - (int) 'Z' - 1) + (int) 'A';
                }
                answer.append(Character.toString((char) ascii));
            } else answer.append(" ");
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Pract pract = new Pract();

        // 콜라츠 추측
//        System.out.println(pract.CollatzSearch(6));
//        System.out.println(pract.CollatzSearch(16));
//        System.out.println(pract.CollatzSearch(626331));
//        System.out.println(pract.CollatzSearch(1));

        // 이상한 문자 만들기
//        System.out.println(pract.ChangeStrangeWord("try hello world").equals("TrY HeLlO WoRlD"));
//        System.out.println(pract.ChangeStrangeWord(" try hello world").equals(" TrY HeLlO WoRlD"));
//        System.out.println(pract.ChangeStrangeWord("try hello world ").equals("TrY HeLlO WoRlD "));
        // 소수찾기
//        System.out.println(pract.CheckDecimal(10));
//        System.out.println(pract.CheckDecimal(5));
        // 시저암호
        System.out.println(pract.CaesarCode("AB", 1));
        System.out.println(pract.CaesarCode("z", 1));
        System.out.println(pract.CaesarCode("a B z", 4));
    }
}
