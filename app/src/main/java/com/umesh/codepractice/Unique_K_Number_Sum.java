package com.umesh.codepractice;

import java.util.ArrayList;

public class Unique_K_Number_Sum
{
    public static void main(String[] args)
    {
        int n = 9;
        int k = 3;
        System.out.println(new Unique_K_Number_Sum().combinationSum(n, k));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k)
    {
        ArrayList<ArrayList<Integer>> allAns = new ArrayList<ArrayList<Integer>>();
        backTrack(n, k, 0, 1, new ArrayList<>(), allAns);
        return allAns;
    }

    private void backTrack(int n, int k, int sum, int start, ArrayList<Integer> ansList, ArrayList<ArrayList<Integer>> allAns)
    {
        if (sum == n && ansList.size() == k)
        {
            allAns.add(new ArrayList<>(ansList));
            return;
        }

        for (int i = start; i <= 9; i++)
        {
            if (sum + i > n)
                break;

            ansList.add(i);

            backTrack(n, k, sum + i, i + 1, ansList, allAns);

            ansList.remove(ansList.size() - 1);
        }
    }
}

/**
 * 
 * [[1, 2, 6], [1, 3, 5], [1, 5, 3], [1, 6, 2], [1, 8], [2, 1, 6], [2, 3, 4], [2, 4, 3], [2, 6, 1], [2, 7], [3, 1, 5],
 * [3, 2, 4], [3, 4, 2], [3, 5, 1], [3, 6], [4, 2, 3], [4, 3, 2], [4, 5], [5, 1, 3], [5, 3, 1], [5, 4], [6, 1, 2], [6,
 * 2, 1], [6, 3], [7, 2], [8, 1], [9]]
 */
