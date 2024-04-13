package com.sheik.misc;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */

import com.sheik.dsa.util.Utils;

/**
 * Given an ascending order sorted array with duplicates elements. we need to arrange only unique elements first order
 *
 * input:
 * [1,1,2,3,3,4,5]
 *
 * output:
 * [1,2,3,4,5,1,3]
 */
public class ArrangeUniqueElements {


    public void approach1(int[] input){
        Utils.printIntArray(input);
        System.out.println();

        int first=0;
        int next=1;
        int targetIndex = -1;
        int curValue = Integer.MIN_VALUE;

        while (next < input.length) {

            if(input[first] < input[next] && curValue <input[next]){
                curValue = input[next];

                int temp = input[targetIndex];
                input[targetIndex] = input[next];
                input[next] = temp;


                targetIndex++;
            } else {
                if(targetIndex == -1){
                    targetIndex = next;
                }
            }

            first++;
            next++;
        }

        Utils.printIntArray(input);
        System.out.println();
        System.out.println("Total: "+input.length+"; " +
                "duplicates: "+(input.length-1 - targetIndex + 1)
        );
    }

    public static void main(String[] args) {
        ArrangeUniqueElements arrangeUniqueElements = new ArrangeUniqueElements();

        int[] input = {10,10,12,13,13,13,14,15, 15};
        arrangeUniqueElements.approach1(input);
    }
}
