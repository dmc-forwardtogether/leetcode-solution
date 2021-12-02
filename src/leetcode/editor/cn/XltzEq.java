package leetcode.editor.cn;

//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 
// 👍 2 👎 0

import leetcode.utils.ScannerUtils;

public class XltzEq{
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
        String s = ScannerUtils.scannerString("字符串:");
        System.out.println(solution.isPalindrome(s));
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a Ecar"));
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
