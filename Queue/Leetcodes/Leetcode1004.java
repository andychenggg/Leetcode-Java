package Queue.Leetcodes;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int p1 = 0, p2 = 0;
        int res = 0;
        while (p1 < nums.length && p2 < nums.length){
            while(p2 < nums.length && k >= 0){
                if(nums[p2++] == 0){
                    k--;
                }
                if(k >= 0) res = res > p2-p1 ? res : p2-p1;
            }
            while(p1 < p2 && k < 0){
                if(nums[p1++] == 0){
                    k++;
                }
            }
        }
        return res;
    }
}
