package SortingAlgorithms;

public class MergeSort {
    public static void main(String[] args) {
        int [] nums = new int[]{6, 3, 4, 5, 7, 2,2, 4};
        new MergeSort().sort(nums, 0, nums.length-1);
        for (int nums2 : nums) {
            System.out.print(nums2+" ");
        }
    }
    /**
     * Merge sort: divide-and-conquer, dvide into 2 part and merge them
     * @param nums
     */
    public void sort(int [] nums, int l, int r){
        if (l >= r){
            return;
        }

        int mid = (l+r) / 2;
        sort(nums, l, mid);
        sort(nums, mid+1, r);

        int [] numCp = new int[r - l + 1];
        int pl = l, pr = mid+1, p1 = 0;
        while (pl <= mid && pr <= r){
            if(nums[pl] < nums[pr]){
                numCp[p1++] = nums[pl++];
            }
            else{
                numCp[p1++] = nums[pr++];
            }
        }
        while(pl <= mid)numCp[p1++] = nums[pl++];
        while(pr <= r)numCp[p1++] = nums[pr++];
        p1 = 0;
        pl = l;
        while(p1 < numCp.length)nums[pl++]=numCp[p1++];
    }
}
