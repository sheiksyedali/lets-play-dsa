package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

import com.sheik.dsa.util.Utils;

/**
 * *** Google/Facebook/Amazon ***
 *
 * Given NxN matrix, rotate it 90 degree clockwise. do not use any additional sapces
 */
public class Rotate90DegreeClockwise {
    /**
     * Transpose the given matrix in place then swap all row values
     * TC: O(N pow 2); SC: O(1)
     */
    public void approach1(int[][] input, int N){
        Utils.printInt2DArray(input);
        System.out.println();
        //Transpose the given matrix
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }

        //Reverse each row
        for(int i=0; i<N; i++){
            int s=0;
            int e=N-1;
            while (s<e){
                int temp = input[i][s];
                input[i][s] = input[i][e];
                input[i][e] = temp;

                s++;
                e--;
            }
        }

        Utils.printInt2DArray(input);
    }
    public static void main(String[] args) {
        Rotate90DegreeClockwise rotate90DegreeClockwise = new Rotate90DegreeClockwise();

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };
        int N=3;

        rotate90DegreeClockwise.approach1(matrix, N);
    }
}
