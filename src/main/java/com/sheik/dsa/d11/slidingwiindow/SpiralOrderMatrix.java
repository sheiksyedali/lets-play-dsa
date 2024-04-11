package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

import java.util.ArrayList;

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 * Input 1:
 * 1
 * Input 2:
 * 2
 * Input 3:
 * 5
 *
 *
 * Example Output
 * Output 1:
 * [ [1] ]
 *
 * Output 2:
 * [ [1, 2],
 *   [4, 3] ]
 *
 * Output 2:
 * [ [1,   2,  3,  4, 5],
 *   [16, 17, 18, 19, 6],
 *   [15, 24, 25, 20, 7],
 *   [14, 23, 22, 21, 8],
 *   [13, 12, 11, 10, 9] ]
 *
 *
 *
 */
public class SpiralOrderMatrix {

    /**
     * Observation:
     *      Generalize the length of the iteration
     *      iterate four corner for spiral
     *      Watch out increment/decrements
     *
     * TC O(N pow 2); SC O(1)
     */
    public ArrayList<ArrayList<Integer>> approach1(int A) {
        int matrixSize = A;
        int[][] matrix = new int[A][A];
        int r=0;
        int c=0;
        int startValue = 1;

        //Matrix size reduced for one complete spiral by 2, so (N-1), (N-1)-2, (N-1-2)-2... 1/0
        while (matrixSize > 1){
            //Spiral -> row (left to right)
            for(int iter = 1; iter<matrixSize; iter++){
                matrix[r][c] = startValue;
                startValue++;

                c++;
            }

            //Spiral -> colum (top to bottom)
            for(int iter=1; iter<matrixSize; iter++){
                matrix[r][c] = startValue;
                startValue++;

                r++;
            }

            //Spiral -> row (right to left)
            for(int iter=1; iter<matrixSize; iter++){
                matrix[r][c] = startValue;
                startValue++;

                c--;
            }

            //Spiral -> colum (bottom to top)
            for(int iter=1; iter<matrixSize; iter++){
                matrix[r][c] = startValue;
                startValue++;

                r--;
            }

            matrixSize -= 2;
            r++;
            c++;

        }

        if(matrixSize == 1){
            matrix[r][c] = startValue;
        }



        ArrayList<ArrayList<Integer>> outputMatrix = new ArrayList<>();
        for(int i=0; i<A; i++){
            ArrayList<Integer> mat = new ArrayList<>();
            for(int j=0; j<A; j++){
                mat.add(matrix[i][j]);
            }
            outputMatrix.add(mat);
        }

        System.out.println(outputMatrix);

        return outputMatrix;
    }


    public static void main(String[] args) {
        SpiralOrderMatrix spiralOrderMatrix = new SpiralOrderMatrix();
        spiralOrderMatrix.approach1(5);
    }
}
