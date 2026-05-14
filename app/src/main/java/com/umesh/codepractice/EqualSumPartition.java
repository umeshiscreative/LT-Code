package com.umesh.codepractice;

public class EqualSumPartition {

    Boolean t[][] = null;

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 5};
        EqualSumPartition obj = new EqualSumPartition();
        System.out.print(obj.canPartition(arr));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            sum += nums[idx];
        }
        if (sum % 2 == 0) {
            int targetSum = sum / 2;
            int index = nums.length;
            t = new Boolean[index + 1][targetSum + 1];
            return helper(nums, targetSum, index);
        }
        return false;
    }

    // Recursive calls
    public boolean helper(int[] arr, int W, int idx) {
        if (W == 0) {
            return true;
        }
        if (idx == 0) {
            return false;
        }

        if (t[idx][W] != null) {
            return t[idx][W];
        }

        if (arr[idx - 1] <= W) {
            t[idx][W] = helper(arr, W - arr[idx - 1], idx - 1) || helper(arr, W, idx - 1);
        } else if (arr[idx - 1] > W) {
            t[idx][W] = helper(arr, W, idx - 1);
        }
        return t[idx][W];
    }
}
