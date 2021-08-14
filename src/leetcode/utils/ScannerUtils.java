package leetcode.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * @author qxq
 * 2021/8/14
 */
public class ScannerUtils {

    /**
     * @return 整数
     */
    public static int ScannerInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * @return 整数数组
     */
    public static int @NotNull [] ScannerIntArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组大小:");
        int[] ints = new int[in.nextInt()];
        for (int i = 0; i < in.nextInt(); i++) {
            ints[i] = in.nextInt();
        }
        return ints;
    }

    /**
     * @param n 数组大小
     * @return 整数数组
     */
    public static int @NotNull [] ScannerIntArray(int n) {
        Scanner in = new Scanner(System.in);
        int[] ints = new int[n];
        for (int i = 0; i < in.nextInt(); i++) {
            ints[i] = in.nextInt();
        }
        return ints;
    }

    /**
     * @return M*N二维整数数组
     */
    public static int @NotNull [][] ScannerDoubleIntArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组行数:");
        //行数
        int m = in.nextInt();
        System.out.println("请输入数组列数:");
        //列数
        int n = in.nextInt();
        return getDoubleIntArray(m, n, in);
    }

    /**
     * @param m 行数
     * @param n 列数
     * @return M*N二维整数数组
     */
    public static int @NotNull [][] ScannerDoubleIntArray(int m, int n) {
        Scanner in = new Scanner(System.in);
        return getDoubleIntArray(m, n, in);
    }

    /**
     * @param m  行数
     * @param n  列数
     * @param in Scanner
     * @return M*N二维整数数组
     */
    private static int @NotNull [][] getDoubleIntArray(int m, int n, Scanner in) {
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = in.nextInt();
            }
        }
        return ints;
    }

}
