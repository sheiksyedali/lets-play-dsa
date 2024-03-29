package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

/**
 * Find the smallest length of sub array which contains min and max value of an array
 */
public class MinMaxLeastCountSubArray {

    public void approach1(int[] a){
        int min = a[0];
        int max = a[0];

        //Find min and max value of an array
        for(int i=0; i<a.length; i++){
            if(a[i] > max){
                max = a[i];
            }

            if(a[i] < min){
                min = a[i];
            }
        }


        int minLen = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == min || a[i] == max){
                int countElem = 0;
                for(int j=i+1; j<a.length; j++){
                    if(a[i] < max){ //start from min -> max
                        countElem++;
                        if(a[j] == max){
                            if(minLen == 0){
                                minLen = countElem;
                            }else {
                                if(minLen > countElem){
                                    minLen = countElem;
                                }
                            }
                            countElem = 0;
                            break;
                        }
                    } else { //stat from max -> min
                        if(a[j] < min){
                            countElem++;
                            if(a[j] == min){
                                if(minLen == 0){
                                    minLen = countElem;
                                } else {
                                    if(minLen > countElem){
                                        minLen = countElem;
                                    }
                                }
                                countElem = 0;
                                break;
                            }
                        }
                    }

                }
            }
        }

        System.out.println(minLen);





    }

    public static void main(String[] args) {
        MinMaxLeastCountSubArray subArray = new MinMaxLeastCountSubArray();
        int[] a = {2,2,6,4,5,1,5,2,6,4,1};
        subArray.approach1(a);
    }
}
