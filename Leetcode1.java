import java.util.Arrays;

public class Leetcode1 {

    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p0 = 0, p1 = nums.length-1;
        class Pair {
            int val;
            int index;
            Pair(int val, int index){
                this.val = val;
                this.index = index;
            }
        }

        Pair [] pairs = new Pair[nums.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a.val, b.val));

        while (p0 < p1){
            if(pairs[p0].val + pairs[p1].val == target){
                return new int[]{pairs[p0].index, pairs[p1].index};
            }
            else if (pairs[p0].val + pairs[p1].val > target){
                p1--;
            }
            else p0++;
        }
        return null;
    }
}