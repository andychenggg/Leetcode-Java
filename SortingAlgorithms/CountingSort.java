package SortingAlgorithms;

public class CountingSort {
    /**
     * Counting Sort: better performance for densely sorted.
     * Time complexity: O(n+k), k is length of counting arr
     * @param nums
     */
    public void sort(int [] nums){
        if (nums.length <= 1) return;
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = min < nums[i] ? min : nums[i];
            max = max > nums[i] ? max : nums[i];

        }
        int len = max-min+1;
        int [] cntArr = new int[len];
        for (int i = 0; i < nums.length; i++) {
            cntArr[nums[i]-min]++;
        }
        int p =0;
        for (int i = 0; i < cntArr.length; i++) {
            while(cntArr[i]-- > 0) nums[p++] = i+min;
        }

    }
}
