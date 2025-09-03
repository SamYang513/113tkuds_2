
public class It_06_ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // 使用 StringBuilder 儲存每一行的字符
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // 遍歷字串，將字符放入對應的行
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // 如果到達第一行或最後一行，改變方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // 根據方向移動到下一行
            currentRow += goingDown ? 1 : -1;
        }

        // 合併所有行的字符
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        It_06_ZigzagConversion solution = new It_06_ZigzagConversion();

        // 測試案例 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Input: " + s1 + ", numRows = " + numRows1);
        System.out.println("Output: " + solution.convert(s1, numRows1)); // "PAHNAPLSIIGYIR"

        // 測試案例 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Input: " + s2 + ", numRows = " + numRows2);
        System.out.println("Output: " + solution.convert(s2, numRows2)); // "PINALSIGYAHRPI"

        // 測試案例 3
        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Input: " + s3 + ", numRows = " + numRows3);
        System.out.println("Output: " + solution.convert(s3, numRows3)); // "A"
    }
}