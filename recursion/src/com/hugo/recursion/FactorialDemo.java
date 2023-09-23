package com.hugo.recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialDemo {
    /**
     * 遞迴: 遞迴是一種算法或函數的設計方法，其中函數可以調用自己來解決更小規模的問題。
     *      遞迴的核心思想是把一個大問題分解成更小的子問題，然後解決子問題，最終合併子問題的解以獲得原始問題的解。
     *
     *
     * 使用要點：
     * 1) 遞迴函數必須定義一個或多個基本情況，這些情況下遞迴停止，並直接返回結果。基本情況通常是問題規模變小到無需遞迴時的情況。
     * 2) 遞迴函數必須包含遞迴步驟，這是函數調用自身來處理子問題的部分。遞迴步驟應該使問題的規模變小，以便最終達到基本情況。
     * 3) 將大問題分解成小問題是遞迴的關鍵。你應該能夠將原始問題分解成相似但規模更小的子問題，這樣遞迴才有意義。
     * 4) 遞迴適用於某些問題，但不是所有問題。有時使用循環可能更有效率和容易理解。在選擇使用遞迴時，要仔細考慮問題的性質和效能需求。
     *
     **/


    //階乘方法 By Recursion
    public static BigInteger factorialByRecursion(int num){
        if( num == 0 || num == 1){
            return BigInteger.ONE;
        }else{
            BigInteger result = BigInteger.valueOf(num); // 使用 BigInteger.valueOf 將 num 轉換為 BigInteger
            return result.multiply(factorialByRecursion(num - 1));
        }
    }

    //階乘方法 By Loop
    public static BigInteger factorialByloop(int num){
        if( num == 0 || num == 1 ){
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for(int i = num ; i > 0 ; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入欲查詢的階乘數: ");
        int target = sc.nextInt();
        // 記錄程式開始時間
        long startTime = System.nanoTime();

        BigInteger result = factorialByRecursion(target);

        // 記錄程式結束時間
        long endTime = System.nanoTime();

        // 計算程式執行時間（納秒）
        long duration = endTime - startTime;

        // 轉換為毫秒
        double milliseconds = (double) duration / 1_000_000;


        System.out.println(target+ "! = "+result);
        System.out.println("程式執行時間：" + milliseconds + " 毫秒");

    }
}
