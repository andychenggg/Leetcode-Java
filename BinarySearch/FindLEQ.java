package BinarySearch;

public class FindLEQ extends BinarySearch {

    /**
     * Find a greatest element that may exist, which is less than or equal to target
     * On the other side, we find a place to insert target, which keeps the nums ascending.
     */
    @Override
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r){
            int mid = (l + r)/2;

            if(nums[mid] <= target){
                l = mid+1;
            }
            else r = mid;
        }

        return l-1;
    }
    
}
