package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You have n tiles, where each tile has one letter tiles[i] printed on it.
 * <p>
 * Return the number of possible non-empty sequences of letters you can make
 * using the letters printed on those tiles.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
 * "ABA", "BAA".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: tiles = "AAABBC"
 * Output: 188
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: tiles = "V"
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 * <p>
 * <p>
 * 👍 221 👎 0
 */

public class LetterTilePossibilities {
    public static void main(String[] args) {
        Solution solution = new LetterTilePossibilities().new Solution();
        String tiles1 = "AAB";
        String tiles2 = "AAABBC";
        String tiles3 = "V";
        System.out.println(solution.numTilePossibilities(tiles1));
        System.out.println(solution.numTilePossibilities(tiles2));
        System.out.println(solution.numTilePossibilities(tiles3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* public int numTilePossibilities(String tiles) {
            Map<Character, Integer> count = new HashMap<>();
            for (char t : tiles.toCharArray()) {
                count.put(t, count.getOrDefault(t, 0) + 1);
            }
            Set<Character> tile = new HashSet<>(count.keySet());
            return dfs(tiles.length(), count, tile) - 1;
        }

        private int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
            if (i == 0) {
                return 1;
            }
            int res = 1;
            for (char t : tile) {
                if (count.get(t) > 0) {
                    count.put(t, count.get(t) - 1);
                    res += dfs(i - 1, count, tile);
                    count.put(t, count.get(t) + 1);
                }
            }
            return res;
        }
        */
        private static final int MX = 8;
        private static final int[][] c = new int[MX][MX];

        static {
            for (int i = 0; i < MX; i++) {
                c[i][0] = c[i][i] = 1;
                for (int j = 1; j < i; j++)
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j]; // 预处理组合数
            }
        }

        public int numTilePossibilities(String tiles) {
            // 注：改成 int[26] 统计可能会快一点点，感兴趣可以试试（下面 DP 跳过 cnt=0 的情况）
            var counts = new HashMap<Character, Integer>(); // 统计每个字母的出现次数
            for (var c : tiles.toCharArray())
                counts.merge(c, 1, Integer::sum); // counts[c]++
            var f = new int[tiles.length() + 1];
            f[0] = 1; // 构造空序列的方案数
            int n = 0;
            for (var cnt : counts.values()) { // 枚举第 i 种字母
                n += cnt; // 常数优化：相比从 tiles.length() 开始要更快
                for (int j = n; j > 0; j--) // 枚举序列长度 j
                    // 枚举第 i 种字母选了 k 个，注意 k=0 时的方案数已经在 f[j] 中了
                    for (int k = 1; k <= j && k <= cnt; k++)
                        f[j] += f[j - k] * c[j][k];
            }
            int ans = 0;
            for (int j = 1; j <= n; j++)
                ans += f[j];
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

