//Milind Pathiyal

////SOLVES ALL 92 SOLUTIONS TO 8 QUEENS RECURSIVELY
public class Queen 
{
    //Pre:METHOD MUST EXIST
    //Post:NONE
    public static void main(String[] args)
    {
        arrangeQueens();
    }
    
    //Pre:NONE
    //Post:PRINTS CHESS BOARD
    public static void printChessBoard(char[][] board) 
    {
        // 8x8 board
        int n = board.length;
        System.out.println("------------------------------");
        for (int i = 0; i < n; i++) 
        {
            System.out.print("|");
            for (int j = 0; j < n; j++) 
            {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
    //Pre:VARIABLES MUST EXIST
    //Post:UPDATES ROW AND COL AND DIAGONALS
    public static void updateChessBoard(int row, int col, boolean[][] logicalBoard) 
    {
        int n = logicalBoard.length;
        // default setting for row
        for (int j = 0; j < n; j++) 
        {
            logicalBoard[row][j] = false;
        }
        // default setting for col
        for (int j = 0; j < n; j++) 
        {
            logicalBoard[j][col] = false;
        }
        // default setting for diagonals coming from 4 angles
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) 
        {
            logicalBoard[r][c] = false;
            r--;c--;
        }
        r = row;
        c = col;
        while (r < 8 && c < 8) 
        {
            logicalBoard[r][c] = false;
            r++;c++;
        }
        r = row;
        c = col;
        while (r < 8 && c >= 0)
        {
            logicalBoard[r][c] = false;
            r++;c--;
        }
        r = row;
        c = col;
        while (r >= 0 && c < 8) 
        {
            logicalBoard[r][c] = false;
            r--;c++;
        }
        
    }
    //Pre:VARIABLES MUST EXIST
    //Post:CREATES A COPY OF THE CHAR TABLE
    public static char[][] copyArray(char[][] original) 
    {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) 
        {
            copy[i] = original[i].clone();//Copies the objects
        }
        return copy;
    }
    //Pre:VARIABLES MUST EXIST
    //Post:CREATES A COPY OF THE BOOLEAN TABLE
    public static boolean[][] copyArray(boolean[][] original) 
    {
        boolean[][] copy = new boolean[original.length][];
        for (int i = 0; i < original.length; i++)
        {
            copy[i] = original[i].clone();//Copies the object
        }
        return copy;
    }
    //Pre:VARIABLES AND METHODS MUST EXIST
    //Post:PLACE QUEENS IN CHESS BOARD
    public static void arrangeQueens(char[][] board, boolean[][] logicalBoard, int rowNumber) 
    {
        if (rowNumber == 8) 
        {
            printChessBoard(board);
            return;
        }
        //Places Queen into rowNumber and column
        int n = board.length;
        for (int column = 0; column < n; column++) 
        {
            if (logicalBoard[rowNumber][column]) 
            {
                char[][] newBoard = copyArray(board);
                boolean[][] newLogicalBoard = copyArray(logicalBoard);
                newBoard[rowNumber][column] = 'Q';
                newLogicalBoard[rowNumber][column] = false;
                updateChessBoard(rowNumber, column, newLogicalBoard);
                arrangeQueens(newBoard, newLogicalBoard, rowNumber + 1);
            } 
        }
    }
    //Pre:VARIABLES AND METHODS MUST EXIST
    //Post:PLACE QUEENS IN CHESS BOARD
    public static void arrangeQueens() 
    {
        int N = 8;
        char[][] board = new char[8][8];
        boolean[][] logicalBoard = new boolean[8][8];
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                board[i][j] = ' ';
                logicalBoard[i][j] = true;
            }
        }
        arrangeQueens(board, logicalBoard, 0);
    }
}
/*
 * ------------------------------
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | |Q| | | | |
------------------------------
ETC. Prints all solutions...
 */