package csv;

import java.util.Scanner;

public class PrintUI {
    Scanner input = new Scanner(System.in);

    public void printcheck() {
        PrintUI pui = new PrintUI();
        System.out.println("어떠한 분류를 선택하시겠습니까?");
        System.out.println("1. 분기별\n2. 누적");
        int num = input.nextInt();

        while (true) {
            if (num == 1) {
                pui.printquter();
                break;
            } else if (num == 2) {
                pui.printcheck();
                break;
            } else System.out.println("다시 입력해주세요.");
        }
    }

    public void printquter() { // 분기별
        System.out.println("보고자하는 분기를를 선택해주세요");
        System.out.println("1. 지정일 단위\n2. 지정달\n");
        int num = input.nextInt();

        while(true) {
            if(num==1) {
                System.out.println("지정일 단위입니다.");
                break;
            } else if(num==2) {
                System.out.println("지정 달 입니다.");
                break;
            } else System.out.println("잘못누르셨습니다. 다시 입력해주세요.");
        }
    }

    public void printculm() { // 누적별
        System.out.println("누적되고자 하는 종류를 선택해주세요");
        System.out.println("1. 년도별\n2. 월별\n3. 정류장별");
        int num = input.nextInt();

        while(true) {
            if(num==1) {
                System.out.println("년도별입니다.");
                break;
            } else if(num==2) {
                System.out.println("월별입니다.");
                break;
            } else if(num==3) {
                System.out.println("정류장별입니다.");
                break;
            } else System.out.println("잘못누르셨습니다. 다시 입력해주세요.");
        }
    }
}
