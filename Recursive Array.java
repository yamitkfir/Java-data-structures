package com.recursive;

import java.util.Arrays;

public class RecursiveArray {
    /*
     .arr הוא מערך של שלמים, לא ריק. הצג אלגוריתמים רקורסיביים לחישוב:
    א. הפריט הגדול ביותר המערך.
    ב. הפריט הקטן ביותר המערך.
    ג. סכום הפריטים במערך.
    ד. מכפלת הפריטים במערך.
    ה. ממוצע הפריטים במערך.
     */

    //this will also get the last int in the array
    public static int recursiveMax(int[] intArray) {
        return recursiveMax2(intArray, intArray[intArray.length - 1]);
    }
    public static int recursiveMax2(int[] intArray, int max) {
        int returned;

        //תנאי יציאה
        if (intArray.length == 1){
            if (max < intArray[0]){
                returned = intArray[0];
            }
            else{
                returned = max;
            }
            return returned;
        }

        else{
            int newmax = Math.max(max, intArray[intArray.length - 1]);
            int[] slice = Arrays.copyOfRange(intArray, 0, intArray.length - 1);
            return recursiveMax2(slice, newmax);
        }
    }

    public static int recursiveMin(int[] intArray) {
        return recursiveMin2(intArray, intArray[intArray.length - 1]);
    }
    public static int recursiveMin2(int[] intArray, int min) {
        int returned;

        //תנאי יציאה
        if (intArray.length == 1){
            if (min > intArray[0]){
                returned = intArray[0];
            }
            else{
                returned = min;
            }
            return returned;
        }

        else{
            int newmin = Math.min(min, intArray[intArray.length - 1]);
            int[] slice = Arrays.copyOfRange(intArray, 0, intArray.length - 1);
            return recursiveMin2(slice, newmin);
        }
    }

    public static int recursiveSum(int[] intArray) {
        return recursiveSum2(intArray, 0);
    }
    public static int recursiveSum2(int[] intArray, int currentsum){
        if (intArray.length == 1){
            return currentsum + intArray[intArray.length - 1];
        }
        else{
            int[] slice = Arrays.copyOfRange(intArray, 0, intArray.length - 1);
            currentsum += intArray[intArray.length - 1];
            return recursiveSum2(slice, currentsum);
        }
    }

    public static int recursiveMultiply(int[] intArray) {
        return recursiveMultiply2(intArray, 1);
    }
    public static int recursiveMultiply2(int[] intArray, int currentmultiply) {
        if (intArray.length == 1){
            return currentmultiply * intArray[intArray.length - 1];
        }
        else{
            int[] slice = Arrays.copyOfRange(intArray, 0, intArray.length - 1);
            currentmultiply *= intArray[intArray.length - 1];
            return recursiveMultiply2(slice, currentmultiply);
        }
    }
    public static double recursiveAverage(int[] intArray) {
        return recursiveSum(intArray) / intArray.length;
    }
}

