package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */
public class WhatWillBeTheOutput {
    static void fun(int[]arr) {
        arr[3] = 98;
        return;
    }

    public static void main(String args[]) {
        int[]arr = {10,20,30,40,50};
        fun(arr);
        System.out.println(arr[3]);
    }
}
