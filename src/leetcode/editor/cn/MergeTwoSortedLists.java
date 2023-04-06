package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3044 👎 0

import java.util.Arrays;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode list0 = new ListNode(3, null);
        ListNode list1 = new ListNode(-9, list0);
        ListNode list2 = new ListNode(7, null);
        ListNode list3 = new ListNode(5, list2);

        ListNode ans = solution.mergeTwoLists(list1, list3);
        int[] ansArr = new int[20];
        int n = 0;
        while (ans != null) {
            ansArr[n] = ans.val;
            ans = ans.next;
            n++;
        }
        System.out.println(Arrays.toString(ansArr));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode listNode = new ListNode();
            ListNode head;

            if (list1 == null && list2 == null) {
                return null;
            } else if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }

            if (list1.val > list2.val) {
                listNode.next = list2;
                list2 = list2.next;
            } else {
                listNode.next = list1;
                list1 = list1.next;
            }
            listNode = listNode.next;
            head = listNode;

            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    listNode.next = list2;
                    list2 = list2.next;
                } else {
                    listNode.next = list1;
                    list1 = list1.next;
                }
                listNode = listNode.next;
            }

            if (list1 == null) {
                while (list2 != null) {
                    listNode.next = list2;
                    list2 = list2.next;
                    listNode = listNode.next;
                }
            } else {
                while (list1 != null) {
                    listNode.next = list1;
                    list1 = list1.next;
                    listNode = listNode.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
