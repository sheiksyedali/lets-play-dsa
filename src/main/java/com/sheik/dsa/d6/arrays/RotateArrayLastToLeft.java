package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 24 Mar 2024
 */

import java.util.ArrayList;

/**
 * Rotate an array form last to left by k times
 * Approach 1: TC Big (0) = N
 */
public class RotateArrayLastToLeft {

    /**
     * 1. Reverse the entire array
     * 2. Reverse only 0 to k index
     * 3. Reverse k+1 to N-1 index
     *
     * TC: Big (0) = N
     */
    public void approach1(int[] a, int k){
        printArray(a);

        if(k > a.length){
            k = k % a.length;
        }
        a =  reverse(a, 0, a.length-1);
        a = reverse(a, 0, k-1);
        a = reverse(a, k, a.length - 1);

        printArray(a);
    }

    private int[] reverse(int[] a, int left, int right){
        while (left < right){
            int temp = a[left];
            a[left] =  a[right];
            a[right] = temp;
            left++;
            right--;
        }
        return a;
    }

    private void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateArrayLastToLeft array = new RotateArrayLastToLeft();

//        int input[] = {3, -2, 1, 4, 6, 9, 8};
//        int k = 3;
//        array.approach1(input, k);

        ArrayList<Integer> A = new ArrayList<>();
        A.add(6);
        System.out.println(array.solve(A, 6));

    }


    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        if(A.size() == 1){
            return A;
        }
        if(B > A.size()){
            B = B % A.size();
        }
        A = rotate(A, 0, A.size()-1);
        A = rotate(A, 0, B-1);
        A = rotate(A, B, A.size()-1);
        return A;

    }

    public ArrayList<Integer> rotate(ArrayList<Integer> A, int l, int r){
        int temp;
        while(l < r){
            temp = A.get(l);
            A.set(l, A.get(r));
            A.set(r, temp);
            l++;
            r--;
        }
        return A;
    }

}
