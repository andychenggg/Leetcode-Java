package BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class TestFindFirst {

    public static void main(String[] args) {
        FindFirst finder = new FindFirst();
        Random random = new Random();

        int totalTests = 20;
        int passed = 0;

        for (int i = 1; i <= totalTests; i++) {
            int[] nums;
            int target;

            switch (i) {
                case 1: nums = new int[] {}; target = 5; break;
                case 2: nums = new int[] {1}; target = 1; break;
                case 3: nums = new int[] {5, 5, 5, 5}; target = 5; break;
                case 4: nums = new int[] {1, 2, 2, 3, 3, 4}; target = 3; break;
                case 5: nums = new int[] {1, 2, 3, 4}; target = 5; break;
                case 6: nums = new int[] {-3, -1, 0, 5}; target = -1; break;
                case 7: nums = new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE}; target = 0; break;
                case 8: nums = new int[] {1, 3, 3, 3, 5}; target = 3; break;
                case 9: nums = generateRandomSortedArray(10, 100, 3); target = 3; break;
                case 10: nums = generateRandomSortedArray(20, 200, 5); target = 5; break;
                case 11: nums = new int[] {1, 1, 2, 2, 2, 3}; target = 2; break;
                case 12: nums = new int[] {-200, -100, 100, 200}; target = 100; break;
                case 13: nums = new int[] {1, 2, 2, 2, 3}; target = 2; break;
                case 14: nums = new int[] {4, 5, 6, 6, 6, 7}; target = 6; break;
                case 15: nums = generateRandomSortedArray(30, 300, 0); target = 0; break;
                case 16: nums = generateRandomSortedArray(50, 500, 9); target = 9; break;
                case 17: nums = new int[] {0, 0, 0, 1}; target = 1; break;
                case 18: nums = new int[] {0, 0, 0, 1}; target = 0; break;
                case 19: nums = new int[] {-5, -5, -3, -2}; target = -5; break;
                case 20: nums = generateRandomSortedArray(25, 1000, 999); target = 999; break;
                default: nums = new int[] {}; target = 0; break;
            }

            int result = finder.search(nums, target);

            // 手动找第一个出现的索引
            int expected = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == target) {
                    expected = j;
                    break;
                }
            }

            if (result == expected) {
                System.out.println("✅ Test " + i + " passed.");
                passed++;
            } else {
                System.out.println("❌ Test " + i + " failed.");
                System.out.println("Array:  " + Arrays.toString(nums));
                System.out.println("Target: " + target);
                System.out.println("Expected index: " + expected);
                System.out.println("Your result:     " + result);
            }
        }

        System.out.println("\nTests passed: " + passed + " / " + totalTests);
    }

    // 创建包含至少一个目标值的有序数组
    private static int[] generateRandomSortedArray(int size, int bound, int includeTarget) {
        Random rand = new Random();
        int[] result = new int[size];
        boolean inserted = false;
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(bound * 2) - bound;
        }
        result[rand.nextInt(size)] = includeTarget; // 保证至少包含一次目标值
        Arrays.sort(result);
        return result;
    }
}
