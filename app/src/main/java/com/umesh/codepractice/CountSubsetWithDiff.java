package com.umesh.codepractice;

public class CountSubsetWithDiff
{

    public static void main(String[] args)
    {
        int[] arr = new int[]
        { 1, 3, 3, 2, 1 };
        // { 5, 2, 6, 4 };
        int diff = 5;
        int output = 0;
        CountSubsetWithDiff obj = new CountSubsetWithDiff();
        System.out.print(obj.countPartitions(arr, diff) == output);
    }

    int dp[][] = null;

    public int countPartitions(int[] arr, int diff)
    {
        // code here
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
        }

        if ((sum + diff) % 2 != 0)
            return 0;

        int targetSum = (sum + diff) / 2;
        dp = new int[n + 1][targetSum + 1];

        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < targetSum + 1; j++)
            {
                dp[i][j] = -1;
            }
        }

        return solve(arr, targetSum, n);
    }

    public int solve(int[] arr, int sum, int n)
    {
        if (n == 0)
        {
            if (sum == 0)
                return 1;
            return 0;
        }

        if (dp[n][sum] != -1)
            return dp[n][sum];

        if (arr[n - 1] <= sum)
        {
            dp[n][sum] = solve(arr, sum - arr[n - 1], n - 1) + solve(arr, sum, n - 1);
        }
        else if (arr[n - 1] > sum)
        {
            dp[n][sum] = solve(arr, sum, n - 1);
        }

        return dp[n][sum];
    }
}
