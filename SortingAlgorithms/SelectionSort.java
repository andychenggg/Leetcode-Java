package SortingAlgorithms;

public class SelectionSort {
    /**
     * SelectionSort sort: select a smallest number in the remains everytime
     * Time complexity: O(n^2)
     * @param nums
     */
    public void sort(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[index] > nums[j]){
                    index = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{6, 3, 4, 5, 7, 2,2, 4};
        new SelectionSort().sort(nums);
        for (int nums2 : nums) {
            System.out.print(nums2+" ");
        }
    }
}
