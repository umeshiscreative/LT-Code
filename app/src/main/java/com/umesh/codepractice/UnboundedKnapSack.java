package com.umesh.codepractice;

public class UnboundedKnapSack
{
    public static void main(String[] args)
    {
        int[] wt =
        { 1, 3, 4, 5 };
        int[] val =
        { 10, 40, 50, 70 };
        int W = 8;
        UnboundedKnapSack obj = new UnboundedKnapSack();
        System.out.println(obj.knapSack(val, wt, W));
    }

    int[][] dp = null;

    public int knapSack(int val[], int wt[], int capacity)
    {
        dp = new int[wt.length + 1][capacity + 1];
        for (int i = 0; i < wt.length + 1; i++)
            for (int j = 0; j < capacity + 1; j++)
                dp[i][j] = -1;
        return solve(val, wt, capacity, wt.length);
    }

    public int solve(int val[], int wt[], int capacity, int n)
    {
        if (capacity == 0 || n == 0)
            return 0;

        if (dp[n][capacity] != -1)
            return dp[n][capacity];

        if (wt[n - 1] <= capacity)
        {
            dp[n][capacity] = Math.max(val[n - 1] + solve(val, wt, capacity - wt[n - 1], n), solve(val, wt, capacity, n - 1));
        }
        else if (wt[n - 1] > capacity)
        {
            dp[n][capacity] = solve(val, wt, capacity, n - 1);
        }
        return dp[n][capacity];
    }
}
