package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

/**
 * Print NxM matrix in spiral order
 */
public class PrintNxMSpiral {

    /**
     * Generalize row and column
     * iterate until row and column greater than 1
     * handle last iteration
     * TC O(N pow 2); SC O(1)
     */
    public void approach1(int[][] input, int N, int M){
        int r=0;
        int c=0;

        while (N>1 && M>1){

            //0th row -> left to right
            for(int iter=1; iter<M; iter++){
                System.out.print(input[r][c]+", ");

                c++;
            }
            System.out.println();

            //M-1 th column -> top to bottom
            for(int iter=1; iter<N; iter++){
                System.out.print(input[r][c]+", ");

                r++;
            }
            System.out.println();


            //N-1 row -> right to left
            for(int iter=1; iter<M; iter++){
                System.out.print(input[r][c]+", ");

                c--;
            }
            System.out.println();

            //0th column -> bottom to top
            for(int iter=1; iter<N; iter++){
                System.out.print(input[r][c]+", ");

                r--;
            }
            System.out.println();

            r++;
            c++;

            N -= 2;
            M -= 2;
        }
        if(M>=1 && N>=1){
            if(N == 1){
                while (M >= 1){
                    System.out.print(input[r][c]+", ");
                    M--;
                    c++;
                }
            }

            if(M == 1){
                while (N >= 1){
                    System.out.print(input[r][c]+", ");
                    r++;
                    N--;
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNxMSpiral printNxMSpiral = new PrintNxMSpiral();
//        int[][] input = {
//                {1,2},
//                {3,4},
//                {5,6},
//                {7,8}
//        };
//        int N = 4;
//        int M = 2;

//        int[][] input = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//                {12,11,10},
//                {13,14,15},
//                {16,17,18}
//        };
//        int N = 6;
//        int M = 3;

//        int[][] input = {
//                {1,2,3,4},
//                {5,6,7,8}
//        };
//        int N = 2;
//        int M = 4;

        int[][] input = {
                {1,2,3,4,20,30},
                {5,6,7,8,40,50},
                {9,10,11,12,60,70}
        };
        int N = 3;
        int M = 6;

        printNxMSpiral.approach1(input, N, M);
    }
}
