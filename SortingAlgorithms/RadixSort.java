package SortingAlgorithms;

public class RadixSort {
    /**
     * Radix sort: counting sort for each digit
     * 
     * @param nums
     */
    public void sort(int [] nums){
        if (nums.length <= 1)return;
        // add min to the nums
        int min = nums[0];
        for(int i: nums) min = min < i ? min : i;
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }

        // Calculate max
        int max = nums[0];

        for(int i: nums) max = max > i ? max : i;

        // sorting by radix
        for(int exp = 1; max/exp != 0; exp *=10){
            int [] count = new int[10];
            int [] output =  new int[nums.length];
            
            for(int num: nums) count[(num / exp) % 10]++;

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i-1];
            }

            // for stability
            for (int i = nums.length-1; i >=0; i--) {
                int digit = (nums[i] / exp) % 10;
                output[--count[digit]] = nums[i];
            }

            System.arraycopy(output, 0, nums, 0, nums.length);
            
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] += min;
        }

    }
}
