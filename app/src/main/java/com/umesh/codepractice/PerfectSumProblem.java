
public class PerfectSumProblem {

    public static void main(String[] args) {

    }

    public int perfectSum(int[] nums, int target) {
        return helper(nums, target, nums.length);
    }

    public int helper(int[] nums, int target, int size) {
        if (target == 0) {
            return 1;
        }
        if (size == 0) {
            return 0;
        }

        if (nums[size - 1] <= target) {
            return helper(nums, target - nums[size - 1], size - 1) + helper(nums, target, size - 1);
        } else if (nums[size - 1] > target) {
            return helper(nums, target, size - 1);
        }
        return 0;
    }
}
