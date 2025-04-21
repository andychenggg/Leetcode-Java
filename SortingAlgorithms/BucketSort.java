package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    /**
     * Bucket sort: better performance for even distribution
     * Time complexity: best case O(n + nlog(n/m)), m is the number of bucket, m=n
     * worse case: O(nlogn)
     * @param nums
     * @param bucketCnt
     */
    public void sort(int [] nums, int bucketCnt){
        if(nums.length <=1) return;
        // map nums range to [0, n)
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;
            max = nums[i] > max ? nums[i] : max;
        }
        if(max == min){
            return;
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCnt; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            buckets.get((nums[i] - min)/(max-min+1)*bucketCnt).add(nums[i]);
        }
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        int p = 0;
        for(List<Integer> bucket: buckets){
            for(int i: bucket){
                nums[p++] = i;
            }
        }
    }
}
