import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Codetop4, leetcode15
 * https://leetcode.cn/problems/3sum/description/
 */
public class CodeTop4 {
    public static void main(String[] args) {
        // System.out.println("hello");
        // Solution sol = new Solution();
        System.out.println(new CodeTop4().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                return res;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                if (nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j]==nums[j+1])
                        j++;
                    while(k>j && nums[k] == nums[k-1])
                        k--;
                    j++;
                    k--;
                }
                else if (nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                else k--;
            }
        }
        return res;
    }
    
}