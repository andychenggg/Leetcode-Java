package BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class TestFindLEQ {

    public static void main(String[] args) {
        FindLEQ finder = new FindLEQ();
        Random random = new Random();

        int totalTests = 20;
        int passed = 0;

        for (int i = 1; i <= totalTests; i++) {
            int[] nums;
            int target;

            switch (i) {
                case 1: nums = new int[] {}; target = 3; break;
                case 2: nums = new int[] {1}; target = 1; break;
                case 3: nums = new int[] {1, 2, 2, 3}; target = 2; break;
                case 4: nums = new int[] {1, 2, 3, 4}; target = 0; break;
                case 5: nums = new int[] {1, 2, 3, 4}; target = 5; break;
                case 6: nums = new int[] {-5, -2, 0, 3}; target = -4; break;
                case 7: nums = new int[] {-3, -1, 2, 4}; target = 0; break;
                case 8: nums = new int[] {-2, 2, 2, 2, 5}; target = 2; break;
                case 9: nums = generateSortedArray(10, 100, true); target = 30; break;
                case 10: nums = generateSortedArray(15, 200, true); target = -50; break;
                case 11: nums = new int[] {2, 4, 6, 8, 10}; target = 7; break;
                case 12: nums = new int[] {0, 1, 2, 3}; target = 1; break;
                case 13: nums = new int[] {10, 20, 30}; target = 25; break;
                case 14: nums = new int[] {10, 20, 30}; target = 5; break;
                case 15: nums = generateSortedArray(20, 300, true); target = 100; break;
                case 16: nums = generateSortedArray(30, 500, false); target = 0; break;
                case 17: nums = new int[] {0, 0, 0, 0}; target = 1; break;
                case 18: nums = new int[] {1, 1, 1, 1}; target = 1; break;
                case 19: nums = new int[] {-5, -3, -1}; target = -2; break;
                case 20: nums = new int[] {-5, -3, -1}; target = -6; break;
                default: nums = new int[] {}; target = 0; break;
            }

            Arrays.sort(nums); // 确保数组升序

            int resultIndex = finder.search(nums, target);

            // 手动找最后一个 ≤ target 的索引
            int expectedIndex = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= target) {
                    expectedIndex = j;
                }
            }

            if (resultIndex == expectedIndex) {
                System.out.println("✅ Test " + i + " passed.");
                passed++;
            } else {
                System.out.println("❌ Test " + i + " failed.");
                System.out.println("Array:  " + Arrays.toString(nums));
                System.out.println("Target: " + target);
                System.out.println("Expected index: " + expectedIndex);
                System.out.println("Your result:     " + resultIndex);
            }
        }

        System.out.println("\nTests passed: " + passed + " / " + totalTests);
    }

    private static int[] generateSortedArray(int size, int bound, boolean forceIncludeLow) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(bound * 2) - bound;
        }
        if (forceIncludeLow) result[rand.nextInt(size)] = 0;
        Arrays.sort(result);
        return result;
    }
}
