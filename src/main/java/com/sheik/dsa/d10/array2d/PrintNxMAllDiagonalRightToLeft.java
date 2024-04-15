package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */

/**
 * Given NxM matrix print all diagonal from right to left
 */
public class PrintNxMAllDiagonalRightToLeft {
    /**
     *  Observation:
     *      Right to left then column value decreased row increased
     *      Break the problem into chunks
     *          1. We know how to print single diagonal from right to left
     *          2. Find what are the starting point of diagonal, for this case 0th row and M-1th column
     *          3. Do code for 0th row
     *          4. Do code for M-1th row
     * TC: O(N pow 2); SC: O(1)
     */
    public void approach1(int[][] matrix, int N, int M){
        int r;
        int c;

        //Iterate the starting points in 0th row
        for(int m=0; m<M; m++){
            r=0;
            c=m;
            while (c>=0 && r<N){
                System.out.print(matrix[r][c]+", ");
                c--;
                r++;
            }
            System.out.println();
        }

        //Iterate the starting points in M-1th column
        for(int n=1; n<N; n++){
            r=n;
            c=M-1;
            while (r<N && c>=0){
                System.out.print(matrix[r][c]+", ");
                r++;
                c--;
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        PrintNxMAllDiagonalRightToLeft printNxMAllDiagonalRightToLeft = new PrintNxMAllDiagonalRightToLeft();

        int[][] matrix = {
                {1,2,3,8},
                {4,5,6,9},
                {7,8,9,0}

        };
        int N=3;
        int M=4;

        printNxMAllDiagonalRightToLeft.approach1(matrix, N, M);

    }
}
