package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

/**
 * Given NxN integer array and size. Print the boundaries of an array
 * Explanation:
 *      Start printing from 0th row (left to right)
 *      N-1th column top to bottom
 *      N-1th row right to left
 *      0th column bottom to top
 */
public class PrintBoundaryOfArray {

    /**
     * Generalise the length of an array
     *
     * TC O(N); SC O(1)
     *
     */
    public void approach1(int[][] input, int A){

        int r = 0;
        int c = 0;

        //Print 0th array from left to right
        for(int iter=1; iter<A; iter++){
            System.out.print(input[r][c]+", ");

            c++;
        }
        System.out.println();
        //Print A-1th column from top to bottom
        for(int iter=1; iter<A; iter++){
            System.out.print(input[r][c]+", ");

            r++;
        }
        System.out.println();

        //Print A-1th row from right to left
        for(int iter=1; iter<A; iter++){
            System.out.print(input[r][c]+", ");

            c--;
        }
        System.out.println();

        //Print 0th column from bottom to top
        for(int iter=1; iter<A; iter++){
            System.out.print(input[r][c]+", ");

            r--;
        }

    }

    public static void main(String[] args) {
        PrintBoundaryOfArray printBoundaryOfArray = new PrintBoundaryOfArray();

        int input[][] = {
                {1,2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int A = 3;
        printBoundaryOfArray.approach1(input, A);

    }
}
