package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class MySorterTest {

    public static void main(String[] args) {
        RadixSort sorter = new RadixSort();
        Random random = new Random();

        int totalTests = 20;
        int passed = 0;

        for (int i = 1; i <= totalTests; i++) {
            int[] original;

            switch (i) {
                case 1: original = new int[] {}; break;
                case 2: original = new int[] {1}; break;
                case 3: original = new int[] {5, 5, 5, 5}; break;
                case 4: original = new int[] {1, 2, 3, 4}; break;
                case 5: original = new int[] {4, 3, 2, 1}; break;
                case 6: original = new int[] {-3, 0, -1, 5}; break;
                // case 7: original = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE}; break;
                case 8: original = new int[] {3, 1, 3, 1}; break;
                case 9: original = generateRandomArray(10, 100); break;
                case 10: original = generateRandomArray(20, 200); break;
                case 11: original = new int[] {1, 3, 2, 4, 3}; break;
                case 12: original = new int[] {-100, 100, -200, 200}; break;
                case 13: original = new int[] {1, 2, 2, 1}; break;
                case 14: original = new int[] {9, 8, 7, 6, 5, 4}; break;
                case 15: original = generateRandomArray(30, 300); break;
                case 16: original = generateRandomArray(50, 500); break;
                case 17: original = new int[] {0, 0, 0, 1}; break;
                case 18: original = new int[] {1, 0, 0, 0}; break;
                case 19: original = new int[] {-1, -5, -3, -2}; break;
                case 20: original = generateRandomArray(25, 1000); break;
                default: original = new int[] {}; break;
            }

            int[] expected = Arrays.copyOf(original, original.length);
            int[] actual = Arrays.copyOf(original, original.length);

            Arrays.sort(expected);
            sorter.sort(actual);

            if (Arrays.equals(expected, actual)) {
                System.out.println("✅ Test " + i + " passed.");
                passed++;
            } else {
                System.out.println("❌ Test " + i + " failed.");
                System.out.println("Original: " + Arrays.toString(original));
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("Actual:   " + Arrays.toString(actual));
            }
        }

        System.out.println("\nTests passed: " + passed + " / " + totalTests);
    }

    // 随机数组生成
    private static int[] generateRandomArray(int size, int bound) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(bound * 2) - bound; // 范围是 [-bound, bound]
        }
        return result;
    }
}
