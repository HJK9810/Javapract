package programmers.kakao;

public class Blind21 {
    private String NewID(String new_id) {
        String answer = new_id.toLowerCase().replaceAll("[^-_.a-z0-9]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (answer.length() == 0) answer = "a";
        if (answer.length() > 15) answer = answer.substring(0, 15).replaceAll("^[.]|[.]$", "");

        return answer.length() > 2 ? answer : (answer + answer.substring(answer.length() - 1).repeat(2)).substring(0, 3);
    }

    public static void main(String[] args) {
        Blind21 blind21 = new Blind21();

        System.out.println(blind21.NewID("...!@BaT#*..y.abcdefghijklm").equals("bat.y.abcdefghi"));
        System.out.println(blind21.NewID("z-+.^.").equals("z--"));
        System.out.println(blind21.NewID("=.=").equals("aaa"));
        System.out.println(blind21.NewID("123_.def").equals("123_.def"));
        System.out.println(blind21.NewID("abcdefghijklmn.p").equals("abcdefghijklmn"));
    }
}
