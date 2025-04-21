package SortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int [] nums = new int[]{6, 3, 4, 5, 7, 2,2, 4};
        new BubbleSort().sort(nums);
        for (int nums2 : nums) {
            System.out.print(nums2+" ");
        }
    }
    /**
     * Bubble sort: every time swap 2 nearest number, enable the largest number to reach the right-most place
     * @param nums
     */
    public void sort(int [] nums){
        for (int i = nums.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    
}
