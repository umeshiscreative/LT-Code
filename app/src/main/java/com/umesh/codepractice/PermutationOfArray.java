package com.umesh.codepractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationOfArray
{
    public static void main(String[] args)
    {
        int[] arr = new int[]
        { 4, 5, 6 };
        System.out.println(permuteDist(arr));
    }

    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr)
    {
        ArrayList<ArrayList<Integer>> allAns = new ArrayList<ArrayList<Integer>>();
        backTrack(arr, new ArrayList<>(), new HashSet<>(), allAns);
        return allAns;
    }

    public static void backTrack(int[] arr, ArrayList<Integer> ansList, Set<Integer> used, ArrayList<ArrayList<Integer>> allAns)
    {
        // Base Contd;
        if (ansList.size() == arr.length)
        {
            allAns.add(new ArrayList<>(ansList));
            return;
        }

        for (int i = 0; i < arr.length; i++)
        {
            if (!used.contains(arr[i]))
            {
                ansList.add(arr[i]);
                used.add(arr[i]);

                backTrack(arr, ansList, used, allAns);

                ansList.remove(ansList.size() - 1);
                used.remove(arr[i]);
            }
        }
    }
}
