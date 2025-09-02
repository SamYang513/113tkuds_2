public class It_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 以第一個字串作為基準
        String prefix = strs[0];

        // 遍歷其餘字串
        for (int i = 1; i < strs.length; i++) {
            // 不斷縮短 prefix，直到找到公共前綴
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        It_14_LongestCommonPrefix solution = new It_14_LongestCommonPrefix();

        // 測試案例 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Input: " + String.join(", ", strs1));
        System.out.println("Output: " + solution.longestCommonPrefix(strs1)); // "fl"

        // 測試案例 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Input: " + String.join(", ", strs2));
        System.out.println("Output: " + solution.longestCommonPrefix(strs2)); // ""

        // 測試案例 3
        String[] strs3 = {"interspecies", "interstellar", "interstate"};
        System.out.println("Input: " + String.join(", ", strs3));
        System.out.println("Output: " + solution.longestCommonPrefix(strs3)); // "inters"
    }
}