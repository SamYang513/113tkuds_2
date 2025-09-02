public class It_12_IntegertoRoman {
    public String intToRoman(int num) {
        // 定義羅馬數字的值與符號
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // 遍歷所有羅馬數字符號
        for (int i = 0; i < values.length; i++) {
            // 將當前符號重複添加到結果中，直到 num 小於當前值
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        It_12_IntegertoRoman solution = new It_12_IntegertoRoman();

        // 測試案例 1
        int num1 = 3749;
        System.out.println("Input: " + num1 + " -> Output: " + solution.intToRoman(num1)); // MMMDCCXLIX

        // 測試案例 2
        int num2 = 58;
        System.out.println("Input: " + num2 + " -> Output: " + solution.intToRoman(num2)); // LVIII

        // 測試案例 3
        int num3 = 1994;
        System.out.println("Input: " + num3 + " -> Output: " + solution.intToRoman(num3)); // MCMXCIV
    }
}