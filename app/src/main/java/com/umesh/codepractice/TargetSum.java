package com.umesh.codepractice;

public class TargetSum
{
    public static void main(String[] args)
    {
        int[] nums = new int[]
        { 1, 1, 1, 1, 1 };
        int target = 3;

        TargetSum obj = new TargetSum();
        System.out.println(obj.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target)
    {
        int n = nums.length, sum = 0;

        for (int i = 0; i < n; i++)
            sum += nums[i];

        if (sum + target < 0 || (sum + target) % 2 != 0)
            return 0;

        int targetSum = (sum + target) / 2;
        return solve(nums, targetSum, n);
    }

    public int solve(int[] arr, int sum, int n)
    {
        if (n == 0)
        {
            if (sum == 0)
                return 1;
            return 0;
        }
        if (arr[n - 1] <= sum)
        {
            return solve(arr, sum - arr[n - 1], n - 1) + solve(arr, sum, n - 1);
        }
        else if (arr[n - 1] > sum)
        {
            return solve(arr, sum, n - 1);
        }
        return 0;
    }
}
