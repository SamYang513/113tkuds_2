public class It_38_CountandSay {
    public String countAndSay(int n) {
        // 基本情況
        if (n == 1) {
            return "1";
        }

        // 獲取前一個數列
        String previous = countAndSay(n - 1);

        // 構造當前數列
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < previous.length(); i++) {
            // 如果當前字符與前一個字符相同，增加計數
            if (previous.charAt(i) == previous.charAt(i - 1)) {
                count++;
            } else {
                // 否則，將計數和字符加入結果
                result.append(count).append(previous.charAt(i - 1));
                count = 1; // 重置計數
            }
        }

        // 處理最後一組字符
        result.append(count).append(previous.charAt(previous.length() - 1));

        return result.toString();
    }
}