package com.sheik.dsa.basics;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Mar 2024
 */
public class PerfectSquare {
    public static void main(String[] args) {
        int n = 32;
        perfectSquare(n);
        getSquareRootOrNearestSquare(n);
    }

    static void perfectSquare(int n){
        int i;
        for(i=1; i<=n; i++){
            if(i*i == n){
                break;
            }
        }

        System.out.println("square root: "+i);
    }


    public static void getSquareRootOrNearestSquare(int n){
        int i;
        for(i=1; i<=n; i++){
            int multiplied = i*i;
            if(multiplied == n){
                break;
            } else if(multiplied > n){
                i = i - 1;
                break;
            }
        }
        System.out.println("Square root/nearest square root: "+i);

    }
}
