package leetcode.editor.cn;

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 197 👎 0

import leetcode.utils.ScannerUtils;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        String s = ScannerUtils.scannerString("请输入待反转的字符串:");
        System.out.println(solution.reverseVowels(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
        Set<Character> set = new HashSet<>();

        {
            for (char c : vowel) {
                set.add(c);
                set.add(Character.toUpperCase(c));
            }
        }

        public String reverseVowels(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            for (int i = 0, j = n - 1; i <= j; ) {
                if (cs[i] == cs[j]) {
                    i++;
                    j--;
                } else if (set.contains(cs[i]) && set.contains(cs[j])) {
                    swap(cs, i++, j--);
                } else {
                    if (!set.contains(cs[i])) {
                        i++;
                    }
                    if (!set.contains(cs[j])) {
                        j--;
                    }
                }
            }
            return String.valueOf(cs);
        }

        void swap(char[] cs, int l, int r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
