package leetcode.editor.cn;

//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//109 + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 
// 👍 163 👎 0

import leetcode.utils.ScannerUtils;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        Solution solution = new OutOfBoundaryPaths().new Solution();
        int m = ScannerUtils.scannerInt("m = ");
        int n = ScannerUtils.scannerInt("n = ");
        int maxMove = ScannerUtils.scannerInt("maxMove = ");
        int startRow = ScannerUtils.scannerInt("startRow = ");
        int startColumn = ScannerUtils.scannerInt("startColumn = ");
        System.out.println(solution.findPaths(m, n, maxMove, startRow, startColumn));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            //过大的结果处理
            int tooBig = 1000000007;
            //移动方向
            int[][] coordinates = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            //出界数
            int outCount = 0;
            int[][] dp = new int[m][n];
            dp[startRow][startColumn] = 1;

            for (int i = 0; i < maxMove; i++) {
                int[][] newDp = new int[m][n];
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int count = dp[j][k];
                        if (count > 0) {
                            for (int[] coordinate : coordinates) {
                                int j1 = j + coordinate[0];
                                int k1 = k + coordinate[1];
                                if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                    newDp[j1][k1] = (newDp[j1][k1] + count) % tooBig;
                                } else {
                                    outCount = (outCount + count) % tooBig;
                                }
                            }
                        }
                    }
                }
                dp = newDp;
            }

            return outCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
