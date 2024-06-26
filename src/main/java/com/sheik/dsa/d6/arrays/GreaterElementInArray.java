package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 23 Mar 2024
 */

/**
 * Problem:
 * Given an array of size N, count number of elements having atleast one element greater than itself.
 * input: a[7] = {-3, -2, 6, 8, 4, 8, 5}
 * count = 5
 *
 * Result:
 * approach1:  Big(O) = N(pow 2)
 * approach2:  Big(O) = N
 * approach3:  Big(O) = N
 */
//Notes:
/**
 * count the duplicate for max value during the process if another max element found then we need to add it in total count because it has greater value in array
 * eg: - [1.2,3,3,3,4] then output will be 5
 */
public class GreaterElementInArray {

    /**
     * Brute force algorithm
     */
    public void approach1(int a[]){
        int count = 0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                if(a[i] < a[j]){
                    count++;
                    break;
                }
            }
        }

        System.out.println("(Approach 1) Count:  "+count);
        /**
         * Big O = N(pow 2)
         */
    }

    /**
     * Find max value in array then compare
     */
    public void approach2(int a[]){
        int count = 0;

        // Find max value in array
        int max = a[0]; // **Warning** - Dont initialize 0 because array contains some negative value
        for(int i=1; i<a.length; i++){
            if(a[i] > max) {
                max =  a[i];
            }
        }

        //Compare and find greater element count
        for(int i=0; i<a.length; i++){
            if(a[i] < max){
                count++;
            }
        }

        System.out.println("(Approach 2) Count: "+count);
        /**
         * Big O = N
         */
    }

    /**
     * Single loop approach
     * Observation:
     * Same max value(duplicate) can not count
     * but less than max value can count
     *
     * Big(O) = N
     */
    public void approach3(int[] a){
        int count = 0;
        int max = a[0];
        /**
         * count the duplicate for max value during the process if another max element found then we need to add it in total count because it has greater value in array
         * eg: - [1.2,3,3,3,4] then output will be 5
         */
        int maxDupCount = 0; //
        for(int i=1; i<a.length; i++){
            if(max < a[i]){
                max = a[i];
                count++;
                count = count + maxDupCount;
                maxDupCount = 0;
            } else if(max > a[i]){
                count++;
            } else {
                maxDupCount++;
            }
        }

        System.out.println("(Approach 3) count: "+count);
        /**
         * Big O = N
         */
    }

    /**
     * Observation: Element at least has one greater value itself, it means, max element of array doesn't have greater value
     *              So, find max value of array and count its duplicate
     *              then subtract the duplicate from total length of the array, So, remaining elements has greater values
     *
     * TC Big(O) = N
     */
    public void approach4(int[] a){
        int maxDup = 0;
        int max = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i] > max){
                max = a[i];
                maxDup = 1;
            } else if(a[i] == max){
                maxDup++;
            }
        }
        int count = a.length - maxDup;
        System.out.println("(Approach 4:) count: "+count);

    }


    public static void main(String[] args) {
        GreaterElementInArray greaterElementInArray = new GreaterElementInArray();

//        int a[] = {-3, -2, 6, 8, 4,  5};
//        int a[] = {1, 2, 3};
//        int a[] = {340,18,125,554,32,174,284,633,283,953,841,547,603,269,35,653,777,513,940,504,634,999,797,886,911,205,919,1,844,476,314,741,748,84,938,73,755,886,133,882,203,728,798,536,136,133,77,176,764,163,845,120,36,627,69,413,216,36,512,856,55,280,989,109,841,581,479,779,259,445,789,103,999,654,819,928,529,779,264,188,515,722,814,66,961,948,654,310,326,17,977,161,254,953,287,286,762,843,60,526,455,186,406,613,478,394,201,115,790,696,715,635,430,136,856,743,163,156,543,650,120,476,258,444,193,984,394,938,855,248,42,332,383,109,215,382,355,133,318,527,783,514,846,204,133,748,554,14,162,947,280,40,774,253,412,250,224,430,126,545,192,875,23,668,75,534,57,848,931,334,428,718,620,611,785,712,128,782,499,415,260,863,953,592,625,61,334,570,388,354,345,481,542,156,829,831,908,630,730,782,616,332,634,223,846,859,837,237,984,230,998,683,395,818,763,58,664,931,64,580,580,141,221,892,456,364,436,43,689,548,468,901,361,618,801,258,780,816,505,885,500,477,952,32,294,435,613,407,859,807,139,360,112,573,449,601,678,954,394,522,786,240,310,455,286,581,23,903,143,908,445,704,805,82,347,672,310,410,855,205,818,698,710,967,584,692,229,593,1000,278,785,651,632,290,664,274,800,439,486,415,901,774,578,964,785,677,750,667,697,776,154,102,702,531,617,879,533,969,874,250,207,648,1000,534,89,3,11,905,181,942,117,113,688,278,454,203,434,759,57,367,897,563,564,826,502,426,316,626,646,756,151,942,666,481,680,340,567,618,902,889,527,285,581,125,375,556,323,948,623,94,468,902,93,269,263,223,578,615,551,736,243,750,292,972,41,672,487,252,994,559,737,532,494,785,836,515,250,713,960,623,536,228,616,943,893,358,611,583,170,475,123,847,460,374,217,148,445,5,215,886,480,282,324,376,104,92,988,972,50,348,278,780,318,817,684,34,698,644,126,665,799,948,303,321,874,884,718,327,676,424,151,242,235,604,536,984,799,813,108,7,781,645,867,724,328,939,920,335,307,505,442,541,40,980,563,453,124,840,588,68,40,210,679,1,114,451,508,545,66,564,605,908,645,660,169,62,510,572,788,535,608,972,822,532,373,99,624,659,706,906,354,43,528,385,432,706,77,250,824,5,977,73,517,435,10,34,735,746,392,691,209,161,441,893,514,604,350,143,133,196,844,707,208,516,685,879,729,245,468,486,716,906,676,237,246,533,682,798,566,241};
//
//        int a[] = {340,18,125,554,32,174,284,633,283,953,841,547,
//                603,269,35,653,777,513,940,504,634,999,797,886,911,205,919,1,844,476,314,741,748,84,938,73,755,886,133,882,203,
//                728,798,536,136,133,77,176,764,163,845,120,36,627,69,413,216,36,512,856,
////                55,280,989,109,841,581,479,779,259,445,789,103,
//                999,
//
//                999, 1000
//                };
        int a[] = {1,1,1,1};
//                654,819,928, 529};
//                779,264,188,515,722,814,66,961,948,654,310,326,17,977,161,254,953,287,286,762,843,60,526,455,186,406,613,478,394,201,115,790,696,715,635,430,136,856,743,
//                163,156,543,650,120,476,258,444,193,984,394,938,855,248,42,332,383,109,215,382,355,133,318,527,783,514,846,204,133,748,554,14,162,947,280,40,774,253,
//                412,250,224,430,126,545,192,875,23,668,75,534,57,848,931,334,428,718,620,611,785,712,128,782,499,415,260,863,953,592,625,61,334,570,388,354,345,481,
//                542,156,829,831,908,630,730,782,616,332,634,223,846,859,837,237,984,230,998,683,395,818,763,58,664,931,64,580,580,141,221,892,456,364,436,43,689,
//                548,468,901,361,618,801,258,780,816,505,885,500,477,952,32,294,435,613,407,859,807,139,360,112,573,449,601,678,954,394,522,786,240,310,455,286,
//                581,23,903,143,908,445,704,805,82,347,672,310,410,855,205,818,698,710,967,
//                584,692,229,593};
//                1000};
//                278,785};
//                651,632};
//                290,664,274,800,439,486,415,901,774};
//                578,964,785,677,750,667,697,776,154,102,702,531,617,879,533,969,874,250,207,648,1000,534,89,3,11,905,181,942,117,113,688,278,454,203,434,759,57,367,897,563,564};
//                826,502,426,316,626,646,756,151,942,666,481,680,340,567,618,902,889,527,285,581,125,375,556,323,948,623,94,468,902,93,269,263,223,578,615,551,736,243,750,292,972,41,672,487,252,994,559,737,532,494,785,836,515,250,713,960,623,536,228,616,943,893,358,611,583,170,475,123,847,460,374,217,148,445,5,215,886,480,282,324,376,104,92,988,972,50,348,278,780,318,817,684,34,698,644,126,665,799,948,303,321,874,884,718,327,676,424,151,242,235,604,536,984,799,813,108,7,781,645,867,724,328,939,920,335,307,505,442,541,40,980,563,453,124,840,588,68,40,210,679,1,114,451,508,545,66,564,605,908,645,660,169,62,510,572,788,535,608,972,822,532,373,99,624,659,706,906,354,43,528,385,432,706,77,250,824,5,977,73,517,435,10,34,735,746,392,691,209,161,441,893,514,604,350,143,133,196,844,707,208,516,685,879,729,245,468,486,716,906,676,237,246,533,682,798,566,241};

        int b[] = {1,2,3,1000, 4, 1000};

        long startTime = System.currentTimeMillis();
        greaterElementInArray.approach1(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Approach 1 taken time: "+ (endTime - startTime));

        startTime = System.currentTimeMillis();
        greaterElementInArray.approach2(a);
        endTime = System.currentTimeMillis();
        System.out.println("Approach 2 taken time: "+ (endTime - startTime));


        startTime = System.currentTimeMillis();
        greaterElementInArray.approach3(a);
        endTime = System.currentTimeMillis();
        System.out.println("Approach 3 taken time: "+ (endTime - startTime));

        startTime = System.currentTimeMillis();
        greaterElementInArray.approach4(a);
        endTime = System.currentTimeMillis();
        System.out.println("Approach 4 taken time: "+ (endTime - startTime));

    }
}
