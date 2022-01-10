package Labpract;

import java.util.Objects;
import java.util.Scanner;

public class TicTaeToeArray {
//    빙고판별
    public static boolean CheckWinner(String[][] ary) {
        boolean check = false;

        for (int i = 0; i < 3; i++) {
            if (ary[i][0].equals(ary[i][1])) {
                if (ary[i][1].equals(ary[i][2])) {
                    check = true;
                    break;
                }
            } else if (ary[0][i].equals(ary[1][i])) {
                if (ary[1][i].equals(ary[2][i])) {
                    check = true;
                    break;
                }
            }
        }

        return check;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] gameboard = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameboard[i][j] = " ";
            }
        }

        while (true) {
//            게임판 그리기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("  " + gameboard[i][j]);
                    if (j != 2) System.out.print("|");
                    else System.out.print("\n");
                }
                if (i != 2) System.out.println("---|---|---");
            }

//            사용자의 턴
            System.out.print("다음 수의 좌표를 입력하시오: ");
            int x = input.nextInt();
            int y = input.nextInt();
            gameboard[x][y] = "X";
//            컴퓨터의 턴
            for (int i = 0; i < 3; i++) {
                boolean check = false;
                for (int j = 0; j < 3; j++) {
                    if (!gameboard[i][j].equals(" ")) continue;
                    else {
                        gameboard[i][j] = "O";
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }
        }
    }
}
