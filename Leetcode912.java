
import java.util.Random;
public class Leetcode912 {
    public static void main(String[] args) {
        new Leetcode912(). quickSort(new int[]{1, 1, 1, 1}, 0, 2);
    }

    public void quickSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        Random rand = new Random();
        int pivot = rand.nextInt(start, end+1);
        swap(nums, start, pivot);
        pivot = start;
        int i = start + 1, j = end;
        while(true){
            while (i <= end &&nums[i] <= nums[pivot]) {
                i++;
            }
            while (start < j &&nums[j] > nums[pivot]) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            else break;
        }
        swap(nums, pivot, j);
        quickSort(nums, start, j-1);
        quickSort(nums, j+1, end);
    }
    
    public void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
class Solution {
    public int[] sortArray(int[] nums) {
        // mergeSort(nums, 0, nums.length-1, new int[nums.length]);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }


    /**
     * mergeSort, with space complexity O(n), time complexity O(nlogn)
     * @param nums
     * @param start
     * @param end
     * @param tmpArr
     */
    public void mergeSort(int [] nums, int start, int end, int[] tmpArr){
        if(start >= end){

            return;
        }

        int mid = (start + end) / 2;

        mergeSort(nums, start, mid, tmpArr);
        mergeSort(nums, mid+1, end, tmpArr);

        merge(nums, start, mid, end, tmpArr);
    }
    public void merge(int []nums, int start, int mid, int end, int [] tmpArr){
        int left = start, right = mid + 1;
        int tmpP = start;
        while (left <= mid && right <= end) {
            if(nums[left] <= nums[right]){
                tmpArr[tmpP++] = nums[left++];
            }
            else {
                tmpArr[tmpP++] = nums[right++];

            }
        }
        while (left <= mid) {
            tmpArr[tmpP++] = nums[left++];
            
        }
        while (right <= end) {
            tmpArr[tmpP++] = nums[right++];
            
        }
        tmpP = start;
        while(tmpP <= end){
            nums[tmpP] = tmpArr[tmpP];
            tmpP++;
        }
    }

    /**
     * quickSort the nums: double-way
     * introducing randomness: minimize the probability for time complexity O(n^2)
     * use "swap" to keep 
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        Random rand = new Random();
        int pivot = rand.nextInt(start, end+1);
        swap(nums, start, pivot);
        pivot = start;
        int i = start + 1, j = end;
        while(true){
            while (i <= end &&nums[i] <= nums[pivot]) {
                i++;
            }
            while (start < j &&nums[j] > nums[pivot]) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            else break;
        }
        swap(nums, pivot, j);
        quickSort(nums, start, j-1);
        quickSort(nums, j+1, end);
    }
    
    public void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}