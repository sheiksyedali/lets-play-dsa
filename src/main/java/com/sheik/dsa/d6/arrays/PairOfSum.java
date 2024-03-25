package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 24 Mar 2024
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given N array elements, check if there exist a pair(i,j) such tht a[i]+a[j] = k and i !=j
 * Approach 1: Big (O) = N(pow 2)
 */
public class PairOfSum {

    /**
     * Start from first element and iterate through entire array from next element like a[i]+a[i+1]
     * Approach 1: Big (O) = N(pow 2)
     */
    public void approach1(int[] a, int k){
        boolean isPair = false;
        for(int i=0; i<a.length; i++){
            for(int j=1+1; j<a.length; j++){
                if(a[i]+a[j] == k){
                    isPair = true;
                    break;
                }
            }
        }
        System.out.println("(Approach 1): is Pair found: "+isPair);
    }




    public static void main(String[] args) {
        PairOfSum pairOfSum = new PairOfSum();

        int[] a = {3, 2, 1, 4, 6, 8,};
        int k = 10;
        pairOfSum.approach1(a, k);
    }
}
