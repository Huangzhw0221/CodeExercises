package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/8/11 20:23
 */
public class Test {

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'a', 'b'},
                {'a', 'b', 'b'},
                {'a','b','b'},
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int weight = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    dfs(matrix, visited, i, j);
                    weight++;
                }
            }
        }

        System.out.println("权值为：" + weight);
    }

    private static void dfs(char[][] matrix, boolean[][] visited, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        char currentChar = matrix[row][col];

        // 上、下、左、右四个方向进行DFS
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && !visited[newRow][newCol] && matrix[newRow][newCol] == currentChar) {
                dfs(matrix, visited, newRow, newCol);
            }
        }
    }

}
