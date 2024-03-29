package com.sheik.dsa.d7.prefix_sum;

/**
 * Author: Sheik Syed Ali
 * Date: 29 Mar 2024
 */

import java.util.ArrayList;

/**
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 *
 * Constraints
 * 2 <= length of the array <= 1000
 * 1 <= A[i] <= 10
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [120, 60, 40, 30, 24]
 *
 *  (Approach 1)TC Big (O) = N (pow 2); SC Big (O) = 1
 *  (Approach 2)TC Big (O) = N; SC Big (O) = N
 *
 */
public class ProductArray {

    /**
     * Skip the ith element and multiply the rest of the indexed elements (i != j) then a[i] * multiply
     * (Brute force)
     * TC Big (O) = N(pow 2); SC Big(O): 1
     */
    public ArrayList<Integer> approach1(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();

        for(int i=0; i<A.size(); i++){
            int multiply = 1;
            for(int j=0; j<A.size(); j++){
                if(i != j){
                    multiply = multiply * A.get(j);
                }
            }
            output.add(multiply);
        }
        return output;
    }

    /**
     * Calculate product array from left to right
     * Calculate product array from right to left
     * for skipped index -Take corresponding index value from leftToRight * rightToLeft array
     *
     * TC Big (O) = N; SC Big (O) = N
     */
    public ArrayList<Integer> approach2(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> prodArrLeftToRight = new ArrayList<>();
        ArrayList<Integer> prodArrRightToLeft = new ArrayList<>();

        // Create a product array from left to right
        prodArrLeftToRight.add(A.get(0));
        for(int i=1; i<A.size(); i++){
            prodArrLeftToRight.add(prodArrLeftToRight.get(i-1) * A.get(i));
        }

        //create a product array from right to left
        int index = 1;
        prodArrRightToLeft.add(A.get(A.size()-1));
        for(int i=A.size()-2; i >= 0; i--){
            prodArrRightToLeft.add(prodArrRightToLeft.get(index-1) * A.get(i));
            index++;
        }

        int len = A.size() - 1;
        for(int i=0; i<=len; i++){
            int ridx = i + 1;
            int skipMultiply = 1;
            if(i == 0){
                skipMultiply = prodArrRightToLeft.get(len - ridx);
            } else if(i == len){
                skipMultiply = prodArrLeftToRight.get(i - 1);
            } else {
                skipMultiply = prodArrLeftToRight.get(i - 1) * prodArrRightToLeft.get(len - ridx);
            }
            output.add(skipMultiply);
        }

        return output;
    }

    public static void main(String[] args) {
        ProductArray productArray = new ProductArray();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        productArray.approach2(list);

    }
}
