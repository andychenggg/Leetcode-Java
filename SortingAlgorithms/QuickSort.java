package SortingAlgorithms;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int [] nums = new int[]{6, 3, 4, 5, 7, 2,2, 4};
        new QuickSort().sort(nums, 0, nums.length-1);
        for (int nums2 : nums) {
            System.out.print(nums2+" ");
        }
    }

    public void sort(int [] nums, int l, int r){
        if(l >= r){
            return;
        }
        // randomized algorithm
        Random rand = new Random();
        int index = rand.nextInt(r - l + 1) + l;
        swap(nums, l, index);

        int pivot = nums[l];
        int i = l+1, j = r;
        while(i <= j){
            while(i <= r && nums[i] <= pivot ) i++;
            while(j >= l+1 && nums[j] > pivot  ) j--;
            if(i < j){
                swap(nums, i, j);
                
            }
        }
        swap(nums, l, j);
        sort(nums, l, j-1);
        sort(nums, j+1, r);
    }

    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class QuickSort3Way {
    public void sort(int [] nums, int l, int r){
        if(l >= r){
            return;
        }
        // randomized algorithm
        Random rand = new Random();
        int index = rand.nextInt(r - l + 1) + l;
        swap(nums, l, index);

        int pivot = nums[l];
        int lt = l, eq = l+1, gt = r;
        while(eq <= gt){
            if(nums[eq] ==pivot){
                eq++;
            }
            else if(nums[eq] > pivot){
                swap(nums, eq, gt);
                gt--;
            }
            else{
                // <
                swap(nums, eq,lt);
                lt++;
            }
        }
        sort(nums, l, lt-1);
        sort(nums, gt+1, r);
    }

    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
