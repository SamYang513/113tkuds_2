public class It_36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 使用三個集合陣列來檢查行、列和 3x3 子方格
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // 初始化集合
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // 遍歷整個數獨棋盤
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // 如果當前格子是空的，跳過
                if (num == '.') {
                    continue;
                }

                // 計算當前數字屬於哪個 3x3 子方格
                int boxIndex = (i / 3) * 3 + (j / 3);

                // 檢查行、列和子方格是否已經包含該數字
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }

                // 將數字加入對應的集合
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }

        // 如果所有檢查都通過，返回 true
        return true;
    }
}