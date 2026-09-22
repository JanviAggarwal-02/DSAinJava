import java.util.*;

class Main {

    static int n;

    static boolean solveMaze(int[][] maze, int[][] solution,
                             int row, int col) {

  
        if (row == n - 1 && col == n - 1) {

            if (maze[row][col] == 1) {
                solution[row][col] = 1;
                return true;
            }

            return false;
        }

        if (row >= 0 && row < n &&
            col >= 0 && col < n &&
            maze[row][col] == 1) {

            solution[row][col] = 1;

            if (solveMaze(maze, solution, row + 1, col)) {
                return true;
            }

            if (solveMaze(maze, solution, row, col + 1)) {
                return true;
            }
            if (solveMaze(maze, solution, row - 1, col)) {
                return true;
            }

            if (solveMaze(maze, solution, row, col - 1)) {
                return true;
            }
            solution[row][col] = 0;
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {0, 1, 1, 1}
        };

        n = maze.length;

        int[][] solution = new int[n][n];

        if (solveMaze(maze, solution, 0, 0)) {

            System.out.println("Path exists:");

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    System.out.print(solution[i][j] + " ");
                }

                System.out.println();
            }

        } else {

            System.out.println("No path exists");
        }
    }
}