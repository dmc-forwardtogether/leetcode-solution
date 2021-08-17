package leetcode.editor.cn;

//假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，
//我们就称这个数组为一个优美的排列。条件： 
//
// 
// 第 i 位的数字能被 i 整除 
// i 能被第 i 位上的数字整除 
// 
//
// 现在给定一个整数 N，请问可以构造多少个优美的排列？ 
//
// 示例1: 
//
// 
//输入: 2
//输出: 2
//解释: 
//
//第 1 个优美的排列是 [1, 2]:
//  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
//
//第 2 个优美的排列是 [2, 1]:
//  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
// 
//
// 说明: 
//
// 
// N 是一个正整数，并且不会超过15。 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 
// 👍 217 👎 0

import leetcode.utils.ScannerUtils;

public class BeautifulArrangement {
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangement().new Solution();
        int n = ScannerUtils.ScannerInt("N = ");
        System.out.println(solution.countArrangement(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int getCnt(int x) {
            int ans = 0;
            while (x != 0) {
                // 保留二进制下最后出现的1的位置，其余位置置0（即一个数中最大的2的n次幂的因数
                x -= (x & -x); 
                ans++;
            }
            return ans;
        }
        public int countArrangement(int n) {
            int mask = 1 << n;
            int[] f = new int[mask];
            f[0] = 1;
            // 枚举所有的状态
            for (int state = 1; state < mask; state++) {
                // 计算 state 有多少个 1（也就是当前排序长度为多少）
                int cnt = getCnt(state);
                // 枚举最后一位数值为多少
                for (int i = 0; i < n; i++) {
                    // 数值在 state 中必须是 1
                    if (((state >> i) & 1) == 0) continue;
                    // 数值（i + 1）和位置（cnt）之间满足任一整除关系
                    if ((i + 1) % cnt != 0 && cnt % (i + 1) != 0) continue;
                    // state & (~(1 << i)) 代表将 state 中所选数值的位置置零
                    f[state] += f[state & (~(1 << i))];
                }
            }
            return f[mask - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
