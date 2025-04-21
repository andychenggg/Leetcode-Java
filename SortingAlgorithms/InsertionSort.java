package SortingAlgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int [] nums = new int[]{6, 3, 4, 5, 7, 2,2, 4};
        new SelectionSort().sort(nums);
        for (int nums2 : nums) {
            System.out.print(nums2+" ");
        }
    }
    /**
     * Insertion sort: every time pick a number sequentially and insert it in the right place
     * @param nums
     */
    public void sort(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else break;
            }
        }
    }
}
