package leetcode.editor.cn;

//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 👍 735 👎 0

import leetcode.utils.ScannerUtils;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        int dividend = ScannerUtils.scannerInt("被除数:");
        int divisor = ScannerUtils.scannerInt("除数:");
        System.out.println(solution.divide(dividend, divisor));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int INF = Integer.MAX_VALUE;

        public int divide(int dividend, int divisor) {
            long a = dividend, b = divisor;
            //正负号 false正 true负号
            boolean flag = (a < 0 && b > 0) || (a > 0 && b < 0);
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }
            long l = 0, r = a;
            while (l < r) {
                long mid = l + r + 1 >> 1;
                if (mul(mid, b) <= a) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            r = flag ? -r : r;
            if (r > INF || r < -INF - 1) return INF;
            return (int) r;
        }

        long mul(long a, long k) {
            long ans = 0;
            while (k > 0) {
                if ((k & 1) == 1) ans += a;
                k >>= 1;
                a += a;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
