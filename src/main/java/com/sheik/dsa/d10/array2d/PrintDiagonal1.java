package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */

/**
 * Given a matrix NxN and print diagonal right to left
 */
public class PrintDiagonal1 {
    /**
     * Observation:
     *      Row can not exceed  N and Column can not exceed N
     *      If row/column decrement then the last value can not exceed 0
     *      If row/column increment then the last value can not exceed N
     *
     * TC: O(N); SC: O(1)
     */
    public void approach1(int[][] matrix, int N){
        int c=N-1;
        int r=0;
        while (r<N && c>=0){
            System.out.println(matrix[r][c]);
            r++;
            c--;
        }
    }
    public static void main(String[] args) {
        PrintDiagonal1 printDiagonal1 = new PrintDiagonal1();

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };
        int N=3;

        printDiagonal1.approach1(matrix, N);

    }
}
