public class It_37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 如果當前格子是空的
                if (board[i][j] == '.') {
                    // 嘗試填入 1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // 填入數字

                            // 遞迴嘗試下一步
                            if (solve(board)) {
                                return true;
                            }

                            // 回溯，將格子重置為空
                            board[i][j] = '.';
                        }
                    }
                    return false; // 如果 1-9 都無法填入，返回 false
                }
            }
        }
        return true; // 如果所有格子都已填滿，返回 true
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // 檢查行、列和 3x3 子方格是否包含數字 c
        for (int i = 0; i < 9; i++) {
            // 檢查行
            if (board[row][i] == c) {
                return false;
            }
            // 檢查列
            if (board[i][col] == c) {
                return false;
            }
            // 檢查 3x3 子方格
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) {
                return false;
            }
        }
        return true;
    }
}