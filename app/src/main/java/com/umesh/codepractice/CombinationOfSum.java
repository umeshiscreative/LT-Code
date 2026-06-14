package com.umesh.codepractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CombinationOfSum
{
    public static void main(String[] args)
    {
        int[] arr = new int[]
        { 4, 1, 1, 3, 4 };
        int target = 5;
        System.out.println(uniqueCombinations(arr, target));
    }

    public static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target)
    {
        // code here
        java.util.Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> allAns = new ArrayList<ArrayList<Integer>>();
        backTrack(arr, target, 0, 0, new ArrayList<>(), allAns);
        return allAns;
    }

    private static void backTrack(int[] arr, int target, int sum, int idx, ArrayList<Integer> ansList, ArrayList<ArrayList<Integer>> allAns)
    {
        // Base Contd:
        if (sum == target)
        {
            allAns.add(new ArrayList<>(ansList));
            return;
        }

        for (int i = idx; i < arr.length; i++)
        {
            if (sum + arr[i] > target)
                break;
            if (i > idx && arr[i] == arr[i - 1])
                continue;

            ansList.add(arr[i]);

            backTrack(arr, target, sum + arr[i], i + 1, ansList, allAns);

            ansList.remove(ansList.size() - 1);
        }
    }
}
