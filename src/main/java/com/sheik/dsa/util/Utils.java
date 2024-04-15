package com.sheik.dsa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Apr 2024
 */
public class Utils {

    public static ArrayList toList(int[] input){
        return (ArrayList) Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void printIntArray(int[] input){
//        Arrays.stream(input).forEach( p -> System.out.println(p));
        for(int i=0; i<input.length; i++){
            System.out.print(input[i]+", ");
        }
    }

    public static void printInt2DArray(int[][] input){
        int rows=input.length;
        int columns=input[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(input[i][j]+", ");
            }
            System.out.println();
        }
    }
}
