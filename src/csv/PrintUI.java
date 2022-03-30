package csv;

import java.util.Scanner;

public class PrintUI {
    Scanner input = new Scanner(System.in);

    public String printcheck() {
        System.out.println("어떠한 분류를 선택하시겠습니까?");
        System.out.println("1. 분기별\n2. 누적");
        int num = input.nextInt();

        while (true) {
            if (num == 1) {
                System.out.print("분기별입니다.");
                break;
            } else if (num == 2) {
                System.out.print("누적별입니다.");
                break;
            } else System.out.println("다시 입력해주세요.");
        }
    }
}
