package com.hugo.binarysearchdemo;

import java.util.*;

public class BinarySearch {

    /**
     * 二分搜尋(查找)法：
     *    二分搜尋法（Binary Search）是一種高效的搜尋算法，它主要用於在有序數組中查找特定元素的位置。該算法通過反覆將目標值與數組中間元素進行比較，
     *    並根據比較結果將搜索範圍逐漸縮小一半，直到找到目標值或者確定目標值不存在為止。
     *
     *
     * 1. 使用前提條件：
     *    數組必須是有序的。這意味著元素按照某種順序（例如升序或降序）排列。如果數組無序，則二分搜尋法無法正確運作。
     *
     * 2. 流程：
     *    1)首先，確定搜尋範圍的起始點和終點，通常起始點為數組的第一個元素的索引，終點為數組的最後一個元素的索引。
     *    2)在每一步中，計算搜尋範圍的中間元素的索引。
     *    3)將目標值與中間元素進行比較：
     *      ．如果目標值等於中間元素，則搜尋結束，返回中間元素的索引。
     *      ．如果目標值小於中間元素，則目標值應該在左半部分，將搜尋範圍縮小為左半部分。
     *      ．如果目標值大於中間元素，則目標值應該在右半部分，將搜尋範圍縮小為右半部分。
     *    4)重複上述步驟，直到搜尋範圍縮小為空，表示目標值不存在於數組中。
     *
     * 3. 時間複雜度：
     *    二分搜尋法的時間複雜度為 O(log n)，其中 n 是數組的元素個數。由於每次比較後，搜尋範圍都會縮小一半，因此算法的搜索速度非常快。
     *
     * 4.注意事項：
     *    1)二分搜尋法僅適用於有序數組。如果數組無序，必須先進行排序操作。
     *    2)若有多個相同目標值，二分搜尋法可能返回其中任意一個目標值的索引。
     *
     * */

    public static void main(String[] args) {
        int[] arr = generateRandomIntArray(15);//隨機生成一個15個不相同的0~100範圍的整數陣列
        Arrays.sort(arr);
        System.out.println("array: " + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入欲查詢的數: ");
        int target = sc.nextInt();
        int index = binarySearch(arr, target);
        if (index == -1)
            System.out.println("查無此數");
        else
            System.out.println("索引為: " + index);

    }


    public static int binarySearch(int[] arr, int target) {
        //left和right為arr[]的最小索引值與最大索引值
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            if (left > right) {
                break;
            }
            int mid = left + ((right - left) / 2);
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    public static int[] generateRandomIntArray(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Array length must be greater than zero.");
        }

        int[] result = new int[length];
        Set<Integer> usedNumbers = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomNum;
            do {
                randomNum = random.nextInt(101); // 生成0~100之間的隨機整數
            } while (usedNumbers.contains(randomNum));

            result[i] = randomNum;
            usedNumbers.add(randomNum);
        }

        return result;
    }
}
