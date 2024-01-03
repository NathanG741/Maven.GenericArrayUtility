package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int count = 0;
        for (T obj : mergeArray(inputArray, arrayToMerge)) {
            if (obj.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int highest = 0;
        T mostCommon = null;
        for (T obj : mergeArray(inputArray, arrayToMerge)) {
            int count = 0;
            for (T object : mergeArray(inputArray, arrayToMerge)) {
                if (obj.equals(object)) {
                    count++;
                }
            }
            if (count > highest) {
                highest = count;
                mostCommon = obj;
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (T obj : inputArray) {
            if (obj.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        int count = getNumberOfOccurrences(valueToRemove);
        int newArrayLength = this.inputArray.length - count;

        Object[] newArray = getObjectClass(valueToRemove, newArrayLength);

        int newArrayIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                newArray[newArrayIndex] = inputArray[i];
                newArrayIndex++;
            }
        }

        return (T[]) newArray;
    }

    private static <T> Object[] getObjectClass(T valueToRemove, int newArrayLength) {
        Object[] newArray;

        if (valueToRemove.getClass().equals(Integer.class)) {
            newArray = new Integer[newArrayLength];
        } else if (valueToRemove.getClass().equals(String.class)) {
            newArray = new String[newArrayLength];
        } else if (valueToRemove.getClass().equals(Long.class)) {
            newArray = new Long[newArrayLength];
        } else {
            newArray = new Object[newArrayLength];
        }

        return newArray;
    }


    private T[] mergeArray(T[] inputArray, T[] arrayToMerge) {
        List<T> mergedArray = new ArrayList<>();
        mergedArray.addAll(Arrays.asList(inputArray));
        mergedArray.addAll(Arrays.asList(arrayToMerge));
        return mergedArray.toArray(inputArray);
    }

}