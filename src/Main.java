import java.util.Scanner;
@SuppressWarnings("unused")
class Main {
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static int count = 0;
    static Scanner input = new Scanner(System.in);
    static boolean hasWon = false;
    static char Winner = ' ';
    static boolean empty;
    static String emptyPosition;
    static int emptyPositionNumber = 0;
    static int random;
    static int rowCountLook;
    static int columnCountLook;
    static int onediagonalCountLook;
    static int rowOpenr;
    static int rowOpenc;
    static int columnOpenc;
    static int columnOpenr;
    static int onediagonalOpenc;
    static int onediagonalOpenr;
    static int rowOpen = 0;
    static int columnOpen = 0;
    static int onediagonalOpen = 0;
    static int twodiagonalCountLook;
    static int twodiagonalOpenr;
    static int twodiagonalOpenc;
    static int twodiagonalOpen;
    static char piece;
    static char opponentPiece;
    static String name;
    static String bad;
    static boolean tie;
    static int fullrow;

    public static void drawBoard() {
        System.out.println("    1   2   3");
        System.out.println("  -------------");
        System.out.println("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("  -------------");
        System.out.println("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("  -------------");
        System.out.println("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("  -------------");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!\n");
        piece = introduction();
        opponentPiece = opponentPiece(piece);
        while (checkWinner(piece, opponentPiece).equals("none")) {
            int countone = count + 1;
            System.out.println("\nRound: " + countone);
            drawBoard();
            move(piece, opponentPiece);
            computerMove(opponentPiece, piece);
            count++;
        }

        drawBoard();

        switch (checkWinner(piece, opponentPiece)) {
            case "player" -> {
                System.out.println("What...\n");
                wait(500);
                System.out.println("That's IMPOSSIBLE\n");
                System.out.println("Congratulation " + name + "! Even though your weakness is " + bad + ", you somehow have done the unthinkable and beat the robot.\n+1000 Aura");
            }
            case "computer" -> {
                System.out.println("\n" + name + "..." + wait(500) + "\nDid you really think you had a chance?\n");
                System.out.println("It's okay, not all can beat the robot");
            }
            default -> System.out.println("Wow, you were able to tie with me.\n");
        }

    }

    public static void computerMove(char opponentPiece, char piece) {
        if (board[1][1] == ' ' && count == 0) {
            board[1][1] = opponentPiece;
            System.out.println("lil bro forgot to take the middle spot");
            return;
        }
        
        // look for open end spot and take it
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == opponentPiece) {
                    rowCountLook++;
                }
                else if (board[i][j] == ' ') {
                    rowOpenr = i;
                    rowOpenc = j;
                    rowOpen++;
                }

                if (board[j][i] == opponentPiece) {
                    columnCountLook++;
                }
                else if (board[j][i] == ' ') {
                    columnOpenr = j;
                    columnOpenc = i;
                    columnOpen++;
                }
                
                if (board[j][j] == opponentPiece) {
                    onediagonalCountLook++;
                }
                else if (board[j][j] == ' ') {
                    onediagonalOpenr = j;
                    onediagonalOpenc = j;
                    onediagonalOpen++;
            }
                if (board[j][2-j] == opponentPiece) {
                    twodiagonalCountLook++;
                }
                else if (board[j][2-j] == ' ') {
                    twodiagonalOpenr = j;
                    twodiagonalOpenc = 2-j;
                    twodiagonalOpen++;
            }
        
            }

            if (rowCountLook == 2 && rowOpen == 1) {
                board[rowOpenr][rowOpenc] = opponentPiece;
                return;
            }
            if (columnCountLook == 2 && columnOpen == 1) {
                board[columnOpenr][columnOpenc] = opponentPiece;
                return;
            }
            if (onediagonalCountLook == 2 && onediagonalOpen == 1) {
                board[onediagonalOpenr][onediagonalOpenc] = opponentPiece;
                return;
            }
            if (twodiagonalCountLook == 2 && twodiagonalOpen == 1) {
                board[twodiagonalOpenr][twodiagonalOpenc] = opponentPiece;
                return;
            }
            rowCountLook = 0;
            columnCountLook = 0;
            rowOpen = 0;
            columnOpen = 0;
            onediagonalCountLook = 0;
            onediagonalOpen = 0;
            twodiagonalCountLook = 0;
            twodiagonalOpen = 0;
        }

        // look for block if possible
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == piece) {
                    rowCountLook++;
                }
                else if (board[i][j] == ' ') {
                    rowOpenr = i;
                    rowOpenc = j;
                    rowOpen++;
                }

                if (board[j][i] == piece) {
                    columnCountLook++;
                }
                else if (board[j][i] == ' ') {
                    columnOpenr = j;
                    columnOpenc = i;
                    columnOpen++;
                }
                
                if (board[j][j] == piece) {
                    onediagonalCountLook++;
                }
                else if (board[j][j] == ' ') {
                    onediagonalOpenr = j;
                    onediagonalOpenc = j;
                    onediagonalOpen++;
            }
                if (board[j][2-j] == piece) {
                    twodiagonalCountLook++;
                }
                else if (board[j][2-j] == ' ') {
                    twodiagonalOpenr = j;
                    twodiagonalOpenc = 2-j;
                    twodiagonalOpen++;
            }
        
            }

            if (rowCountLook == 2 && rowOpen == 1) {
                board[rowOpenr][rowOpenc] = opponentPiece;
                return;
            }
            if (columnCountLook == 2 && columnOpen == 1) {
                board[columnOpenr][columnOpenc] = opponentPiece;
                return;
            }
            if (onediagonalCountLook == 2 && onediagonalOpen == 1) {
                board[onediagonalOpenr][onediagonalOpenc] = opponentPiece;
                return;
            }
            if (twodiagonalCountLook == 2 && twodiagonalOpen == 1) {
                board[twodiagonalOpenr][twodiagonalOpenc] = opponentPiece;
                return;
            }
            rowCountLook = 0;
            columnCountLook = 0;
            rowOpen = 0;
            columnOpen = 0;
            onediagonalCountLook = 0;
            onediagonalOpen = 0;
            twodiagonalCountLook = 0;
            twodiagonalOpen = 0;
        }
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestColumn = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {

                    // Pretend computer chooses this position
                    board[i][j] = opponentPiece;

                    // See how good this move would be
                    int score = minimax(piece, opponentPiece, false);

                    // Undo pretend move
                    board[i][j] = ' ';

                    // Remember the best move
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestColumn = j;
                    }
                }
            }
        }

        if (bestRow != -1) {
        board[bestRow][bestColumn] = opponentPiece;
        }
    }

    public static int minimax(char playerPiece, char computerPiece, boolean computerTurn) {

        if (didWin(computerPiece)) {
            return 10;
        }

        if (didWin(playerPiece)) {
            return -10;
        }

        if (boardFull()) {
            return 0;
        }

        if (computerTurn) {

            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board[i][j] == ' ') {

                        board[i][j] = computerPiece;

                        int score =
                            minimax(playerPiece, computerPiece, false);

                            board[i][j] = ' ';

                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }

            return bestScore;
        }

        else {

            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board[i][j] == ' ') {

                        board[i][j] = playerPiece;

                        int score =
                            minimax(playerPiece, computerPiece, true);

                            board[i][j] = ' ';

                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }

            return bestScore;
        }
    }

    public static String checkWinner(char piece, char opponentPiece) {
        for (int i = 0; i < 3; i++) {
            if (!hasWon && board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                hasWon = true;
                Winner = board[i][0];
            }
            else if (!hasWon && board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                hasWon = true;
                Winner = board[0][i];                
            }
            else if (!hasWon && board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                hasWon = true;
                Winner = board[0][0];                   
            }
            else if (!hasWon && board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                hasWon = true;
                Winner = board[0][2];                   
            }
        }
        if (Winner == piece) {
            return "player";
        }
        else if (Winner == opponentPiece) {
            return "computer";
        }
        else if (boardFull()) {
            return "tie";
        }
        else {
            return "none";
        }
    }

    public static char opponentPiece(char piece) {
        if (piece == 'X') {
            return 'O';
        }
        else {
            return 'X';
        }        
    }

    public static boolean didWin(char piece) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == piece &&
                board[i][1] == piece &&
                board[i][2] == piece) {

                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == piece &&
                board[1][i] == piece &&
                board[2][i] == piece) {

                return true;
            }
        }

        // Diagonal
        if (board[0][0] == piece &&
            board[1][1] == piece &&
            board[2][2] == piece) {

            return true;
        }

        // Other diagonal
        if (board[0][2] == piece &&
            board[1][1] == piece &&
            board[2][0] == piece) {

            return true;
        }

        return false;
    }

    public static boolean boardFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void move(char piece, char opponentPiece) {
        System.out.println("Your turn!\n\nSelect a row:\n");
        int row = input.nextInt() - 1;

        System.out.println("Select a column:\n");
        int column = input.nextInt() - 1;
        if (board[row][column] == piece) {
            System.out.println("Silly you! You already chose this spot\n");
            wait(500);
            System.out.println("Hmmm\n\nLet me think\n");
            System.out.println("Should I let you pick again since you made a mistake?\n");
            wait(1000);
            if (randomValue(1) == 1) {
                System.out.println("Fine you can pick again\n");
                move(piece, opponentPiece);
            }
            else {
                System.out.println(name + " did you actually think I was a nice robot? " + "Nah no way, lil bro thought I would actually let him pick again lmao.\n");
            }
        }
        else if (board[row][column] == opponentPiece) {
            System.out.println("I already took this spot lil bro");
            move(piece, opponentPiece);
        }
        else {
            board[row][column] = piece;
        }
    }
    
    public static int randomValue(int cap) {
        return (int) (Math.random() * cap);
    }

    public static String wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return " ";
    }
    public static char introduction() {
        System.out.println("What is your name?\n");
        name = input.nextLine();
        System.out.println("\nHello " + name + "! What is your greatest weakness if you don't mind me asking of course :)\n");
        bad = input.nextLine();
        System.out.println("\nActivating lock in mode" + wait(500) + "\n" + "\nHmm, Let me think if I want you to pick your own piece.\n");
        wait(1000);
        if (randomValue(1) == 1) {
            if (randomValue(1) == 1) {
                piece = 'X';
            }
            else {
                piece = 'O';
            }
            System.out.println("Nah\n\n" + wait(2000) + "You will be " + piece + "\n\n");

        }
        else {
            System.out.println("Fine, I'm feeling generous today.\n\n" + "What do you want to be O or X?\n");
            piece = input.next().charAt(0);
            if (piece != 'O' && piece != 'o' && piece != 'X' && piece != 'x') {
                System.out.println("\nCan lil bro even read? I said to pick 'O' or 'X'\n\n" + "Hurry up before I change my mind\n");
                piece = input.next().charAt(0);
                if (piece != 'O' && piece != 'o' && piece != 'X' && piece != 'x') {
                    if (randomValue(1) == 1) {
                        piece = 'X';
                    }
                    else {
                        piece = 'O';
                    }
                    System.out.println("Ok, I'm choosing for you now" + wait(2000) + "\n" + "You will be " + piece + "\n\n");                    
                }
            }
        }
        System.out.println("\nOkay...\n");
        wait(1000);
        System.out.println("Calculating your moves ahead of time\n");

        System.out.println("I have all the information I need...\n\nLet's" + wait(500) + "do this.");
        return (piece);
    }
}