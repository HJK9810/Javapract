package Labpract;

import java.util.Objects;
import java.util.Scanner;

public class TicTaeToeArray {
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
                    if (!Objects.equals(gameboard[i][j], " ")) continue;
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
