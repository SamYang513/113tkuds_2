public class It_13_RomantoInteger {
    public int romanToInt(String s) {
        // 定義羅馬數字對應的整數值
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // 從右到左遍歷字串
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // 如果當前值小於之前的值，則減去當前值；否則加上當前值
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            // 更新前一個值
            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        It_13_RomantoInteger solution = new It_13_RomantoInteger();

        // 測試案例 1
        String s1 = "III";
        System.out.println("Input: " + s1 + " -> Output: " + solution.romanToInt(s1)); // 3

        // 測試案例 2
        String s2 = "LVIII";
        System.out.println("Input: " + s2 + " -> Output: " + solution.romanToInt(s2)); // 58

        // 測試案例 3
        String s3 = "MCMXCIV";
        System.out.println("Input: " + s3 + " -> Output: " + solution.romanToInt(s3)); // 1994
    }
}