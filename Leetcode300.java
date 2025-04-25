import java.lang.Math;

/**
 * CodeTop8, Leetcode300:
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 */
class Solution {
    public static void main(String[] args) {
        
    }
    /**
     * dp
     * Time Complexity: O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
 
