import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
    
    static class Bomb {
        int row;
        int col;

        Bomb(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private static int[][] findMines(List<Bomb> bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        
        for (Bomb bomb : bombs) {
            int bomb_row = bomb.row;
            int bomb_col = bomb.col;
            
            field[bomb_row][bomb_col] = -1;
            
            int row_begin = bomb_row - 1;
            int row_end = bomb_row + 2;
            int col_begin = bomb_col - 1;
            int col_end = bomb_col + 2;
             
            for (int i = row_begin; i < row_end; ++i) {
                for (int j = col_begin; j < col_end; j++) {
                    if (0 <= i && i <= numRows && 0 <= j && j <= numCols && field[i][j] != -1) {
                        field[i][j]++;
                    }
                }            
            }
        }
        
        return field;        
    }
    
    public static void main(String[] args) {
        List<Bomb> bombs = new ArrayList<>();
        bombs.add(new Bomb(0, 0));
        bombs.add(new Bomb(1, 2));
        
        int[][] field = findMines(bombs, 3, 4);
        
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }
    
}
