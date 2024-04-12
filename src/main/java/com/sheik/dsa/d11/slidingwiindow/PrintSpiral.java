package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

/**
 * Print NxN matrix in spiral order
 */
public class PrintSpiral {

    /**
     *
     * Generalize row and column and print it
     *
     * TC O(N); SC O(1)
     */
    public void approach(int[][] matrix, int A){

        int r=0;
        int c=0;
        while (A > 1){
            for(int iter=1; iter<A; iter++) {
                System.out.print(matrix[r][c]+ ", ");

                c++;
            }
            System.out.println();

            //A-1th colum -> top to bottom
            for(int iter=1; iter<A; iter++) {
                System.out.print(matrix[r][c]+", ");

                r++;
            }
            System.out.println();

            //A-1th row -> right to left
            for(int iter=1; iter<A; iter++) {
                System.out.print(matrix[r][c]+", ");

                c--;
            }
            System.out.println();

            //0th column -> bottom -> top
            for(int iter=1; iter<A; iter++){
                System.out.print(matrix[r][c]+", ");

                r--;
            }
            System.out.println();

            r++;
            c++;

            A-=2; // for spiral, if one spiral completed then for next spiral, 2 rows and 2 cols (up and down, left and right) removed
        }

        if(A == 1){
            System.out.println(matrix[r][c]);
        }
    }

    public static void main(String[] args) {
        PrintSpiral printSpiral = new PrintSpiral();
        int input[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int A=3;

        printSpiral.approach(input, A);
    }
}
