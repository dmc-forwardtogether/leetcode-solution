package leetcode.editor.cn;

//为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。 
//
// 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符
//构成。 
//
// 如果可以构成，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 236 👎 0

import leetcode.utils.ScannerUtils;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        String ransomNote = ScannerUtils.scannerString("ransomNote = ");
        String magazine = ScannerUtils.scannerString("magazine = ");
        System.out.println(solution.canConstruct(ransomNote, magazine));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> character = new HashMap<>(26);
            char[] magazineChars = magazine.toCharArray();
            char[] ransomNoteChars = ransomNote.toCharArray();
            for (char c : magazineChars) {
                int i = character.getOrDefault(c, 0);
                i++;
                character.put(c, i);
            }
            for (char ransomNoteChar : ransomNoteChars) {
                if (!character.containsKey(ransomNoteChar)) {
                    return false;
                }
                int i = character.get(ransomNoteChar);
                i--;
                if (i < 0) {
                    return false;
                }
                character.put(ransomNoteChar, i);
            }
            return true;
        }
        
        public boolean betterSolution(String a, String b){
            int[] cnt = new int[26];
            for (char c : b.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (char c : a.toCharArray()) {
                if (--cnt[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
