package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

/**
 * Find the a, g pairs in given array.
 * Conditions:
 *  i<j
 *  chars are lower case
 */
public class FindAGPairs {

    public void approach1(char[] a){
        int gCount = 0;
        int pairCount = 0;
        for(int i=a.length-1; i>=0; i--){

           if(a[i] == 'g'){
               gCount++;
           } else if(a[i] == 'a'){
               pairCount = pairCount+ gCount;
           }
        }
        System.out.println("pair count: "+pairCount);
    }

    public static void main(String[] args) {
        FindAGPairs findAGPairs = new FindAGPairs();

        char[] c = {'a', 'd', 'g', 'a', 'g', 'a', 'g', 'f', 'g'};


        findAGPairs.approach1(c);
    }
}
