package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them
 * together.
 * <p>
 * Each number is given in array format: as an array of 0s and 1s, from most
 * significant bit to least significant bit. For example, arr = [1,1,0,1] represents
 * the number (-2)^3 + (-2)^2 + (-2)^0 = -3. A number arr in array, format is also
 * guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
 * <p>
 * Return the result of adding arr1 and arr2 in the same format: as an array of 0
 * s and 1s with no leading zeros.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * Output: [1,0,0,0,0]
 * Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: arr1 = [0], arr2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: arr1 = [0], arr2 = [1]
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * arr1[i] and arr2[i] are 0 or 1
 * arr1 and arr2 have no leading zeros
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 100 👎 0
 */

public class AddingTwoNegabinaryNumbers {
    public static void main(String[] args) {
        Solution solution = new AddingTwoNegabinaryNumbers().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int i = arr1.length - 1, j = arr2.length - 1;
            int carry = 0;
            List<Integer> ans = new ArrayList<>();
            while (i >= 0 || j >= 0 || carry != 0) {
                int x = carry;
                if (i >= 0) {
                    x += arr1[i];
                }
                if (j >= 0) {
                    x += arr2[j];
                }
                if (x >= 2) {
                    ans.add(x - 2);
                    carry = -1;
                } else if (x >= 0) {
                    ans.add(x);
                    carry = 0;
                } else {
                    ans.add(1);
                    carry = 1;
                }
                --i;
                --j;
            }
            while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
                ans.remove(ans.size() - 1);
            }
            int[] arr = new int[ans.size()];
            for (i = 0, j = ans.size() - 1; j >= 0; i++, j--) {
                arr[i] = ans.get(j);
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

