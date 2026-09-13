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

    public static void drawBoard() {
        System.out.println("-------------");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("-------------");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!\n");
        char piece = introduction();
        char opponentPiece = opponentPiece(piece);
        while (!hasWon) {
            drawBoard();
            move(piece, opponentPiece);
            computerMove(opponentPiece, piece);
            if (!(count < 3)) {
                checkWinner();
            }
            count++;
        }

    }

    public static void computerMove(char opponentPiece, char piece) {
        if (board[1][1] == ' ' && count == 0) {
            board[1][1] = opponentPiece;
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
        random = (int) (Math.random() * 3);

        if (emptyPosition.equals("row")) {
            board[emptyPositionNumber][random] = opponentPiece;
        }
        else if (emptyPosition.equals("column")) {
            board[random][emptyPositionNumber] = opponentPiece;
        }
        else {
            if (emptyPositionNumber == 1) {
                board[random][random] = opponentPiece;
            }
            else {
                switch (random) {
                    case 0:
                        board[0][2] = opponentPiece;
                        break;
                    case 1:
                        board[1][1] = opponentPiece;
                        break;
                    default:
                        board[2][0] = opponentPiece;
                        break;
                }
            }
        }
        
    }

    public static int checkWinner() {
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
            else if (!hasWon && board[2][2] != ' ' && board[0][2] == board[1][1] && board[0][0] == board[2][0]) {
                hasWon = true;
                Winner = board[0][0];                   
            }
        }
        return switch (Winner) {
            case 'X' -> 1;
            case 'O' -> 2;
            default -> 0;
        };
    }

    public static char opponentPiece(char piece) {
        if (piece == 'X') {
            return 'O';
        }
        else {
            return 'X';
        }        
    }

    public static void move(char piece, char opponentPiece) {
        System.out.println("Your turn!\n\n Select a row:\n");
        int row = input.nextInt();

        System.out.println("Select a column:\n");
        int column = input.nextInt();
        if (board[row][column] == piece) {
            System.out.println("Silly you! You already chose this spot");
        }
        else if (board[row][column] == opponentPiece) {
            System.out.println("I already took this spot lil bro");
        }
        else {
            board[row][column] = piece;
        }


    }
    
    public static char introduction() {
        System.out.println("Hello! Welcome to my tic tac toe game!\n\n What is your name?");
        String name = input.nextLine();
        System.out.println("What is something that you are bad at?");
        String bad = input.nextLine();
        System.out.println("What do you want to be O or X?");
        char piece = input.next().charAt(0);
        System.out.println("Okay...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("I have all the information I need...\n\nLet's do this.");
        return (piece);
    }
}