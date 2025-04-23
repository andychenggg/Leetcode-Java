public class Leetcode33 {
    
}
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;

        while (l <= r){
            if (nums[l] <= nums[r]){
                int mid = (l+r)/2;
                if(nums[mid] < target){
                    l = mid+1;
                }
                else if(nums[mid] == target){
                    return mid;
                }
                else r = mid-1;
            }
            else {
                // l in part 1, r in part 2
                int mid = (l+r)/2;
                if(nums[mid] == target){
                    return mid;
                
                }
                else if (nums[mid] > target){
                    if(nums[mid] < nums[l]){
                        r = mid-1;
                    }
                    else if (target <= nums[r]){
                        l = mid +1;
                    }
                    else if(target > nums[r]){
                        r = mid-1;
                    }
                    else{
                        System.out.printf("error1: l: %d, r: %d, mid: %d, target: %d\n", l, r, mid, target);
                    }
                }
                else {
                    // nums[mid] < target
                    if(nums[mid] > nums[r]){
                        l = mid+1;
                    }
                    else if(target <= nums[r]){
                        l = mid +1;
                    }
                    else if(target > nums[r]){
                        r = mid-1;
                    }
                    else {
                        System.out.println("error2");
                    }
                }
            }
        }
        return -1;
    }
}
