package Labpract;

import java.util.Scanner;

public class TicTaeToeArray {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String[][] gameboard = new String[3][3];

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                gameboard[i][j] = " ";
            }
        }

        for (int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print("  "+gameboard[i][j]);
                if(j!=2) System.out.print("|");
                else System.out.print("\n");
            }
            if (i!=2) System.out.println("---|---|---");
        }
    }
}
