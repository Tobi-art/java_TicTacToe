import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class TTT {
    public static void main(String[] args) {

        char[][] Board = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
        Set<Integer> userPositions = new HashSet<Integer>();
        Set<Integer> pcPositions = new HashSet<Integer>();
        String result;

        while (true) {
            printBoard(Board);
            System.out.print("１〜９の数字で、空いているポジションをお選び下さい。 ");
            Scanner sc = new Scanner(System.in);
            int userPos = sc.nextInt();
            while (userPositions.contains(userPos) || pcPositions.contains(userPos)) {
                System.out.println("このポジションは空いていません。他のお選び下さい。 ");
                userPos = sc.nextInt();
            }
            userPositions.add(userPos);
            updateBoard(Board, userPos, "user");
            result = checkWinner(userPositions, pcPositions);
            if (result != "") {
                printBoard(Board);
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int pcPos = rand.nextInt(9) + 1;
            while (pcPositions.contains(pcPos) || userPositions.contains(pcPos)) {
                pcPos = rand.nextInt(9) + 1;
            }
            pcPositions.add(pcPos);
            updateBoard(Board, pcPos, "pc");
            result = checkWinner(userPositions, pcPositions);
            if (result != "") {
                printBoard(Board);
                System.out.println(result);
                break;
            }

        }
    }

    public static void printBoard(char[][] Board) {
        for (char[] l : Board) {
            System.out.println(l);
        }
    }

    public static void updateBoard(char[][] Board, int position, String player) {
        char symbol = ' ';
        if (player.equals("user")) {
            symbol = 'X';
        } else if (player.equals("pc")) {
            symbol = 'O';
        }

        switch (position) {
        case 1:
            Board[0][0] = symbol;
            break;
        case 2:
            Board[0][2] = symbol;
            break;
        case 3:
            Board[0][4] = symbol;
            break;
        case 4:
            Board[2][0] = symbol;
            break;
        case 5:
            Board[2][2] = symbol;
            break;
        case 6:
            Board[2][4] = symbol;
            break;
        case 7:
            Board[4][0] = symbol;
            break;
        case 8:
            Board[4][2] = symbol;
            break;
        case 9:
            Board[4][4] = symbol;
            break;
        default:
            break;
        }

    }

    public static String checkWinner(Set<Integer> userPositions, Set<Integer> pcPositions) {
        Set<Integer> playedPositions = new HashSet<Integer>();
        playedPositions.addAll(userPositions);
        playedPositions.addAll(pcPositions);

        List<Integer> tRow = Arrays.asList(1, 2, 3);
        List<Integer> mRow = Arrays.asList(4, 5, 6);
        List<Integer> bRow = Arrays.asList(7, 8, 9);
        List<Integer> lCol = Arrays.asList(1, 4, 7);
        List<Integer> mCol = Arrays.asList(2, 5, 8);
        List<Integer> rCol = Arrays.asList(3, 6, 9);
        List<Integer> tDia = Arrays.asList(1, 5, 9);
        List<Integer> bDia = Arrays.asList(7, 5, 3);
        List<Integer> boardPositions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<List> winner = new ArrayList<List>();
        winner.add(tRow);
        winner.add(mRow);
        winner.add(bRow);
        winner.add(lCol);
        winner.add(mCol);
        winner.add(rCol);
        winner.add(tDia);
        winner.add(bDia);

        String a = "";

        for (List l : winner) {
            if (userPositions.containsAll(l)) {
                a = "おめでとうございます。あなたの勝ちです。";
            } else if (pcPositions.containsAll(l)) {
                a = "PCが勝ちました。再度試して下さい。";
            } else if (playedPositions.containsAll(boardPositions)) {
                a = "引分けです。再度試して下さい。";
            }
        }
        return a;
    }
}
