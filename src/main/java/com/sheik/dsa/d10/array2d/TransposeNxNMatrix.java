package com.sheik.dsa.d10.array2d;

import com.sheik.dsa.util.Utils;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */
public class TransposeNxNMatrix {
    /**
     * Transposing the matrix to new matrix
     * TC: O(N pow 2); SC O(N)
     */
    public void approach1(int[][] matrix, int N){
        int[][] newMatrix = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newMatrix[j][i] = matrix[i][j];
            }
        }

        Utils.printInt2DArray(matrix);
        System.out.println();
        System.out.println("Transposed new matrix");
        Utils.printInt2DArray(newMatrix);
        System.out.println("=====================");
    }

    /**
     * Transpose in same matrix
     * Observation:
     *  Swap row to column in same index value (1,0) swap (0,1)
     *  Iterate it only diagonal
     */
    public void approach2(int[][] matrix, int N){
        Utils.printInt2DArray(matrix);
        System.out.println(

        );
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        Utils.printInt2DArray(matrix);
    }
    public static void main(String[] args) {
        TransposeNxNMatrix transposeNxNMatrix = new TransposeNxNMatrix();

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };
        int N=3;

        transposeNxNMatrix.approach1(matrix, N);
        transposeNxNMatrix.approach2(matrix, N);
    }
}
