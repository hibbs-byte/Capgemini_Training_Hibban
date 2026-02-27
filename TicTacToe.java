import java.util.*;

public class TicTacToe {
    static char[][] board = new char[3][3];

    public static boolean check(char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ch && board[i][1] == ch && board[i][2] == ch) return true;
            if (board[0][i] == ch && board[1][i] == ch && board[2][i] == ch) return true;
        }
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) return true;
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]=sc.next().charAt(0);

        if(check('X')) System.out.println("X Wins");
        else if(check('O')) System.out.println("O Wins");
        else System.out.println("Draw");
    }
}
