public class It_28_FindtheIndexoftheFirstOccurrenceinaString {
    public int strStr(String haystack, String needle) {
        // 如果 needle 是空字串，返回 0（根據題目要求）
        if (needle.isEmpty()) {
            return 0;
        }

        // 使用內建的 indexOf 方法
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        It_28_FindtheIndexoftheFirstOccurrenceinaString solution = new It_28_FindtheIndexoftheFirstOccurrenceinaString();

        // 測試案例 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Input: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\"");
        System.out.println("Output: " + solution.strStr(haystack1, needle1));

        // 測試案例 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Input: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\"");
        System.out.println("Output: " + solution.strStr(haystack2, needle2));
    }
}
