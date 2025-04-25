/**
 * Codetop7, Leetcode53
 * https://leetcode.cn/problems/maximum-subarray/description/
 */

import java.lang.Math;
 

class Solution{
    private class Info {
        int lms, rms, ms, sum;
        Info(int lms, int rms, int ms, int sum){
            this.lms = lms;
            this.rms = rms;
            this.ms = ms;
            this.sum = sum;
        }
        
    }
    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length-1).ms;
    }

    public Info getInfo(int[] nums, int l, int r){
        if (l == r){
            return new Info(nums[l], nums[l], nums[l], nums[l]);
        }
        int mid = (l+r)/2;
        Info lInfo = getInfo(nums, l, mid);
        Info rInfo = getInfo(nums, mid+1, r);
        //merge
        return new Info(
            Math.max(lInfo.lms, lInfo.sum+rInfo.lms), 
            Math.max(lInfo.rms+rInfo.sum, rInfo.rms), 
            Math.max(Math.max(lInfo.ms, rInfo.ms), lInfo.rms+rInfo.lms), 
            lInfo.sum+rInfo.sum
        );
    }
}