package recursionAssignment;



public class Queens
{
 
    /**
     * Prints an array that shows the solution where queens can be placed represented as 1
     * @param an array board, which is initialized as 0
     * @param size of the array board.
     */
    void printSolution(int[][] board, int size)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
 

    /**
     * Checks whether placing a queen at position(row,col) will prevent it from getting attacked
     * @param an array which contains queens placed
     * @param row as x coordinate
     * @param col as y coordinate
     * @param size of the array board
     * @return true if queen can be placed else false
     */
    boolean isSafeToPlace(int board[][], int row, int col, int size)
    {
        int i, j;
 
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<size; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
    }
 
    /**
     * A recursive utility function to solve N
       Queen problem
     * @param an array board, which contains queens placed
     * @param columns in which queens are already placed
     * @param size of array board
     * @return true if solution exists else false
     */
    boolean solveNQfunc(int board[][], int col, int size)
    {
        /* base case: If all queens are placed
           then return true */
        if (col >= size)
            return true;
 
        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < size; i++)
        {
            /* Check if the queen can be placed on
               board[i][col] */
            if (isSafeToPlace(board, i, col, size))
            {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
 
                /* recur to place rest of the queens */
                if (solveNQfunc(board, col + 1,size) == true)
                    return true;
 
                
                board[i][col] = 0; // BACKTRACK
            }
        }
 
        return false;
    }
 
    
    /**
     * prints solution if there is a solution else print that it does not exist
     * @param size of an array board.
     * @return true if solution exists 
     */
    int[][] solveNQ(int size)
    {
        int[][] board = new int[size][size];
 
        if (!solveNQfunc(board, 0, size))
        {
            throw new AssertionError("Solution does not exist");
        }
 
        //printSolution(board, size);
        return board;
    }
 
}
