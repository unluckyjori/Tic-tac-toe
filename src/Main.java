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

    public static boolean checkForEnemyPiece(boolean empty, String emptyPosition, int emptyPositionNumber, char piece) {
        for (int i = 0; i < 3; i++) {
            if (emptyPosition.equals("row")) {
                if (board[i][emptyPositionNumber] == piece) {
                    return true;
                }
            }
            else if (emptyPosition.equals("column")) {
                if (board[emptyPositionNumber][i] == piece) {
                    return true;
                }
            }
            else if (emptyPosition.equals("diagonal") && emptyPositionNumber == 1) {
                if (board[i][i] == piece) {
                    return true;
                }
            }
            else {
                if (board[0+i][2-i] == piece) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void computerMove(char opponentPiece, char piece) {
        // Find a fully empty row
        if (count > 0 && (checkForEnemyPiece(empty, emptyPosition, emptyPositionNumber, piece))) {
            empty = false;
        }
        for (int i = 0; i < 3; i++) {
            if (!empty && board[i][0] == ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                empty = true;
                emptyPosition = "row";
                emptyPositionNumber = i;
                
            }
            else if (!empty && board[0][i] == ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                empty = true;
                emptyPosition = "column";
                emptyPositionNumber = i;
                              
            }
            else if (!empty && board[0][0] == ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                empty = true;
                emptyPosition = "diagonal";
                emptyPositionNumber = 1;
                                   
            }
            else if (!empty && board[0][2] == ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                empty = true;
                emptyPosition = "diagonal";
                emptyPositionNumber = 2;
            }
            else {
                checkWinner();
                break;
            }
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