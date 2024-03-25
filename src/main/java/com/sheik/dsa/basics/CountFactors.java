package com.sheik.dsa.basics;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Mar 2024
 */
public class CountFactors {
    public static void main(String[] args){
        int n = 100000;

        countFactor(n);
        System.out.println();
        countFactorOptimized(n);
    }

    public static void countFactor(int n){
        long startTime = System.currentTimeMillis();
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                System.out.println("Factor: "+i);
                count = count + 1;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Count: "+count);
        System.out.println("Time taken: "+(endTime - startTime));
    }

    public static void countFactorOptimized(int n){
        long startTime = System.currentTimeMillis();
        int count = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                int anotherFactor = n/i;
                if(anotherFactor < i){ //instead of this logic we can try upto sqrt(n) like (i < sqrt(n))
                    break;
                }

                if(anotherFactor == i){
                    System.out.println("Factor: "+i);
                    count = count + 1;
                } else {
                    System.out.println("Factor: "+i);
                    count = count + 2;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Count(optimized): "+count);
        System.out.println("Time taken(optimized): "+(endTime - startTime));
    }

}
