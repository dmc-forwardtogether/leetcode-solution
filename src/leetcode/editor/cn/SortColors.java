package leetcode.editor.cn;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
//
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1937 👎 0

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        solution.sortColors(new int[]{0, 1, 2, 2, 0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int r = 0, w = 0, i = 0;
            while (i < nums.length) {
                int curN = nums[i];
                if (curN == 0) {
                    nums[i] = nums[r];
                    nums[r] = curN;
                    r++;
                    curN = nums[i];
                    if (curN == 1) {
                        nums[i] = nums[w];
                        nums[w] = curN;
                    }
                    w++;
                    i++;
                } else if (curN == 1) {
                    nums[i] = nums[w];
                    nums[w] = curN;
                    w++;
                    i++;
                } else {
                    i++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
