package com.umesh.codepractice;

public class RodCutting
{
    public static void main(String[] args)
    {
        int[] val = new int[]
        { 1, 5, 8, 9, 10, 17, 17, 20 };
        RodCutting obj = new RodCutting();
        System.out.print(obj.cutRod(val));
    }

    int dp[][] = null;

    public int cutRod(int[] price)
    {
        int n = price.length;
        int capacity = n;
        int size[] = new int[n];

        for (int i = 0; i < n; i++)
            size[i] = i + 1;
        dp = new int[n + 1][capacity + 1];

        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < capacity + 1; j++)
                dp[i][j] = -1;

        return solve(price, size, capacity, n);
    }

    public int solve(int[] price, int[] size, int capacity, int n)
    {
        // Base cont
        if (capacity == 0 || n == 0)
            return 0;

        if (dp[n][capacity] != -1)
            return dp[n][capacity];

        if (size[n - 1] <= capacity)
        {
            dp[n][capacity] = Math.max(price[n - 1] + solve(price, size, capacity - size[n - 1], n), solve(price, size, capacity, n - 1));
        }
        else if (size[n - 1] > capacity)
        {
            dp[n][capacity] = solve(price, size, capacity, n - 1);
        }
        return dp[n][capacity];
    }
}
