package com.umesh.codepractice;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 34, 4, 12, 5, 2};
        int target = 9;
        SubSetSum sum = new SubSetSum();
        System.out.println(sum.solve(arr, target));
    }

    // Using iteration ->> Using Memoization
    public boolean solve(int []arr, int target){
        Boolean[][] dp = new Boolean[arr.length+ 1][target+ 1];
        //Initialize the dp with init values
        // for(int i=0;i<arr.length;i++) {
        //     dp[i][0] = true;
        // }
        for(int i=0;i<arr.length;i++) { 
            for(int j=0;j<target;j++){ 
                if(i == 0 || j == 0){ 
                    dp[i][j] = true; 
                } else {
                    dp[i][j] = false; 
                } 
            } 
        }

        for(int i=1;i<=arr.length;i++) {
            for(int j=1;j<=target;j++){
                if(arr[i-1] <= j){
                    //Choice PICk YES OR NO
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }
                else {
                    // PICK NO
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][target];
    }



    // Boolean[][] dp;

    // public static void main(String[] args) {
    //     int[] arr = new int[]{3, 34, 4, 12, 5, 2};
    //     int target = 9;
    //     int index = 0;
    //     SubSetSum sum = new SubSetSum();
    //     sum.dp = new Boolean[arr.length + 1][target+1];
    //     System.out.println(sum.solve(arr, index,  target));
    // }

    // // Using recusriosn ->> Using Memoization
    // public boolean solve(int []arr, int index, int target){
    //     //Base contd
    //     if(target == 0) return true;
    //     if(index == arr.length) return false;

    //     if(dp[index][target] != null) return dp[index][target];

    //     if(arr[index] <= target){
    //         // Choice PICK OR NO
    //         dp[index][target] = solve(arr, index + 1, target - arr[index]) || solve(arr, index + 1, target);
    //     }
    //     else{
    //         //Always NO
    //         dp[index][target] =  solve(arr, index + 1, target);
    //     }
    //     return dp[index][target];
    // }

    // // Using recusriosn ->> left to right movement
    // public static boolean solve(int []arr, int index, int target){
    //     //Base contd
    //     if(target == 0) return true;
    //     if(index == arr.length) return false;

    //     if(arr[index] <= target){
    //         // Choice PICK OR NO
    //         return solve(arr, index + 1, target - arr[index]) || solve(arr, index + 1, target);
    //     }
    //     else{
    //         //Always NO
    //         return solve(arr, index + 1, target);
    //     }
    // }

    // Using recusriosn ->> right to left movement
    // public static boolean solve(int []arr, int index, int target){
    //     //Base contd
    //     if(target == 0) return true;
    //     if(index < 0) return false;

    //     if(arr[index] <= target){
    //         // Choice PICK OR NO
    //         return solve(arr, index - 1, target - arr[index]) || solve(arr, index - 1, target);
    //     }
    //     else{
    //         //Always NO
    //         return solve(arr, index - 1, target);
    //     }
    // }
}
