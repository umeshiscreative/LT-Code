package com.umesh.codepractice;

public class KnapSack {

    int[][] dp = null;

    public static void main(String[] args) {
        int wt[] = new int[]{4, 5, 1};
        int val[] = new int[]{1, 2, 3};
        int W = 4;
        KnapSack obj = new KnapSack();
        System.out.println(obj.knapsack(W, val, wt));
    }

    // This recusrion solution may be time limit exceed on Geeks for Geeks inputs
    // public int knapsack(int W, int val[], int wt[]) {
    //     int idx = wt.length;
    //     return helper(W, val, wt, idx);
    // }
    // public int helper(int W, int val[], int wt[], int index) {
    //     if (index == 0 || W == 0) {
    //         return 0;
    //     }
    //     if (wt[index - 1] <= W) {
    //         return Math.max(
    //                 val[index - 1] + helper(W - wt[index - 1], val, wt, index - 1),
    //                 helper(W, val, wt, index - 1));
    //     } else if (wt[index - 1] > W) {
    //         return helper(W, val, wt, index - 1);
    //     }
    //     return -1;
    // }
    public int knapsack(int W, int val[], int wt[]) {
        int idx = wt.length;
        dp = new int[wt.length + 1][W + 1];

        for (int row = 0; row < idx + 1; row++) {
            for (int col = 0; col < W + 1; col++) {
                dp[row][col] = -1;
            }
        }

        return helper(W, val, wt, idx);
    }

    public int helper(int W, int val[], int wt[], int index) {
        if (index == 0 || W == 0) {
            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        if (wt[index - 1] <= W) {
            dp[index][W] = Math.max(
                    val[index - 1] + helper(W - wt[index - 1], val, wt, index - 1),
                    helper(W, val, wt, index - 1));
        } else if (wt[index - 1] > W) {
            dp[index][W] = helper(W, val, wt, index - 1);
        }
        return dp[index][W];
    }
}
