package BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class TestFindExact {

    public static void main(String[] args) {
        FindExact finder = new FindExact();
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
                case 4: nums = new int[] {1, 2, 3, 4}; target = 3; break;
                case 5: nums = new int[] {1, 2, 3, 4}; target = 5; break;
                case 6: nums = new int[] {-3, 0, -1, 5}; target = -1; break;
                case 7: nums = new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE}; target = Integer.MAX_VALUE; break;
                case 8: nums = new int[] {1, 3, 3, 5}; target = 3; break;
                case 9: nums = generateRandomArray(10, 100); target = 50; break;
                case 10: nums = generateRandomArray(20, 200); target = -50; break;
                case 11: nums = new int[] {1, 3, 2, 4, 3}; target = 2; break;
                case 12: nums = new int[] {-100, 100, -200, 200}; target = 100; break;
                case 13: nums = new int[] {1, 2, 2, 1}; target = 2; break;
                case 14: nums = new int[] {4, 5, 6, 7, 8}; target = 6; break;
                case 15: nums = generateRandomArray(30, 300); target = 0; break;
                case 16: nums = generateRandomArray(50, 500); target = random.nextInt(1000) - 500; break;
                case 17: nums = new int[] {0, 0, 0, 1}; target = 1; break;
                case 18: nums = new int[] {1, 0, 0, 0}; target = 1; break;
                case 19: nums = new int[] {-1, -5, -3, -2}; target = -3; break;
                case 20: nums = generateRandomArray(25, 1000); target = 999; break;
                default: nums = new int[] {}; target = 0; break;
            }

            Arrays.sort(nums); // ensure array is sorted before binary search

            int result = finder.search(nums, target);
            boolean contains = Arrays.binarySearch(nums, target) >= 0;

            if ((result != -1 && nums[result] == target) || (result == -1 && !contains)) {
                System.out.println("✅ Test " + i + " passed.");
                passed++;
            } else {
                System.out.println("❌ Test " + i + " failed.");
                System.out.println("Array:  " + Arrays.toString(nums));
                System.out.println("Target: " + target);
                System.out.println("Result index: " + result);
            }
        }

        System.out.println("\nTests passed: " + passed + " / " + totalTests);
    }

    private static int[] generateRandomArray(int size, int bound) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(bound * 2) - bound;
        }
        return result;
    }
}
