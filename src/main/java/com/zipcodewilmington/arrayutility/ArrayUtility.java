package com.zipcodewilmington.arrayutility;


import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>{

    private T[] array;
    private T[] arrMerged;
    private T[] temp;


    public ArrayUtility(T[] inputArray){
        array = inputArray;

    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        Integer counter = 0;
        temp = merge(arrayToMerge);

        for (int i = 0; i < temp.length; i++) {
            if(temp[i].equals(valueToEvaluate)){
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T toRemove){
        Integer counter = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i].equals(toRemove)){
                counter++;
            }
        }
        T[] tempArr = (T[]) Array.newInstance(toRemove.getClass(), array.length-counter);

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(!array[i].equals(toRemove)){
                tempArr[j] = array[i];
                j++;
            }

        }
        return tempArr;
    }


    public Integer getNumberOfOccurrences(T toEvaluate){
        Integer count = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i].equals(toEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        temp = this.merge(arrayToMerge);
        T high = null;
        int highcount = 0;

        for (int i = 0; i < temp.length; i++) {
            int counter = 0;
            for (int j = 1; j < temp.length; j++) {
                if(temp[i].equals(temp[j])){
                    counter++;
                    if(counter > highcount){
                        highcount = counter;
                        high = temp[i];
                    }
                }
            }
        }
        return high;
    }


    public T[] merge(T[] arr){
        int arrLength = array.length + arr.length;
        arrMerged = (T[]) new Object[arrLength];
        int i;
        for(i = 0; i < array.length; i++){
            arrMerged[i] = array[i];
        }
        for (int j = 0; j< arr.length; j++){
            arrMerged[i] = arr[j];
            i++;
        }
        return arrMerged;
    }
}