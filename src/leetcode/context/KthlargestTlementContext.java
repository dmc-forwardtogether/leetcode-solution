package leetcode.context;

import leetcode.utils.ScannerUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author qxq
 * 2021/8/16
 */
public class KthlargestTlementContext {
    public static void main(String[] args) {
        int k = ScannerUtils.ScannerInt("k = ");
        int n = ScannerUtils.ScannerInt("请输入初始化数组大小:");
        int[] nums = ScannerUtils.ScannerIntArray("nums = ", n);
        KthLargestTLE kthLargest = new KthLargestTLE(k, nums);
        while (true) {
            System.out.println(kthLargest.add(ScannerUtils.ScannerInt()));
        }
    }

    /**
     * 冒泡排序
     */
    static class KthLargestTLE {
        int k;
        List<Integer> list = new ArrayList<>(10009);

        public KthLargestTLE(int _k, int[] _nums) {
            k = _k;
            for (int i : _nums) list.add(i);
        }

        public int add(int val) {
            list.add(val);
            int cur = 0;
            for (int i = 0; i < k; i++) {
                int idx = findMax(cur, list.size() - 1);
                swap(cur++, idx);
            }
            return list.get(cur - 1);
        }

        int findMax(int start, int end) {
            int ans = 0, max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                int t = list.get(i);
                if (t > max) {
                    max = t;
                    ans = i;
                }
            }
            return ans;
        }

        void swap(int a, int b) {
            int c = list.get(a);
            list.set(a, list.get(b));
            list.set(b, c);
        }
    }

    /**
     * 快速排序
     */
    static class KthLargestQS {
        int k;
        //最大不超过10000
        List<Integer> list = new ArrayList<>(10009);

        public KthLargestQS(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                list.add(num);
            }
        }

        public int add(int val) {
            list.add(val);
            Collections.sort(list);
            return list.get(list.size() - k);
        }
    }

    /**
     * 优先队列
     */
    static class KthLargestPQ{
        int k;
        PriorityQueue<Integer> queue;
        public KthLargestPQ(int _k, int[] _nums) {
            k = _k;
            queue = new PriorityQueue<>(k, Integer::compare);
            int n = _nums.length;
            for (int i = 0; i < k && i < n; i++) queue.add(_nums[i]);
            for (int i = k; i < n; i++) add(_nums[i]);
        }
        public int add(int val) {
            int t = !queue.isEmpty() ? queue.peek() : Integer.MIN_VALUE;
            if (val > t || queue.size() < k) {
                if (!queue.isEmpty() && queue.size() >= k) queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }
}
