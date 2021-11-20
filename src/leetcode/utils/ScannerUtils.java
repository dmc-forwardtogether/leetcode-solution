package leetcode.utils;

import java.util.Scanner;

/**
 * 输入工具类
 *
 * @author qxq
 * 2021/8/14
 */
public class ScannerUtils {

    /**
     * @return 整数
     */
    public static int scannerInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * @param detail 说明
     * @return 整数
     */
    public static int scannerInt(String detail) {
        System.out.print(detail);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * @return 整数数组
     */
    public static int[] scannerIntArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组大小:");
        int n = in.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        return ints;
    }

    /**
     * @param n 数组大小
     * @return 整数数组
     */
    public static int[] scannerIntArray(int n) {
        Scanner in = new Scanner(System.in);
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        return ints;
    }

    /**
     * @param n      数组大小
     * @param detail 说明
     * @return 整数数组
     */
    public static int[] scannerIntArray(String detail, int n) {
        System.out.print(detail);
        Scanner in = new Scanner(System.in);
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        return ints;
    }

    /**
     * @return M*N二维整数数组
     */
    public static int[][] scannerDoubleIntArray() {
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
    public static int[][] scannerDoubleIntArray(int m, int n) {
        Scanner in = new Scanner(System.in);
        return getDoubleIntArray(m, n, in);
    }

    /**
     * @param m  行数
     * @param n  列数
     * @param in Scanner
     * @return M*N二维整数数组
     */
    private static int[][] getDoubleIntArray(int m, int n, Scanner in) {
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = in.nextInt();
            }
        }
        return ints;
    }

    /**
     * @return 字符串数组
     */
    public static String[] scannerStringArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组大小:");
        String[] strings = new String[in.nextInt()];
        for (int i = 0; i < in.nextInt(); i++) {
            strings[i] = in.next();
        }
        return strings;
    }

    /**
     * @param detail 说明
     * @return 字符串数组
     */
    public static String[] scannerStringArray(String detail) {
        Scanner in = new Scanner(System.in);
        System.out.print(detail);
        String[] strings = new String[in.nextInt()];
        for (int i = 0; i < in.nextInt(); i++) {
            strings[i] = in.next();
        }
        return strings;
    }

    /**
     * @param detail 说明
     * @return 字符串
     */
    public static String scannerString(String detail) {
        Scanner in = new Scanner(System.in);
        System.out.print(detail);
        return in.nextLine();
    }

}
