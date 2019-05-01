package algorithms.backtracking;

public class KnightsTour {
    private int[] pathRow1 = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] pathCol1 = {1, 2, 2, 1, -1, -2, -2, -1};

    public boolean knightsTour(int[][] visited, int row, int col, int move) {
        if (move == 64) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(visited[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        } else {
            for (int i = 0; i < pathRow1.length; i++) {
                int rowNew = row + pathRow1[i];
                int colNew = col + pathCol1[i];
                if (ifValidMove(visited, rowNew, colNew)) {
                    move++;
                    visited[rowNew][colNew] = move;
                    if (knightsTour(visited, rowNew, colNew, move)) {
                        return true;
                    }
                    move--;
                    visited[rowNew][colNew] = 0;
                }
            }
        }

        return false;
    }

    private boolean ifValidMove(int[][] visited, int rowNew, int colNew) {
        if (rowNew >= 0 && rowNew < 8 && colNew >= 0 && colNew < 8 && visited[rowNew][colNew] == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] visited = new int[8][8];
        visited[0][0] = 1;
        KnightsTour app = new KnightsTour();
        app.knightsTour(visited, 0, 0, 1);
    }

}
