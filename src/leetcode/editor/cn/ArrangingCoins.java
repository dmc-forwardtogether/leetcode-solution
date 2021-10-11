package leetcode.editor.cn;

//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 168 👎 0

public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
        System.out.println(solution.arrangeCoins(182));
    }

    //第一种等差数列不等式移项
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //第二种二分查找
    class Solution2 {
        public int arrangeCoins(int n) {
            long l = 1, r = n;
            while (l < r) {
                long mid = l + r + 1 >> 1;
                if (mid * (mid + 1) / 2 <= n) l = mid;
                else r = mid - 1;
            }
            return (int) r;
        }

    }


}
