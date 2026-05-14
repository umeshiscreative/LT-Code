package com.umesh.codepractice;

public class LC698 {

    public static void main(String[] args) {
        // int[] arr = new int[]{2, 2, 2, 2, 3, 4, 5};
        int[] arr = new int[]{4, 3, 2, 3, 5, 2, 1};
        int target = 4;
        LC698 obj = new LC698();
        System.out.println(obj.canPartitionKSubsets(arr, target));
    }

    // This is not DP problem its belongs to backtracking
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int size = nums.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        int targetW = sum / k;

        int[][] dp = new int[size + 1][targetW + 1];

        // Initialize
        for (int row = 0; row <= size; row++) {
            for (int col = 0; col <= targetW; col++) {
                if (row == 0) {
                    dp[row][col] = 0;
                }
                if (col == 0) {
                    dp[row][col] = 1;
                }
            }
        }

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= targetW; col++) {
                if (nums[row - 1] <= col) {
                    dp[row][col] = dp[row - 1][col - nums[row - 1]] + dp[row - 1][col];
                } else if (nums[row - 1] > col) {
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }
        return dp[size][targetW] == k;
    }
}
