import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class It_30_SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int substringLength = wordLength * wordCount;

        // 預處理：計算 words 中每個單詞的頻率
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // 遍歷 s 的每個可能的起始點
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> windowFrequency = new HashMap<>();

            while (right + wordLength <= s.length()) {
                // 取出當前的單詞
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // 如果單詞在 words 中
                if (wordFrequency.containsKey(word)) {
                    windowFrequency.put(word, windowFrequency.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果某個單詞的頻率超過了 words 中的頻率，縮小視窗
                    while (windowFrequency.get(word) > wordFrequency.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowFrequency.put(leftWord, windowFrequency.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // 如果視窗中包含了所有單詞，記錄起始索引
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // 如果單詞不在 words 中，重置視窗
                    windowFrequency.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        It_30_SubstringwithConcatenationofAllWords solution = new It_30_SubstringwithConcatenationofAllWords();

        // 測試案例 1
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println("Input: s = \"" + s1 + "\", words = " + arrayToString(words1));
        System.out.println("Output: " + solution.findSubstring(s1, words1));

        // 測試案例 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println("Input: s = \"" + s2 + "\", words = " + arrayToString(words2));
        System.out.println("Output: " + solution.findSubstring(s2, words2));

        // 測試案例 3
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println("Input: s = \"" + s3 + "\", words = " + arrayToString(words3));
        System.out.println("Output: " + solution.findSubstring(s3, words3));
    }

    // 輔助方法：將字串陣列轉換為字串
    private static String arrayToString(String[] words) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < words.length; i++) {
            sb.append("\"").append(words[i]).append("\"");
            if (i < words.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}