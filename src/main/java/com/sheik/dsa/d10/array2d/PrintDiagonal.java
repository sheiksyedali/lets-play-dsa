package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */

/**
 * Given a NxN matrix. Print diagonal left - right
 */
public class PrintDiagonal {

    /**
     *
     * Observation:
     *      Row can not exceed N
     *      Column can not exceed M
     *
     * TC: O(N); SC: O(1)
     */
    public void approach1(int[][] matrix, int N, int M){
        int r=0;
        int c=0;
        while (r<N && c<M){
            System.out.println(matrix[r][c]);
            r++;
            c++;
        }
    }
    public static void main(String[] args) {
        PrintDiagonal printDiagonal = new PrintDiagonal();

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };

        int N=3;
        int M=3;

        printDiagonal.approach1(matrix, N, M);
    }
}
